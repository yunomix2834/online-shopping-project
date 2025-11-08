package com.gatewayserver.dto.request.variant;

public record VariantListByProductBody(
    String productId,
    Integer page,
    Integer size) {}
