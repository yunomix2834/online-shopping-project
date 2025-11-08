package com.gatewayserver.dto.request.brand;

public record BrandCreateRequestBody(
        String name,
        String slug,
        String description) {}
