package com.gatewayserver.dto.request.order;

public record CreateOrderFromCartBody(
    String userId,
    String shippingAddress,
    String billingAddress,
    String paymentMethodName,
    String shippingMethodName,
    String discountCode
) {}
