package com.core.dto.request.gateway.product;

public record ProductCreateRequestBody(
    String name,
    String slug,
    String description,
    String brandId) {
}
