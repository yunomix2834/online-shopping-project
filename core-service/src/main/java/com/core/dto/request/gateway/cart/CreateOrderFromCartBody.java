package com.core.dto.request.gateway.cart;

public record CreateOrderFromCartBody(
    String userId,
    String shippingAddress,
    String billingAddress,
    String paymentMethodName,
    String shippingMethodName,
    String discountCode
) {
}
