package com.core.dto.request.gateway.order;

public record OrderPatchChargesBody(
    String shippingFee,
    String paymentMethodName,
    String shippingMethodName
) {
}
