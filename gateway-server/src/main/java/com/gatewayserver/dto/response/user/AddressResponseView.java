package com.gatewayserver.dto.response.user;


public record AddressResponseView (
    String id,
    String contactName,
    String contactPhone,
    String addressLine1,
    String addressLine2,
    String district,
    String city,
    String country,
    String postalCode,
    Boolean isDefaultShipping,
    Boolean isDefaultBilling){
}