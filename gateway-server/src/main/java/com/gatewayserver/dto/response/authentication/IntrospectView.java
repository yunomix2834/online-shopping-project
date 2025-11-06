package com.gatewayserver.dto.response.authentication;

public record IntrospectView(
        boolean valid,
        String userId) {
}