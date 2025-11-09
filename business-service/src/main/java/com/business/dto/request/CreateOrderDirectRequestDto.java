package com.business.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDirectRequestDto {
  String userId;
  String shippingAddress;
  String billingAddress;
  String paymentMethodName;
  String shippingMethodName;
  String discountCode;
  List<Line> lines;
  @Data @Builder @NoArgsConstructor @AllArgsConstructor
  public static class Line {
    String variantId;
    Integer quantity;
  }
}
