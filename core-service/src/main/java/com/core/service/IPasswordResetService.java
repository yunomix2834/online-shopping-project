package com.core.service;

import com.core.dto.request.otp.OtpVerificationRequestDto;
import com.core.dto.request.otp.ResetPasswordRequestDto;
import com.core.dto.request.otp.UserOtpRequestDto;
import com.core.dto.response.otp.OtpResponseDto;

public interface IPasswordResetService {

    OtpResponseDto requestResetPassword(
            UserOtpRequestDto userOtpRequestDto);

    void verifyOtpPassword(
            OtpVerificationRequestDto otpVerificationRequestDto);

    void resetPassword(
            ResetPasswordRequestDto resetPasswordRequestDto);
}
