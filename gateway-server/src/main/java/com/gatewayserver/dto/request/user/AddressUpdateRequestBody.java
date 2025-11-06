package com.gatewayserver.dto.request.user;

public record AddressUpdateRequestBody (
    String contactName,
    String contactPhone,
    String addressLine1,
    String addressLine2,
    String district,
    String city,
    String country,
    String postalCode){
}