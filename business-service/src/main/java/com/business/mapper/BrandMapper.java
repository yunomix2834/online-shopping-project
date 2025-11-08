package com.business.mapper;

import com.business.dto.request.BrandCreateRequestDto;
import com.business.dto.request.BrandUpdateRequestDto;
import com.business.dto.response.BrandResponseDto;
import com.business.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BrandMapper {
    Brand toBrandFromBrandCreateRequestDto(
            BrandCreateRequestDto brandCreateRequestDto);

    void patchBrandFromBrandUpdateRequestDto(
            @MappingTarget Brand brand,
            BrandUpdateRequestDto brandUpdateRequestDto
    );

    BrandResponseDto toBrandResponseDtoFromBrand(
            Brand brand
    );
}