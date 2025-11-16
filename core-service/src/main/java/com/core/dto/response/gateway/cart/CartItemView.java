package com.core.dto.response.gateway.cart;

import java.math.BigDecimal;

public record CartItemView(
    String id,
    String variantId,
    String sku,
    String productName,
    BigDecimal price,
    Integer quantity,
    BigDecimal lineTotal
) {
}
