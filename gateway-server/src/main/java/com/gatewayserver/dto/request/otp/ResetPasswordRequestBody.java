package com.gatewayserver.dto.request.otp;

public record ResetPasswordRequestBody(
        String email,
        String otp,
        String newPassword) {
}
