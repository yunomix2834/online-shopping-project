package com.core.dto.request.gateway.authentication;

public record LoginRequestBody(
    String username,
    String email,
    String password) {
}
