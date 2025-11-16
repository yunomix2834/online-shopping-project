package com.core.service;

import com.core.dto.request.otp.OtpVerificationRequestDto;
import com.core.dto.request.otp.UserOtpRequestDto;
import com.core.dto.response.otp.OtpResponseDto;

public interface IOtpService {

  OtpResponseDto sendOtp(UserOtpRequestDto userOtpRequestDto);

  void verifyOtp(OtpVerificationRequestDto otpVerificationRequestDto);
}
