package com.gatewayserver.dto.response.authentication;

public record LoginView(
        String accessToken,
        String refreshToken,
        String accessExpiry,
        String refreshExpiry) {
}