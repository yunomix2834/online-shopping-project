package com.core.mapper.gateway;


import com.common.grpc.OrderItemView;
import com.common.grpc.OrderView;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderMapper {

  @Mapping(target = "status", expression = "java(src.getStatus().name())")
  @Mapping(target = "subtotal", expression = "java(new BigDecimal(src.getSubtotal()))")
  @Mapping(target = "discountAmount", expression = "java(new BigDecimal(src.getDiscountAmount()))")
  @Mapping(target = "shippingFee", expression = "java(new BigDecimal(src.getShippingFee()))")
  @Mapping(target = "totalAmount", expression = "java(new BigDecimal(src.getTotalAmount()))")
  @Mapping(target = "createdAt", expression = "java(Instant.parse(src.getCreatedAt()))")
  @Mapping(target = "items", expression = "java(toOrderItemViews(src.getItemsList()))")
  com.core.dto.response.gateway.order.OrderView toOrderView(OrderView src);

  default List<com.core.dto.response.gateway.order.OrderItemView> toOrderItemViews(
      List<OrderItemView> items) {
    return items.stream()
        .map(this::toOrderItemView)
        .toList();
  }

  @Mapping(target = "price", expression = "java(new BigDecimal(src.getPrice()))")
  @Mapping(target = "lineTotal", expression = "java(new BigDecimal(src.getLineTotal()))")
  com.core.dto.response.gateway.order.OrderItemView toOrderItemView(OrderItemView src);
}
