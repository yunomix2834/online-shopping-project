package com.gatewayserver.dto.request.variant;

public record VariantCreateRequestBody(
    String productId,
    String sku,
    String price,
    String originalPrice) {}
