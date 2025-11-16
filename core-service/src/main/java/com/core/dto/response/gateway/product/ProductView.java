package com.core.dto.response.gateway.product;

public record ProductView(
    String id,
    String name,
    String slug,
    String description,
    String status,
    String brandId) {
}
