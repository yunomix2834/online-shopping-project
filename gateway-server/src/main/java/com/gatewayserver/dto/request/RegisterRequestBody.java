package com.gatewayserver.dto.request;

public record RegisterRequestBody(
        String username,
        String email,
        String password){}

