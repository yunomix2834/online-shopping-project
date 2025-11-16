package com.core.dto.request.user;


import jakarta.validation.constraints.NotBlank;
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
public class AddressCreateRequestDto {
  @NotBlank
  String contactName;

  @NotBlank
  String contactPhone;

  @NotBlank
  String addressLine1;
  String addressLine2;

  @NotBlank
  String district;

  @NotBlank
  String city;

  String country;
  String postalCode;
}
