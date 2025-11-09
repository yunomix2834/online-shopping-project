package com.gatewayserver.dto.request.order;

import java.util.List;

public record CreateOrderDirectBody(
    String userId,
    String shippingAddress,
    String billingAddress,
    String paymentMethodName,
    String shippingMethodName,
    String discountCode,
    List<Line> lines
){
  public record Line(String variantId, Integer quantity) {}
}
