package com.gatewayserver.dto.request.order;

public record OrderPatchChargesBody(
    String shippingFee,
    String paymentMethodName,
    String shippingMethodName
) {}
