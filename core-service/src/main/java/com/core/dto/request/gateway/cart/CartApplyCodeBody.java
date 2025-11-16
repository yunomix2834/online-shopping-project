package com.core.dto.request.gateway.cart;

public record CartApplyCodeBody(
    String userId,
    String code,
    String at
) {
}
