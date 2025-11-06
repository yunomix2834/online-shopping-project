package com.core.dto.request.user;

import jakarta.validation.constraints.Size;
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
public class UpdateProfileRequestDto {
    @Size(min = 1, max = 100)
    String fullName;

    @Size(min = 9, max = 15)
    String phoneNumber;
}