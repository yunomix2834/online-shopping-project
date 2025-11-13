package com.business.service.impl;

import com.business.constant.OrderStatus;
import com.business.dto.request.CreateOrderDirectRequestDto;
import com.business.dto.request.CreateOrderFromCartRequestDto;
import com.business.dto.response.OrderItemResponseDto;
import com.business.dto.response.OrderResponseDto;
import com.business.entity.CartItem;
import com.business.entity.Order;
import com.business.entity.OrderItem;
import com.business.entity.ProductVariant;
import com.business.helper.AuthenticationHelper;
import com.business.mapper.OrderMapper;
import com.business.repository.CartItemsRepository;
import com.business.repository.OrderItemsRepository;
import com.business.repository.OrdersRepository;
import com.business.repository.ProductVariantsRepository;
import com.business.service.IDiscountService;
import com.business.service.IOrderService;
import com.business.service.OrderPricingRule;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements IOrderService {

  OrdersRepository ordersRepository;
  OrderItemsRepository orderItemsRepository;
  ProductVariantsRepository productVariantsRepository;
  CartItemsRepository cartItemsRepository;
  OrderPricingRule pricingRule;
  IDiscountService discountService;
  OrderMapper orderMapper;

  @Override
  @Transactional
  public OrderResponseDto createFromCart(
      CreateOrderFromCartRequestDto dto) {
    List<CartItem> cart = cartItemsRepository
        .listWithSnapshot(dto.getUserId());
    if (cart.isEmpty()) {
      throw new AppException(ErrorCode.VALIDATION_FAILED);
    }

    // snapshot + totals
    Totals t = totalsFromCart(cart, dto.getDiscountCode());

    Order o = Order.builder()
        .userId(dto.getUserId())
        .status(OrderStatus.pending)
        .subtotal(t.subtotal)
        .shippingFee(t.shipping)
        .discountAmount(t.discount)
        .totalAmount(t.total)
        .shippingAddress(dto.getShippingAddress())
        .billingAddress(Objects.toString(dto.getBillingAddress(), ""))
        .paymentMethodName(dto.getPaymentMethodName())
        .shippingMethodName(dto.getShippingMethodName())
        .discountCode(dto.getDiscountCode())
        .build();
    o = ordersRepository.save(o);

    for (CartItem ci : cart) {
      ProductVariant v = ci.getVariant();
      orderItemsRepository.save(OrderItem.builder()
          .order(o)
          .variant(v)
          .sku(v.getSku())
          .productName(v.getProduct().getName())
          .quantity(ci.getQuantity())
          .price(v.getPrice())
          .build());
    }

    // clear cart
    cartItemsRepository.deleteAllByUserId(dto.getUserId());
    return getDetail(o.getId());
  }

  @Override
  @Transactional
  public OrderResponseDto createDirect(
      CreateOrderDirectRequestDto dto) {
    if (dto.getLines() == null || dto.getLines().isEmpty()) {
      throw new AppException(ErrorCode.VALIDATION_FAILED);
    }

    BigDecimal subtotal = BigDecimal.ZERO;
    for (var line : dto.getLines()) {
      ProductVariant v = productVariantsRepository.findById(line.getVariantId())
          .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
      subtotal = subtotal.add(v.getPrice()
          .multiply(new BigDecimal(line.getQuantity())));
    }
    BigDecimal shipping = pricingRule.shippingFor(subtotal);
    BigDecimal discount = discountAmount(dto.getDiscountCode(), subtotal);
    BigDecimal total = subtotal.add(shipping).subtract(discount);

    Order o = ordersRepository.save(Order.builder()
        .userId(dto.getUserId())
        .status(OrderStatus.pending)
        .subtotal(subtotal)
        .shippingFee(shipping)
        .discountAmount(discount)
        .totalAmount(total)
        .shippingAddress(dto.getShippingAddress())
        .billingAddress(Objects.toString(dto.getBillingAddress(), ""))
        .paymentMethodName(dto.getPaymentMethodName())
        .shippingMethodName(dto.getShippingMethodName())
        .discountCode(dto.getDiscountCode())
        .build());

    for (var line : dto.getLines()) {
      ProductVariant v = productVariantsRepository.findById(line.getVariantId())
          .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
      orderItemsRepository.save(OrderItem.builder()
          .order(o)
          .variant(v)
          .sku(v.getSku())
          .productName(v.getProduct().getName())
          .quantity(line.getQuantity())
          .price(v.getPrice())
          .build());
    }
    return getDetail(o.getId());
  }

  @Override
  @Transactional(readOnly = true)
  public OrderResponseDto getDetail(String id) {
    Order o = ordersRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    List<OrderItemResponseDto> items = orderItemsRepository
        .listByOrder(id)
        .stream()
        .map(orderMapper::toOrderItemResponseDtoFromOrderItem)
        .toList();
    return OrderResponseDto.builder()
        .id(o.getId())
        .userId(o.getUserId())
        .status(o.getStatus())
        .subtotal(o.getSubtotal())
        .discountAmount(o.getDiscountAmount())
        .shippingFee(o.getShippingFee())
        .totalAmount(o.getTotalAmount())
        .shippingAddress(o.getShippingAddress())
        .billingAddress(o.getBillingAddress())
        .paymentMethodName(o.getPaymentMethodName())
        .shippingMethodName(o.getShippingMethodName())
        .discountCode(o.getDiscountCode())
        .createdAt(o.getCreatedAt())
        .items(items)
        .build();
  }

  @Override
  @Transactional(readOnly = true)
  public Envelope.Page<OrderResponseDto> list(
      String userId,
      OrderStatus status,
      Instant from,
      Instant to,
      int page, int size) {
    Page<Order> p = ordersRepository.filter(
        userId,
        status,
        from, to,
        PageRequest.of(page, size));
    List<OrderResponseDto> docs = p.getContent()
        .stream()
        .map(o -> getDetail(o.getId()))
        .toList();
    return Envelope.okPage(
        p.getNumber(),
        p.getSize(),
        p.getTotalElements(),
        p.getTotalPages(),
        docs)
        .getData();
  }

  @Override
  @Transactional
  public void updateStatus(
      String id,
      OrderStatus toStatus) {
    AuthenticationHelper.requireAdmin();
    Order o = ordersRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));

    switch (o.getStatus()) {
      case pending -> {
        if (toStatus != OrderStatus.processing && toStatus != OrderStatus.cancelled)
          throw new AppException(ErrorCode.VALIDATION_FAILED);
      }
      case processing -> {
        if (toStatus != OrderStatus.shipped && toStatus != OrderStatus.cancelled)
          throw new AppException(ErrorCode.VALIDATION_FAILED);
      }
      case shipped -> {
        if (toStatus != OrderStatus.completed)
          throw new AppException(ErrorCode.VALIDATION_FAILED);
      }
      case completed, cancelled ->
          throw new AppException(ErrorCode.VALIDATION_FAILED);
    }
    o.setStatus(toStatus);
    ordersRepository.save(o);
  }

  @Override
  @Transactional
  public void cancel(String id) {
    Order o = ordersRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    if (o.getStatus() != OrderStatus.pending && o.getStatus() != OrderStatus.processing)
      throw new AppException(ErrorCode.VALIDATION_FAILED);
    o.setStatus(OrderStatus.cancelled);
    ordersRepository.save(o);
  }

  @Override @Transactional
  public void patchCharges(
      String id,
      BigDecimal shippingFee,
      String paymentMethodName,
      String shippingMethodName) {
    AuthenticationHelper.requireAdmin();
    Order o = ordersRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    if (shippingFee!=null) {
      o.setShippingFee(shippingFee);
    }
    if (paymentMethodName!=null) {
      o.setPaymentMethodName(paymentMethodName);
    }
    if (shippingMethodName!=null) {
      o.setShippingMethodName(shippingMethodName);
    }

    o.setTotalAmount(o.getSubtotal()
        .add(o.getShippingFee())
        .subtract(o.getDiscountAmount()));
    ordersRepository.save(o);
  }

  @Override
  @Transactional
  public void applyOrSwapCode(String id, String code) {
    Order o = ordersRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    BigDecimal discount = discountAmount(code, o.getSubtotal());
    o.setDiscountCode(code);
    o.setDiscountAmount(discount);
    o.setTotalAmount(o.getSubtotal()
        .add(o.getShippingFee())
        .subtract(discount));
    ordersRepository.save(o);
  }

  private Totals totalsFromCart(
      List<CartItem> cart,
      String code) {
    BigDecimal subtotal = cart.stream()
        .map(ci -> ci.getVariant()
            .getPrice()
            .multiply(new BigDecimal(ci.getQuantity())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);
    BigDecimal shipping = pricingRule.shippingFor(subtotal);
    BigDecimal discount = discountAmount(code, subtotal);
    BigDecimal total = subtotal.add(shipping).subtract(discount);
    return new Totals(subtotal, shipping, discount, total);
  }

  private BigDecimal discountAmount(
      String code,
      BigDecimal subtotal) {
    if (code == null || code.isBlank()) return BigDecimal.ZERO;
    var v = discountService.validateAndAmount(code, subtotal, Instant.now());
    return v.isValid() ? v.getAmount() : BigDecimal.ZERO;
  }

  record Totals(
      BigDecimal subtotal,
      BigDecimal shipping,
      BigDecimal discount,
      BigDecimal total) {}
}
