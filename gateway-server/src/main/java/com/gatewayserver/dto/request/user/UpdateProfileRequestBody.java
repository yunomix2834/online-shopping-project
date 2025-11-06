package com.gatewayserver.dto.request.user;

public record UpdateProfileRequestBody (
    String fullName,
    String phoneNumber){
}