package com.core.service.impl;

import com.core.dto.request.otp.OtpSendRequestDto;
import com.core.dto.request.otp.OtpVerificationRequestDto;
import com.core.dto.request.otp.ResetPasswordRequestDto;
import com.core.dto.request.otp.UserOtpRequestDto;
import com.core.dto.response.otp.OtpResponseDto;
import com.core.entity.User;
import com.core.entity.otp.PasswordResetToken;
import com.core.repository.UserRepository;
import com.core.repository.otp.PasswordResetTokenRepository;
import com.core.service.IPasswordResetService;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PasswordResetServiceImpl
        implements IPasswordResetService {

    JavaMailSender mailSender;
    UserRepository userRepository;
    PasswordResetTokenRepository tokenRepository;
    PasswordEncoder passwordEncoder;

    @Value("${spring.mail.username}")
    @NonFinal
    String EMAIL;

    @Value("${app.password-reset.expiry-minutes:15}")
    @NonFinal
    int PASSWORD_EXPIRY_MINUTES;

    @Override
    public OtpResponseDto requestResetPassword(
            UserOtpRequestDto request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));

        String otp = genOtp();
        Instant expiry = Instant.now()
                .plus(PASSWORD_EXPIRY_MINUTES, ChronoUnit.MINUTES);

        PasswordResetToken token = tokenRepository.findByEmail(user.getEmail())
                .map(t -> {
                    t.setOtpCode(otp);
                    t.setExpiryTime(expiry);
                    t.setConsumed(false);
                    return t;
                })
                .orElse(PasswordResetToken.builder()
                        .email(user.getEmail())
                        .otpCode(otp)
                        .expiryTime(expiry)
                        .consumed(false)
                        .build());

        tokenRepository.save(token);

        OtpSendRequestDto otpSendRequestDto = OtpSendRequestDto.builder()
                .email(user.getEmail())
                .otpCode(otp)
                .build();
        sendEmail(otpSendRequestDto);

        return OtpResponseDto.builder()
                .email(user.getEmail())
                .message("Password reset OTP sent successfully!")
                .build();
    }

    @Override
    public void verifyOtpPassword(
            OtpVerificationRequestDto request) {
        PasswordResetToken token =
                tokenRepository.findByEmail(request.getEmail())
                        .orElseThrow(() -> new AppException(
                                ErrorCode.RESOURCE_NOT_FOUND));

        if (token.isConsumed()) {
            throw new AppException(ErrorCode.INVALID_OTP);
        }
        if (!token.getOtpCode().equals(request.getOtpCode())) {
            throw new AppException(ErrorCode.INVALID_OTP);
        }
        if (Instant.now().isAfter(token.getExpiryTime())) {
            throw new AppException(ErrorCode.OTP_EXPIRED);
        }
    }

    @Override
    public void resetPassword(ResetPasswordRequestDto request) {
        PasswordResetToken token =
                tokenRepository.findByEmail(request.getEmail())
                        .orElseThrow(() -> new AppException(
                                ErrorCode.RESOURCE_NOT_FOUND));

        if (token.isConsumed()) {
            throw new AppException(ErrorCode.INVALID_OTP);
        }
        if (!token.getOtpCode().equals(request.getOtp())) {
            throw new AppException(ErrorCode.INVALID_OTP);
        }
        if (Instant.now().isAfter(token.getExpiryTime())) {
            throw new AppException(ErrorCode.OTP_EXPIRED);
        }

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));

        user.setPasswordHash(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);

        token.setConsumed(true);
        tokenRepository.save(token);
    }

    void sendEmail(OtpSendRequestDto request) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(EMAIL);
            message.setTo(request.getEmail());
            message.setSubject("Đặt lại mật khẩu");
            message.setText("Mã OTP đặt lại mật khẩu của bạn là: " +
                    request.getOtpCode()
                    + "\nMã có hiệu lực trong " + PASSWORD_EXPIRY_MINUTES +
                    " phút");
            mailSender.send(message);
        } catch (Exception e) {
            throw new AppException(ErrorCode.EMAIL_SEND_FAILED);
        }
    }

    String genOtp() {
        return String.format("%06d", new Random().nextInt(999999));
    }
}
