package com.gatewayserver.dto.response.variant;

public record VariantView(
    String id,
    String productId,
    String sku,
    String price,
    String originalPrice) {}
