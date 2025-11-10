package com.gatewayserver.controller;

import com.common.grpc.CreateOrderDirectRequest;
import com.common.grpc.CreateOrderFromCartRequest;
import com.common.grpc.OrderApplyOrSwapCodeRequest;
import com.common.grpc.OrderCancelRequest;
import com.common.grpc.OrderIdRequest;
import com.common.grpc.OrderListRequest;
import com.common.grpc.OrderPatchChargesRequest;
import com.common.grpc.OrderServiceGrpc;
import com.common.grpc.OrderStatusGrpc;
import com.common.grpc.OrderUpdateStatusRequest;
import com.common.grpc.PageOrder;
import com.gatewayserver.dto.request.cart.CreateOrderFromCartBody;
import com.gatewayserver.dto.request.order.CreateOrderDirectBody;
import com.gatewayserver.dto.request.order.OrderApplyOrSwapCodeBody;
import com.gatewayserver.dto.request.order.OrderPatchChargesBody;
import com.gatewayserver.dto.response.order.OrderView;
import com.gatewayserver.dto.response.order.PageOrderView;
import com.gatewayserver.mapper.OrderMapper;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.common.http.Envelope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/orders")
public class OrderController {

  private final OrderMapper mapper;
  @GrpcClient("core-grpc")
  private OrderServiceGrpc.OrderServiceBlockingStub orderStub;

  @PostMapping(
      path = "/from-cart",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Envelope<OrderView>> createFromCart(
      @RequestBody CreateOrderFromCartBody body){
    OrderView view = mapper.toOrderView(
        orderStub.createFromCart(CreateOrderFromCartRequest.newBuilder()
            .setUserId(body.userId())
            .setShippingAddress(body.shippingAddress())
            .setBillingAddress(body.billingAddress() == null
                ? ""
                : body.billingAddress())
            .setPaymentMethodName(body.paymentMethodName())
            .setShippingMethodName(body.shippingMethodName())
            .setDiscountCode(body.discountCode()==null
                ? ""
                : body.discountCode())
            .build()));
    return ResponseEntity.ok(Envelope.ok(view));
  }

  @PostMapping(
      path = "/direct",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Envelope<OrderView>> createDirect(
      @RequestBody CreateOrderDirectBody body){
    var req = CreateOrderDirectRequest.newBuilder()
        .setUserId(body.userId())
        .setShippingAddress(body.shippingAddress())
        .setBillingAddress(body.billingAddress() == null
            ? ""
            : body.billingAddress())
        .setPaymentMethodName(body.paymentMethodName())
        .setShippingMethodName(body.shippingMethodName())
        .setDiscountCode(body.discountCode() == null
            ? ""
            : body.discountCode());
    if (body.lines() != null) {
      req.addAllLines(body.lines().stream()
          .map(l -> CreateOrderDirectRequest.DirectLine.newBuilder()
              .setVariantId(l.variantId())
              .setQuantity(l.quantity() == null
                  ? 1
                  : l.quantity())
              .build())
          .collect(Collectors.toList()));
    }
    OrderView view = mapper.toOrderView(orderStub.createDirect(req.build()));
    return ResponseEntity.ok(Envelope.ok(view));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Envelope<OrderView>> getDetail(
      @PathVariable String id){
    OrderView view = mapper.toOrderView(
        orderStub.getDetail(OrderIdRequest.newBuilder()
            .setId(id).build()));
    return ResponseEntity.ok(Envelope.ok(view));
  }

  @GetMapping
  public ResponseEntity<Envelope<PageOrderView>> list(
      @RequestParam String userId,
      @RequestParam(required = false, defaultValue = "") String status,
      @RequestParam(required = false, defaultValue = "") String dateFrom,
      @RequestParam(required = false, defaultValue = "") String dateTo,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size
  ){
    PageOrder p = orderStub.list(OrderListRequest.newBuilder()
        .setUserId(userId)
        .setStatus(status== null ? "" : status)
        .setDateFrom(dateFrom == null ? "" : dateFrom)
        .setDateTo(dateTo==null ? "" : dateTo)
        .setPage(page)
        .setSize(size)
        .build());

    PageOrderView out = new PageOrderView(
        p.getPage(),
        p.getSize(),
        p.getTotal(),
        p.getTotalPages(),
        p.getDocsList().stream().map(mapper::toOrderView).toList()
    );
    return ResponseEntity.ok(Envelope.ok(out));
  }

  @PreAuthorize("hasRole('ADMIN')")
  @PatchMapping(
      path = "/{id}/status",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Envelope<Void>> updateStatus(
      @PathVariable String id,
      @RequestBody String toStatus // ví dụ: "PROCESSING"
  ){
    orderStub.updateStatus(OrderUpdateStatusRequest.newBuilder()
        .setId(id)
        .setStatus(OrderStatusGrpc.valueOf(toStatus.replace("\"","").trim()))
        .build());
    return ResponseEntity.ok(Envelope.ok(null));
  }

  @PostMapping("/{id}/cancel")
  public ResponseEntity<Envelope<Void>> cancel(
      @PathVariable String id){
    orderStub.cancel(OrderCancelRequest.newBuilder()
        .setId(id)
        .build());
    return ResponseEntity.ok(Envelope.ok(null));
  }

  @PatchMapping(
      path = "/{id}/charges",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Envelope<Void>> patchCharges(
      @PathVariable String id,
      @RequestBody OrderPatchChargesBody body){
    orderStub.patchCharges(OrderPatchChargesRequest.newBuilder()
        .setId(id)
        .setShippingFee(body.shippingFee() == null
            ? ""
            : body.shippingFee())
        .setPaymentMethodName(body.paymentMethodName() == null
            ? ""
            : body.paymentMethodName())
        .setShippingMethodName(body.shippingMethodName() == null
            ? ""
            : body.shippingMethodName())
        .build());
    return ResponseEntity.ok(Envelope.ok(null));
  }

  @PostMapping(
      path = "/{id}/discount",
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Envelope<Void>> applyOrSwapCode(
      @PathVariable String id,
      @RequestBody OrderApplyOrSwapCodeBody body){
    orderStub.applyOrSwapCode(OrderApplyOrSwapCodeRequest.newBuilder()
        .setId(id)
        .setDiscountCode(body.discountCode() == null
            ? ""
            : body.discountCode())
        .build());
    return ResponseEntity.ok(Envelope.ok(null));
  }
}
