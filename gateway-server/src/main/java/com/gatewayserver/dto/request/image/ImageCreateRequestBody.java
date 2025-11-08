package com.gatewayserver.dto.request.image;

public record ImageCreateRequestBody(
    String productId,
    String variantId,
    String imageUrl) {}
