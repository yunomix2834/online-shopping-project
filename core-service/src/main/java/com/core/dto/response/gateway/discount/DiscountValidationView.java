package com.core.dto.response.gateway.discount;

public record DiscountValidationView(
    Boolean valid,
    String reason,
    String discountAmount) {
}
