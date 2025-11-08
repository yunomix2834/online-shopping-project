package com.gatewayserver.dto.request.attribute;

public record AttributeListRequestBody(
    String q,
    Integer page,
    Integer size) {}
