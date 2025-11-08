package com.gatewayserver.dto.request.discount;

public record DiscountListRequestBody(
    Boolean onlyEffective,
    String at,
    Integer page,
    Integer size) {}
