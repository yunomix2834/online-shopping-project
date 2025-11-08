package com.gatewayserver.dto.request.discount;

public record DiscountCreateRequestBody(
    String code,
    String type,
    String value,
    String startDate,
    String endDate,
    String minOrderValue,
    Boolean isActive) {}
