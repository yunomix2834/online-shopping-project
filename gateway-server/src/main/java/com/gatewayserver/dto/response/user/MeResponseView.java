package com.gatewayserver.dto.response.user;


public record MeResponseView (
    String id,
    String username,
    String email,
    String fullName,
    String phoneNumber,
    Boolean isActive,
    Boolean isVerified){
}