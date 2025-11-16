package com.core.dto.response.gateway.authentication;

public record RefreshView(
    String accessToken,
    String refreshToken,
    String accessExpiry,
    String refreshExpiry) {
}
