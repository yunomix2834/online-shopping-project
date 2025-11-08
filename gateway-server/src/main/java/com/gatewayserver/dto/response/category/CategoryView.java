package com.gatewayserver.dto.response.category;

public record CategoryView(
        String id,
        String name,
        String slug,
        String description,
        String parentId) {}