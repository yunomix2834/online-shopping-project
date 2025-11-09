package com.gatewayserver.dto.response.order;

import java.math.BigDecimal;

public record OrderItemView(
    String id,
    String variantId,
    String sku,
    String productName,
    BigDecimal price,
    Integer quantity,
    BigDecimal lineTotal
) {}
