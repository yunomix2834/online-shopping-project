package com.business.mapper;

import com.business.dto.request.ImageCreateRequestDto;
import com.business.dto.response.ImageResponseDto;
import com.business.entity.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductImageMapper {
  @Mapping(source = "productId", target = "product.id")
  @Mapping(source = "variantId", target = "variant.id")
  ProductImage toProductImageFromImageCreateRequestDto(ImageCreateRequestDto dto);
  @Mappings({
      @Mapping(source = "product.id", target = "productId"),
      @Mapping(source = "variant.id", target = "variantId"),
      @Mapping(source = "thumbnail", target = "thumbnail")
  })
  ImageResponseDto toImageResponseDtoFromProductImage(ProductImage i);
}
