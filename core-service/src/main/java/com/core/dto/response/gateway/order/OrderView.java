package com.core.dto.response.gateway.order;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record OrderView(
    String id,
    String userId,
    String status,           // PENDING/PROCESSING/...
    BigDecimal subtotal,
    BigDecimal discountAmount,
    BigDecimal shippingFee,
    BigDecimal totalAmount,
    String shippingAddress,
    String billingAddress,
    String paymentMethodName,
    String shippingMethodName,
    String discountCode,
    Instant createdAt,
    List<OrderItemView> items
) {
}
