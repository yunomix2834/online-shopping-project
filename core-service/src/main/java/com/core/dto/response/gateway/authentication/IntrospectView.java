package com.core.dto.response.gateway.authentication;

public record IntrospectView(
    boolean valid,
    String userId) {
}
