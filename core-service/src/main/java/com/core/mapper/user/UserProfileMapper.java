package com.core.mapper.user;

import com.core.dto.request.user.UpdateProfileRequestDto;
import com.core.dto.response.user.MeResponseDto;
import com.core.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserProfileMapper {

  MeResponseDto toMeResponseDtoFromUser(
      User user);

  void patchUserFromUpdateProfileRequestDto(
      @MappingTarget User user,
      UpdateProfileRequestDto updateProfileRequestDto);
}
