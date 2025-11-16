package com.core.dto.request.gateway.cart;

public record CartMergeBody(
    String fromUserId,
    String toUserId
) {
}
