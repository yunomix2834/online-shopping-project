package com.business.dto.request;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VariantCreateRequestDto {
  String productId;
  String sku;
  BigDecimal price;
  BigDecimal originalPrice;
}
