package com.core.dto.request.gateway.variant;

public record VariantUpdateRequestBody(
    String sku,
    String price,
    String originalPrice) {
}
