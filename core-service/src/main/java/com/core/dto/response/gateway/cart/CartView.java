package com.core.dto.response.gateway.cart;

import java.math.BigDecimal;
import java.util.List;

public record CartView(
    String userId,
    List<CartItemView> items,
    BigDecimal subtotal,
    BigDecimal discountAmount,
    BigDecimal shippingFee,
    BigDecimal total
) {
}
