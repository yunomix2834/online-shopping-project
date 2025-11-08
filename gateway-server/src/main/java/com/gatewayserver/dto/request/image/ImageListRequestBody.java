package com.gatewayserver.dto.request.image;

public record ImageListRequestBody(
    String productId,
    String variantId,
    Integer page,
    Integer size) {}
