package com.business.mapper;

import com.business.dto.request.AttributeCreateRequestDto;
import com.business.dto.response.AttributeResponseDto;
import com.business.entity.Attribute;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AttributeMapper {
  Attribute toAttributeFromAttributeCreateRequestDto(
      AttributeCreateRequestDto dto);
  AttributeResponseDto toAttributeResponseDtoFromAttribute(
      Attribute a);
}
