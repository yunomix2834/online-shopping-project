package com.core.dto.response.gateway.otp;

public record OtpResponseView(
    String email,
    String message
) {
}
