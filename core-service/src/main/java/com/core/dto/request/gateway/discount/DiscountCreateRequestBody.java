package com.core.dto.request.gateway.discount;

public record DiscountCreateRequestBody(
    String code,
    String type,
    String value,
    String startDate,
    String endDate,
    String minOrderValue,
    Boolean isActive) {
}
