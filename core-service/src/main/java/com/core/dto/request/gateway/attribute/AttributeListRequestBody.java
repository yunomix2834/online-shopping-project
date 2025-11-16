package com.core.dto.request.gateway.attribute;

public record AttributeListRequestBody(
    String q,
    Integer page,
    Integer size) {
}
