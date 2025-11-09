package com.business.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartAddItemRequestDto {
  String userId;
  String variantId;
  Integer quantity;
}
