package com.gatewayserver.dto.response;

public record RefreshView(
        String accessToken,
        String refreshToken,
        String accessExpiry,
        String refreshExpiry) {}
