package com.core.dto.response.user;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressResponseDto {
  String id;
  String contactName;
  String contactPhone;
  String addressLine1;
  String addressLine2;
  String district;
  String city;
  String country;
  String postalCode;
  Boolean isDefaultShipping;
  Boolean isDefaultBilling;
}
