package com.core.dto.request.gateway.otp;

public record ResetPasswordRequestBody(
    String email,
    String otp,
    String newPassword) {
}
