package com.gatewayserver.dto.response;

public record LoginView(
        String accessToken,
        String refreshToken,
        String accessExpiry,
        String refreshExpiry) {}