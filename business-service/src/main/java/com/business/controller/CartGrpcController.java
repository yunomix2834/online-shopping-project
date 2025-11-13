package com.business.controller;

import com.business.dto.response.CartItemResponseDto;
import com.business.dto.response.CartResponseDto;
import com.business.mapper.CartMapper;
import com.business.service.ICartService;
import com.common.grpc.CartAddItemRequest;
import com.common.grpc.CartApplyCodeRequest;
import com.common.grpc.CartClearRequest;
import com.common.grpc.CartGetOrCreateRequest;
import com.common.grpc.CartItemView;
import com.common.grpc.CartListRequest;
import com.common.grpc.CartMergeRequest;
import com.common.grpc.CartRemoveItemRequest;
import com.common.grpc.CartServiceGrpc;
import com.common.grpc.CartUpdateQtyRequest;
import com.common.grpc.CartView;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.time.Instant;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.devh.boot.grpc.server.service.GrpcService;
import org.common.exception.GrpcStatusMapper;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartGrpcController
    extends CartServiceGrpc.CartServiceImplBase {
  ICartService cartService;
  CartMapper cartMapper;

  private CartItemView map(CartItemResponseDto d) {
    return CartItemView.newBuilder()
        .setId(d.getId()).setVariantId(d.getVariantId())
        .setSku(Objects.toString(d.getSku(),""))
        .setProductName(Objects.toString(d.getProductName(),""))
        .setPrice(d.getPrice().toPlainString())
        .setQuantity(d.getQuantity())
        .setLineTotal(d.getLineTotal().toPlainString())
        .build();
  }
  private CartView map(CartResponseDto r) {
    var b = CartView.newBuilder()
        .setUserId(r.getUserId())
        .setSubtotal(r.getSubtotal().toPlainString())
        .setDiscountAmount(r.getDiscountAmount().toPlainString())
        .setShippingFee(r.getShippingFee().toPlainString())
        .setTotal(r.getTotal().toPlainString());
    r.getItems().forEach(i -> b.addItems(map(i)));
    return b.build();
  }

  @Override
  public void getOrCreate(
      CartGetOrCreateRequest request,
      StreamObserver<CartView> responseObserver) {
    GrpcStatusMapper.ok(responseObserver, map(cartService.getOrCreate(request.getUserId())));
  }
  @Override
  public void addItem(
      CartAddItemRequest request,
      StreamObserver<Empty> responseObserver) {
    cartService.addItem(
        request.getUserId(),
        request.getVariantId(),
        request.getQuantity());
    GrpcStatusMapper.ok(responseObserver);
  }
  @Override
  public void updateQty(
      CartUpdateQtyRequest request,
      StreamObserver<Empty> responseObserver) {
    cartService.updateQty(
        request.getCartItemId(),
        request.getQuantity());
    GrpcStatusMapper.ok(responseObserver);
  }
  @Override
  public void removeItem(
      CartRemoveItemRequest request,
      StreamObserver<Empty> responseObserver) {
    cartService.removeItem(request.getCartItemId());
    GrpcStatusMapper.ok(responseObserver);
  }
  @Override
  public void clear(
      CartClearRequest request,
      StreamObserver<Empty> responseObserver) {
    cartService.clear(request.getUserId());
    GrpcStatusMapper.ok(responseObserver);
  }
  @Override
  public void list(
      CartListRequest request,
      StreamObserver<CartView> responseObserver) {
    GrpcStatusMapper.ok(responseObserver, map(cartService.list(request.getUserId())));
  }
  @Override
  public void applyCode(
      CartApplyCodeRequest request,
      StreamObserver<CartView> responseObserver) {
    Instant at = request.getAt().isBlank()
        ? Instant.now()
        : Instant.parse(request.getAt());
    GrpcStatusMapper.ok(responseObserver, map(cartService.applyCode(
        request.getUserId(), request.getCode(), at)));
  }
  @Override
  public void merge(
      CartMergeRequest request,
      StreamObserver<Empty> responseObserver) {
    cartService.merge(request.getFromUserId(), request.getToUserId());
    GrpcStatusMapper.ok(responseObserver);
  }
}
