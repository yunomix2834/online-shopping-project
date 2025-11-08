package com.gatewayserver.dto.response.brand;

public record BrandView(
        String id,
        String name,
        String slug,
        String description) {}