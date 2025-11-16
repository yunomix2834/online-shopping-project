package com.core.dto.request.gateway.discount;

public record DiscountCodeRequestBody(
    String code,
    String orderValue,
    String at) {
}
