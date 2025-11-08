package com.gatewayserver.dto.response.image;

public record ImageView(
    String id,
    String productId,
    String variantId,
    String imageUrl,
    Boolean isThumbnail) {}
