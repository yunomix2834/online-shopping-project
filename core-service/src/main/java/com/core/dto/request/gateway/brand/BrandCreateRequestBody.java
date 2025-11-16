package com.core.dto.request.gateway.brand;

public record BrandCreateRequestBody(
    String name,
    String slug,
    String description) {
}
