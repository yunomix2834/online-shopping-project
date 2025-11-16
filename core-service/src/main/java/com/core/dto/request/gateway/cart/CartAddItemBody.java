package com.core.dto.request.gateway.cart;

public record CartAddItemBody(
    String userId,
    String variantId,
    Integer quantity
) {
}
