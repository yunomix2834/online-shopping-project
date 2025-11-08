package com.business.mapper;

import com.business.dto.request.DiscountCreateRequestDto;
import com.business.dto.request.DiscountUpdateRequestDto;
import com.business.dto.response.DiscountResponseDto;
import com.business.entity.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DiscountMapper {
  Discount toDiscountFromDiscountCreateRequestDto(DiscountCreateRequestDto dto);
  void patchDiscountFromDiscountUpdateRequestDto(
      @MappingTarget Discount target,
      DiscountUpdateRequestDto dto);
  DiscountResponseDto toDiscountResponseDtoFromDiscount(
      Discount d);
}
