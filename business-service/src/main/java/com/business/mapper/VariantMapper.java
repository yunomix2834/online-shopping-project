package com.business.mapper;

import com.business.dto.request.VariantCreateRequestDto;
import com.business.dto.request.VariantUpdateRequestDto;
import com.business.dto.response.VariantResponseDto;
import com.business.entity.ProductVariant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface VariantMapper {
  @Mapping(source = "productId", target = "product.id")
  ProductVariant toVariantFromVariantCreateRequestDto(
      VariantCreateRequestDto dto);
  void patchVariantFromVariantUpdateRequestDto(
      @MappingTarget ProductVariant target,
      VariantUpdateRequestDto dto);
  @Mapping(source = "product.id", target = "productId")
  VariantResponseDto toVariantResponseDtoFromVariant(
      ProductVariant v);
}
