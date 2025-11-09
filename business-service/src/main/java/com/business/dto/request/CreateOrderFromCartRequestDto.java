package com.business.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderFromCartRequestDto {
  String userId;
  String shippingAddress;
  String billingAddress;
  String paymentMethodName;
  String shippingMethodName;
  String discountCode;
}
