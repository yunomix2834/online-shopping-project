package com.gatewayserver.dto.request.cart;

public record CartAddItemBody(
    String userId,
    String variantId,
    Integer quantity
) {}
