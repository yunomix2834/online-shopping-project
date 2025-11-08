package com.gatewayserver.dto.request.attribute;

public record AttributeListByVariantBody(
    String variantId,
    Integer page,
    Integer size) {}
