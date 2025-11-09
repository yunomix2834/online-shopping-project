package com.business.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDto {
  String userId;
  List<CartItemResponseDto> items;
  BigDecimal subtotal;
  BigDecimal discountAmount;
  BigDecimal shippingFee;
  BigDecimal total;
}
