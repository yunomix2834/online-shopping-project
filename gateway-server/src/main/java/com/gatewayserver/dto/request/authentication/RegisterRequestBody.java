package com.gatewayserver.dto.request.authentication;

public record RegisterRequestBody(
        String username,
        String email,
        String password) {
}

