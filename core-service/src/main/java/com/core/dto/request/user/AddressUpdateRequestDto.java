package com.core.dto.request.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
public class AddressUpdateRequestDto {
    String contactName;
    String contactPhone;
    String addressLine1;
    String addressLine2;
    String district;
    String city;
    String country;
    String postalCode;
}