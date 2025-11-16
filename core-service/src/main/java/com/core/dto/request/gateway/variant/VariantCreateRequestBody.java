package com.core.dto.request.gateway.variant;

public record VariantCreateRequestBody(
    String productId,
    String sku,
    String price,
    String originalPrice) {
}
