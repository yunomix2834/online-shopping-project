package com.core.dto.response.gateway.authentication;

public record LoginView(
    String accessToken,
    String refreshToken,
    String accessExpiry,
    String refreshExpiry) {
}
