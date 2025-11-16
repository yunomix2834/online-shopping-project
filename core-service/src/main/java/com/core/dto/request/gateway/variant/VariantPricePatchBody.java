package com.core.dto.request.gateway.variant;

public record VariantPricePatchBody(
    String price,
    String originalPrice) {
}
