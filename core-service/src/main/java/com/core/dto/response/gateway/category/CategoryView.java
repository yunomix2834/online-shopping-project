package com.core.dto.response.gateway.category;

public record CategoryView(
    String id,
    String name,
    String slug,
    String description,
    String parentId) {
}
