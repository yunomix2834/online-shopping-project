package com.business.service.impl;

import com.business.dto.response.CartItemResponseDto;
import com.business.dto.response.CartResponseDto;
import com.business.entity.Cart;
import com.business.entity.CartItem;
import com.business.entity.ProductVariant;
import com.business.mapper.CartMapper;
import com.business.repository.CartItemsRepository;
import com.business.repository.CartsRepository;
import com.business.repository.ProductVariantsRepository;
import com.business.service.ICartService;
import com.business.service.IDiscountService;
import com.business.service.OrderPricingRule;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartServiceImpl implements ICartService {

  CartsRepository cartsRepository;
  CartItemsRepository cartItemsRepository;
  ProductVariantsRepository productVariantsRepository;
  OrderPricingRule orderPricingRule;           // bean tính shipping fee (simple)
  IDiscountService discountService;
  CartMapper cartMapper;

  @Override
  @Transactional
  public CartResponseDto getOrCreate(
      String userId) {
    cartsRepository.findById(userId).orElseGet(() -> {
      Cart c = Cart.builder().id(null).build();
      c.setDeletedAt(null);
      c.setDeletedBy(null);
      c.setCreatedBy(userId);
      c.setUserId(userId);
      return cartsRepository.save(c);
    });
    return list(userId);
  }

  @Override
  @Transactional
  public void addItem(
      String userId,
      String variantId,
      int quantity) {
    if (quantity <= 0) quantity = 1;
    cartsRepository.findById(userId).orElseGet(() -> cartsRepository.save(Cart.builder()
        .userId(userId)
        .build()));
    ProductVariant v = productVariantsRepository.findById(variantId)
        .orElseThrow(() -> new AppException(ErrorCode.VARIANT_NOT_FOUND));
    CartItem ci = cartItemsRepository.findByUserAndVariant(userId, variantId)
        .orElse(null);
    if (ci == null) {
      ci = CartItem.builder()
          .userId(userId)
          .variant(v)
          .quantity(quantity)
          .build();
    } else {
      ci.setQuantity(ci.getQuantity() + quantity);
    }
    cartItemsRepository.save(ci);
  }

  @Override
  @Transactional
  public void updateQty(
      String cartItemId,
      int quantity) {
    if (quantity <= 0) {
      removeItem(cartItemId); return;
    }
    CartItem ci = cartItemsRepository.findById(cartItemId)
        .orElseThrow(() -> new AppException(ErrorCode.ATTRIBUTE_NOT_FOUND)); // dùng code 404 chung
    ci.setQuantity(quantity);
    cartItemsRepository.save(ci);
  }

  @Override @Transactional
  public void removeItem(String cartItemId) {
    if (!cartItemsRepository.existsById(cartItemId))
      throw new AppException(ErrorCode.ATTRIBUTE_NOT_FOUND);
    cartItemsRepository.deleteById(cartItemId);
  }

  @Override
  @Transactional
  public void clear(String userId) {
    cartItemsRepository.deleteAllByUserId(userId);
  }

  @Override
  @Transactional(readOnly = true)
  public CartResponseDto list(String userId) {
    List<CartItem> rows = cartItemsRepository.listWithSnapshot(userId);
    List<CartItemResponseDto> docs = rows.stream()
        .map(cartMapper::toCartItemResponseDtoFromCartItem)
        .toList();
    BigDecimal subtotal = docs.stream()
        .map(CartItemResponseDto::getLineTotal)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    BigDecimal shipping = orderPricingRule.shippingFor(subtotal);
    BigDecimal discount = BigDecimal.ZERO;
    BigDecimal total = subtotal.add(shipping).subtract(discount);
    return CartResponseDto.builder()
        .userId(userId)
        .items(docs)
        .subtotal(subtotal)
        .shippingFee(shipping)
        .discountAmount(discount)
        .total(total)
        .build();
  }

  @Override
  @Transactional(readOnly = true)
  public CartResponseDto applyCode(
      String userId,
      String code,
      Instant at) {
    CartResponseDto base = list(userId);
    if (code == null || code.isBlank()) {
      return base;
    }
    var v = discountService.validateAndAmount(
        code,
        base.getSubtotal(),
        at == null ? Instant.now() : at);
    BigDecimal discount = v.isValid()
        ? v.getAmount()
        : BigDecimal.ZERO;
    BigDecimal total = base.getSubtotal()
        .add(base.getShippingFee())
        .subtract(discount);
    base.setDiscountAmount(discount);
    base.setTotal(total);
    return base;
  }

  @Override
  @Transactional
  public void merge(
      String fromUserId,
      String toUserId) {
    if (Objects.equals(fromUserId, toUserId)) return;
    cartsRepository.findById(toUserId)
        .orElseGet(() -> cartsRepository.save(Cart.builder()
            .userId(toUserId)
            .build()));
    List<CartItem> from = cartItemsRepository.listWithSnapshot(fromUserId);
    for (CartItem ci : from) {
      addItem(
          toUserId,
          ci.getVariant().getId(),
          ci.getQuantity());
    }
    cartItemsRepository.deleteAllByUserId(fromUserId);
  }
}
