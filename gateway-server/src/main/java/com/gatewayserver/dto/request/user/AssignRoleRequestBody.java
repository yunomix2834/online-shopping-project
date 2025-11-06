package com.gatewayserver.dto.request.user;

public record AssignRoleRequestBody (
    String userId,
    String roleName){
}
