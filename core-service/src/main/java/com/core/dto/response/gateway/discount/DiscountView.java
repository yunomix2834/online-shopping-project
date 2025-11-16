package com.core.dto.response.gateway.discount;

public record DiscountView(
    String id,
    String code,
    String type,
    String value,
    String startDate,
    String endDate,
    String minOrderValue,
    Boolean isActive) {
}
