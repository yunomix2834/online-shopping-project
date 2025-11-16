package com.core.dto.request.gateway.category;

public record CategoryUpdateRequestBody(
    String name,
    String slug,
    String description) {
}
