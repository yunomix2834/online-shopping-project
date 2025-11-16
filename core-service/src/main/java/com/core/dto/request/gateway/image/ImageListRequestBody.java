package com.core.dto.request.gateway.image;

public record ImageListRequestBody(
    String productId,
    String variantId,
    Integer page,
    Integer size) {
}
