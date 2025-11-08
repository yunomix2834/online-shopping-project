package com.gatewayserver.dto.request.product;
public record AssignCategoryRequestBody(
        String productId,
        String categoryId) {}
