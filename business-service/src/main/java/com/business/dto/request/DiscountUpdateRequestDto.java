package com.business.dto.request;

import com.business.constant.DiscountType;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountUpdateRequestDto {
  String code;
  DiscountType type;
  BigDecimal value;
  Instant startDate;
  Instant endDate;
  BigDecimal minOrderValue;
  Boolean active;
}
