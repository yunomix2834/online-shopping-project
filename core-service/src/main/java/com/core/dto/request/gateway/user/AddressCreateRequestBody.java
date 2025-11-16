package com.core.dto.request.gateway.user;


public record AddressCreateRequestBody(
    String contactName,
    String contactPhone,
    String addressLine1,
    String addressLine2,
    String district,
    String city,
    String country,
    String postalCode) {
}
