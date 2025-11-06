package com.gatewayserver.dto.request.otp;

public record OtpVerificationRequestBody(
        String email,
        String otpCode) {
}
