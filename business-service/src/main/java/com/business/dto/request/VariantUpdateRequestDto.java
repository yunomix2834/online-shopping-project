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
public class VariantUpdateRequestDto {
  String sku;
  BigDecimal price;
  BigDecimal originalPrice;
}
