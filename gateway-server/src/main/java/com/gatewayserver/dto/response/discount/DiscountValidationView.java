package com.gatewayserver.dto.response.discount;

public record DiscountValidationView(
    Boolean valid,
    String reason,
    String discountAmount) {}
