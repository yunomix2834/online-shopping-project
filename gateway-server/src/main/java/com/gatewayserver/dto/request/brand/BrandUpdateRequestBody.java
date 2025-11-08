package com.gatewayserver.dto.request.brand;

public record BrandUpdateRequestBody(
        String name,
        String slug,
        String description) {}
