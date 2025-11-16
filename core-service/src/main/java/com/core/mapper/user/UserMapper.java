package com.core.mapper.user;

import com.core.dto.request.authentication.UserCreationRequestDto;
import com.core.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UserMapper {

  @Mapping(source = "password", target = "passwordHash")
  User toUserFromUserCreationRequestDto(
      UserCreationRequestDto userCreationRequestDto);
}
