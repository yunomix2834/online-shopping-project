package com.business.mapper;

import com.business.dto.request.ProductCreateRequestDto;
import com.business.dto.request.ProductUpdateRequestDto;
import com.business.dto.response.ProductResponseDto;
import com.business.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProductMapper {
    Product toProductFromProductCreateRequestDto(
            ProductCreateRequestDto productCreateRequestDto);
    void patchProductFromProductUpdateRequestDto(
            @MappingTarget Product target,
            ProductUpdateRequestDto dto
    );
    @Mapping(source = "brand.id", target = "brandId")
    ProductResponseDto toProductResponseDtoFromProduct(
            Product product);
}