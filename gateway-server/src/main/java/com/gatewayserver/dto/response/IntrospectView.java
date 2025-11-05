package com.gatewayserver.dto.response;

public record IntrospectView(
        boolean valid,
        String userId) {}