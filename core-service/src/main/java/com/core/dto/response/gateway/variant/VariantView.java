package com.core.dto.response.gateway.variant;

public record VariantView(
    String id,
    String productId,
    String sku,
    String price,
    String originalPrice) {
}
