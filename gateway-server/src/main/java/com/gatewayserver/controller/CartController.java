package com.gatewayserver.controller;

import com.common.grpc.CartAddItemRequest;
import com.common.grpc.CartApplyCodeRequest;
import com.common.grpc.CartClearRequest;
import com.common.grpc.CartGetOrCreateRequest;
import com.common.grpc.CartListRequest;
import com.common.grpc.CartMergeRequest;
import com.common.grpc.CartRemoveItemRequest;
import com.common.grpc.CartServiceGrpc;
import com.common.grpc.CartUpdateQtyRequest;
import com.gatewayserver.dto.request.cart.CartAddItemBody;
import com.gatewayserver.dto.request.cart.CartApplyCodeBody;
import com.gatewayserver.dto.request.cart.CartMergeBody;
import com.gatewayserver.dto.request.cart.CartUpdateQtyBody;
import com.gatewayserver.dto.response.cart.CartView;
import com.gatewayserver.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.common.http.Envelope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/carts")
public class CartController {

  @GrpcClient("core-grpc")
  private CartServiceGrpc.CartServiceBlockingStub cartStub;

  private final CartMapper mapper;

  @GetMapping
  public ResponseEntity<Envelope<CartView>> list(
      @RequestParam String userId){
    CartView view = mapper.toCartView(
        cartStub.list(CartListRequest.newBuilder()
            .setUserId(userId)
            .build()));
    return ResponseEntity.ok(Envelope.ok(view));
  }

  @PostMapping(
      path = "/get-or-create",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Envelope<CartView>> getOrCreate(
      @RequestBody CartMergeBody body
  ){
    CartView view = mapper.toCartView(
        cartStub.getOrCreate(CartGetOrCreateRequest.newBuilder()
            .setUserId(body.toUserId())
            .build()));
    return ResponseEntity.ok(Envelope.ok(view));
  }

  @PostMapping(
      path = "/items",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Envelope<Void>> addItem(
      @RequestBody CartAddItemBody body){
    cartStub.addItem(CartAddItemRequest.newBuilder()
        .setUserId(body.userId())
        .setVariantId(body.variantId())
        .setQuantity(body.quantity() == null
            ? 1
            : body.quantity())
        .build());
    return ResponseEntity.ok(Envelope.ok(null));
  }

  @PatchMapping(
      path = "/items/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Envelope<Void>> updateQty(
      @PathVariable("id") String id,
      @RequestBody CartUpdateQtyBody body){
    cartStub.updateQty(CartUpdateQtyRequest.newBuilder()
        .setCartItemId(id)
        .setQuantity(body.quantity() == null
            ? 1
            : body.quantity())
        .build());
    return ResponseEntity.ok(Envelope.ok(null));
  }

  @DeleteMapping("/items/{id}")
  public ResponseEntity<Envelope<Void>> removeItem(
      @PathVariable("id") String id){
    cartStub.removeItem(CartRemoveItemRequest.newBuilder()
        .setCartItemId(id)
        .build());
    return ResponseEntity.ok(Envelope.ok(null));
  }

  @DeleteMapping
  public ResponseEntity<Envelope<Void>> clear(
      @RequestParam String userId){
    cartStub.clear(CartClearRequest.newBuilder()
        .setUserId(userId)
        .build());
    return ResponseEntity.ok(Envelope.ok(null));
  }

  @PostMapping(
      path = "/apply-code",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Envelope<CartView>> applyCode(
      @RequestBody CartApplyCodeBody body){
    CartView view = mapper.toCartView(
        cartStub.applyCode(CartApplyCodeRequest.newBuilder()
            .setUserId(body.userId())
            .setCode(body.code() == null
                ? ""
                : body.code())
            .setAt(body.at() == null
                ? ""
                : body.at())
            .build()));
    return ResponseEntity.ok(Envelope.ok(view));
  }

  @PostMapping(
      path = "/merge",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Envelope<Void>> merge(
      @RequestBody CartMergeBody body){
    cartStub.merge(CartMergeRequest.newBuilder()
        .setFromUserId(body.fromUserId())
        .setToUserId(body.toUserId())
        .build());
    return ResponseEntity.ok(Envelope.ok(null));
  }
}
