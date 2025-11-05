package com.gatewayserver.dto.request;

public record LoginRequestBody(
        String username,
        String email,
        String password){}
