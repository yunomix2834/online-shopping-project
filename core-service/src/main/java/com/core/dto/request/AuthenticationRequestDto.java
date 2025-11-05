package com.core.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AuthenticationRequestDto {

    @Size(min = 4, message = "username không hợp lệ, phải > 4 ký tự")
    String username;

    @Email(message = "email không hợp lệ")
    String email;

    @NotBlank(message = "password bắt buộc")
    @Size(min = 8, message = "password >= 8")
    String password;
}
