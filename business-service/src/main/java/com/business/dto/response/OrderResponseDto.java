package com.business.dto.response;

import com.business.constant.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
  String id;
  String userId;
  OrderStatus status;
  BigDecimal subtotal;
  BigDecimal discountAmount;
  BigDecimal shippingFee;
  BigDecimal totalAmount;
  String shippingAddress;
  String billingAddress;
  String paymentMethodName;
  String shippingMethodName;
  String discountCode;
  Instant createdAt;
  List<OrderItemResponseDto> items;
}
