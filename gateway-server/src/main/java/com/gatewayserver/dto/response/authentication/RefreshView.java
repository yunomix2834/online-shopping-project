package com.gatewayserver.dto.response.authentication;

public record RefreshView(
        String accessToken,
        String refreshToken,
        String accessExpiry,
        String refreshExpiry) {
}
