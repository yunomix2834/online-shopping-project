package com.business.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemResponseDto {
  String id;
  String variantId;
  String sku;
  String productName;
  BigDecimal price;
  Integer quantity;
  BigDecimal lineTotal;
}
