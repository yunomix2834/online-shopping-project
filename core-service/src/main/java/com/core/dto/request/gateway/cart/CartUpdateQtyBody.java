package com.core.dto.request.gateway.cart;

public record CartUpdateQtyBody(
    String cartItemId,
    Integer quantity
) {
}
