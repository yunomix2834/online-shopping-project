package com.gatewayserver.dto.response.otp;

public record OtpResponseView(
        String email,
        String message
) {
}
