package com.gatewayserver.dto.request.product;

public record ProductCreateRequestBody(
        String name,
        String slug,
        String description,
        String brandId) {}