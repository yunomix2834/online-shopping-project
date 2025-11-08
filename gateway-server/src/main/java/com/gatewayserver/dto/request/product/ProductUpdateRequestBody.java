package com.gatewayserver.dto.request.product;

public record ProductUpdateRequestBody(
        String name,
        String slug,
        String description,
        String brandId) {}