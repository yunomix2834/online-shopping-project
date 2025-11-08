package com.gatewayserver.dto.request.discount;

public record DiscountUpdateRequestBody(
    String code,
    String type,
    String value,
    String startDate,
    String endDate,
    String minOrderValue,
    Boolean isActive) {}
