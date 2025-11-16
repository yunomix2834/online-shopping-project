package com.core.dto.request.gateway.discount;

public record DiscountListRequestBody(
    Boolean onlyEffective,
    String at,
    Integer page,
    Integer size) {
}
