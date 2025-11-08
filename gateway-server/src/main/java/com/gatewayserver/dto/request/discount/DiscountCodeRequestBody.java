package com.gatewayserver.dto.request.discount;

public record DiscountCodeRequestBody(
    String code,
    String orderValue,
    String at) {}
