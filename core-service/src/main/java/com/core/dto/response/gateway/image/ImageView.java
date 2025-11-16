package com.core.dto.response.gateway.image;

public record ImageView(
    String id,
    String productId,
    String variantId,
    String imageUrl,
    Boolean isThumbnail) {
}
