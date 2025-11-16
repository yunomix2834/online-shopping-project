package com.core.dto.request.gateway.image;

public record ImageCreateRequestBody(
    String productId,
    String variantId,
    String imageUrl) {
}
