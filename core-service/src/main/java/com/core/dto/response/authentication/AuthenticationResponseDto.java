package com.core.dto.response.authentication;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponseDto {

    String accessToken;
    String refreshToken;
    Instant accessExpiry;
    Instant refreshExpiry;
}
