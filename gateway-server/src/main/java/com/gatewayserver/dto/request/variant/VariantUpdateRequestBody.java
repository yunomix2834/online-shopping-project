package com.gatewayserver.dto.request.variant;

public record VariantUpdateRequestBody(
    String sku,
    String price,
    String originalPrice) {}
