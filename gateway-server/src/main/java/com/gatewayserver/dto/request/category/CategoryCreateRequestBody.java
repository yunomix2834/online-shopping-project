package com.gatewayserver.dto.request.category;

public record CategoryCreateRequestBody(
        String name,
        String slug,
        String description,
        String parentId) {}
