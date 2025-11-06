package com.core.dto.response.user;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MeResponseDto {
    String id;
    String username;
    String email;
    String fullName;
    String phoneNumber;
    Boolean isActive;
    Boolean isVerified;
}