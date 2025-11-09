package com.business.service;

import com.business.dto.response.CartResponseDto;
import java.time.Instant;

public interface ICartService {
  CartResponseDto getOrCreate(
      String userId);
  void addItem(
      String userId,
      String variantId,
      int quantity);
  void updateQty(
      String cartItemId,
      int quantity);
  void removeItem(
      String cartItemId);
  void clear(
      String userId);

  CartResponseDto list(
      String userId);
  CartResponseDto applyCode(
      String userId,
      String code,
      Instant at);
  void merge(
      String fromUserId,
      String toUserId);
}
