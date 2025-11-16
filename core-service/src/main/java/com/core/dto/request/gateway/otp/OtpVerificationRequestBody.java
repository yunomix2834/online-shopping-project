package com.core.dto.request.gateway.otp;

public record OtpVerificationRequestBody(
    String email,
    String otpCode) {
}
