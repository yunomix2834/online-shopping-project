package com.core.dto.request.gateway.variant;

public record VariantListByProductBody(
    String productId,
    Integer page,
    Integer size) {
}
