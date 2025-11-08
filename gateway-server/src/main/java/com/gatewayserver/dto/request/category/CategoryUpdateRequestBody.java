package com.gatewayserver.dto.request.category;

public record CategoryUpdateRequestBody(
        String name,
        String slug,
        String description) {}
