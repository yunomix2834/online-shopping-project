package com.core.dto.request.gateway.category;

public record CategoryCreateRequestBody(
    String name,
    String slug,
    String description,
    String parentId) {
}
