package com.core.dto.request.gateway.attribute;

public record AttributeListByVariantBody(
    String variantId,
    Integer page,
    Integer size) {
}
