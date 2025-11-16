package com.core.dto.request.gateway.brand;

public record BrandUpdateRequestBody(
    String name,
    String slug,
    String description) {
}
