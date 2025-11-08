package com.gatewayserver.dto.request.variant;

public record VariantPricePatchBody(
    String price,
    String originalPrice) {}
