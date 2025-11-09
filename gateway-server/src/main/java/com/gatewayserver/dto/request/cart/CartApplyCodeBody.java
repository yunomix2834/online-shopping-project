package com.gatewayserver.dto.request.cart;

public record CartApplyCodeBody(
    String userId,
    String code,
    String at
) {}
