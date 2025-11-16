package com.core.dto.request.gateway.authentication;

public record RegisterRequestBody(
    String username,
    String email,
    String password) {
}

