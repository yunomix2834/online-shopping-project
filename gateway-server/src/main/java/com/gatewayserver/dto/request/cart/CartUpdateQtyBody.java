package com.gatewayserver.dto.request.cart;

public record CartUpdateQtyBody(
    String cartItemId,
    Integer quantity
) {}
