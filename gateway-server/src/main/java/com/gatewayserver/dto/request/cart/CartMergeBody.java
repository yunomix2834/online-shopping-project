package com.gatewayserver.dto.request.cart;

public record CartMergeBody(
    String fromUserId,
    String toUserId
) {}
