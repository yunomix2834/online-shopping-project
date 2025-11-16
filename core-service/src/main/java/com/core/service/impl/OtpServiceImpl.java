package com.core.service.impl;

import com.core.dto.request.otp.OtpSendRequestDto;
import com.core.dto.request.otp.OtpVerificationRequestDto;
import com.core.dto.request.otp.UserOtpRequestDto;
import com.core.dto.response.otp.OtpResponseDto;
import com.core.entity.User;
import com.core.entity.otp.OtpVerification;
import com.core.repository.UserRepository;
import com.core.repository.otp.OtpVerificationRepository;
import com.core.service.IOtpService;
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
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class OtpServiceImpl implements IOtpService {

  JavaMailSender mailSender;
  OtpVerificationRepository otpVerificationRepository;
  UserRepository userRepository;

  @Value("${app.otp.expiry-minutes}")
  @NonFinal
  protected int OTP_VERIFY_MINUTES;

  @Value("${spring.mail.username}")
  @NonFinal
  protected String EMAIL;

  @Override
  public OtpResponseDto sendOtp(
      UserOtpRequestDto request) {
    String otpCode = generateOtp();
    Instant expiryTime = Instant.now()
        .plus(OTP_VERIFY_MINUTES,
            ChronoUnit.MINUTES);

    OtpVerification otp = otpVerificationRepository
        .findByEmail(request.getEmail())
        .map(existing -> {
          existing.setOtpCode(otpCode);
          existing.setExpiryTime(expiryTime);
          existing.setVerified(false);
          return existing;
        })
        .orElseGet(() -> OtpVerification.builder()
            .email(request.getEmail())
            .otpCode(otpCode)
            .expiryTime(expiryTime)
            .verified(false)
            .build());
    otpVerificationRepository.save(otp);

    OtpSendRequestDto otpSendRequestDto = OtpSendRequestDto.builder()
        .email(request.getEmail())
        .otpCode(otpCode)
        .build();
    sendEmail(otpSendRequestDto);

    return OtpResponseDto.builder()
        .email(request.getEmail())
        .message("OTP sent successfully")
        .build();
  }

  void sendEmail(OtpSendRequestDto request) {
    try {
      SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom(EMAIL);
      message.setFrom(EMAIL);
      message.setTo(request.getEmail());
      message.setSubject("Xác minh tài khoản");
      message.setText("Mã OTP của bạn là: " + request.getOtpCode()
          + "\nMã có hiệu lực trong " + OTP_VERIFY_MINUTES + " phút");
      mailSender.send(message);
      log.info("OTP sent to: {}",
          request.getEmail());
    } catch (Exception e) {
      log.error("Failed to send OTP email",
          e);
      throw new AppException(ErrorCode.EMAIL_SEND_FAILED);
    }
  }

  @Override
  public void verifyOtp(OtpVerificationRequestDto request) {
    OtpVerification otp = otpVerificationRepository
        .findByEmail(request.getEmail())
        .orElseThrow(
            () -> new AppException(ErrorCode.RESOURCE_NOT_FOUND)
        );

    if (!otp.getOtpCode().equals(request.getOtpCode())) {
      throw new AppException(ErrorCode.INVALID_OTP);
    }

    if (Instant.now().isAfter(otp.getExpiryTime())) {
      throw new AppException(ErrorCode.OTP_EXPIRED);
    }

    User user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));

    user.setIsVerified(true);
    userRepository.save(user);

    otp.setVerified(true);
    otpVerificationRepository.save(otp);

  }

  String generateOtp() {
    Random random = new Random();
    return String.format("%06d",
        random.nextInt(999999));
  }

}
