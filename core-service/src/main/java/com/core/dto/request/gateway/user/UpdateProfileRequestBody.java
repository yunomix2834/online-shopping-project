package com.core.dto.request.gateway.user;

public record UpdateProfileRequestBody(
    String fullName,
    String phoneNumber) {
}
