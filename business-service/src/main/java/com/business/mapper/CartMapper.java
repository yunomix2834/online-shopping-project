package com.business.mapper;

import com.business.dto.response.CartItemResponseDto;
import com.business.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CartMapper {
  @Mapping(source = "variant.id", target = "variantId")
  @Mapping(source = "variant.sku", target = "sku")
  @Mapping(source = "variant.product.name", target = "productName")
  @Mapping(target = "price", expression = "java(ci.getVariant().getPrice())")
  @Mapping(target = "lineTotal", expression = "java(ci.getVariant().getPrice().multiply(new java.math.BigDecimal(ci.getQuantity())))")
  CartItemResponseDto toCartItemResponseDtoFromCartItem(CartItem ci);
}
