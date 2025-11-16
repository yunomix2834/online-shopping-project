package com.core.dto.response.authentication;

import java.time.Instant;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponseDto {

  String accessToken;
  String refreshToken;
  Instant accessExpiry;
  Instant refreshExpiry;
}
