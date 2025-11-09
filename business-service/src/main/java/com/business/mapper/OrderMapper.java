package com.business.mapper;

import com.business.dto.response.OrderItemResponseDto;
import com.business.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderMapper {
  @Mapping(source = "variant.id", target = "variantId")
  @Mapping(source = "sku", target = "sku")
  @Mapping(source = "productName", target = "productName")
  @Mapping(source = "price", target = "price")
  @Mapping(target = "lineTotal", expression = "java(oi.getPrice().multiply(new java.math.BigDecimal(oi.getQuantity())))")
  OrderItemResponseDto toOrderItemResponseDtoFromOrderItem(OrderItem oi);
}
