package com.core.mapper.gateway;


import com.common.grpc.CartItemView;
import com.common.grpc.CartView;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CartMapper {

  /* gRPC -> HTTP View */
  @Mapping(target = "items", expression = "java(toCartItemViews(grpc.getItemsList()))")
  @Mapping(target = "subtotal", expression = "java(new BigDecimal(grpc.getSubtotal()))")
  @Mapping(target = "discountAmount", expression = "java(new BigDecimal(grpc.getDiscountAmount()))")
  @Mapping(target = "shippingFee", expression = "java(new BigDecimal(grpc.getShippingFee()))")
  @Mapping(target = "total", expression = "java(new BigDecimal(grpc.getTotal()))")
  com.core.dto.response.gateway.cart.CartView toCartView(CartView grpc);

  default List<com.core.dto.response.gateway.cart.CartItemView> toCartItemViews(
      List<CartItemView> list) {
    return list.stream()
        .map(this::toCartItemView)
        .toList();
  }

  @Mapping(target = "price", expression = "java(new BigDecimal(src.getPrice()))")
  @Mapping(target = "lineTotal", expression = "java(new BigDecimal(src.getLineTotal()))")
  com.core.dto.response.gateway.cart.CartItemView toCartItemView(CartItemView src);
}
