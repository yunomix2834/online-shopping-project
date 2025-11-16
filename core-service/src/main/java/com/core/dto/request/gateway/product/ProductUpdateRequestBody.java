package com.core.dto.request.gateway.product;

public record ProductUpdateRequestBody(
    String name,
    String slug,
    String description,
    String brandId) {
}
