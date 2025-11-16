package com.core.dto.request.gateway.user;

public record AssignRoleRequestBody(
    String userId,
    String roleName) {
}
