package com.business.service;

import com.business.constant.OrderStatus;
import com.business.dto.request.CreateOrderDirectRequestDto;
import com.business.dto.request.CreateOrderFromCartRequestDto;
import com.business.dto.response.OrderResponseDto;
import org.common.http.Envelope;
import java.math.BigDecimal;
import java.time.Instant;

public interface IOrderService {
  OrderResponseDto createFromCart(
      CreateOrderFromCartRequestDto dto);
  OrderResponseDto createDirect(
      CreateOrderDirectRequestDto dto);
  OrderResponseDto getDetail(String id);
  Envelope.Page<OrderResponseDto> list(
      String userId,
      OrderStatus status,
      Instant from, Instant to,
      int page, int size);
  void updateStatus(
      String id,
      OrderStatus toStatus);   // requireAdmin for PROCESSING/SHIPPED/COMPLETED
  void cancel(String id);      // user: only PENDING/PROCESSING
  void patchCharges(
      String id,
      BigDecimal shippingFee,
      String paymentMethodName,
      String shippingMethodName);
  void applyOrSwapCode(
      String id,
      String code);
}
