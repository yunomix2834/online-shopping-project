package com.core.dto.request.gateway.product;

public record AssignCategoryRequestBody(
    String productId,
    String categoryId) {
}
