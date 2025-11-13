package com.business.controller;

import com.business.constant.OrderStatus;
import com.business.dto.request.CreateOrderDirectRequestDto;
import com.business.dto.request.CreateOrderFromCartRequestDto;
import com.business.dto.response.OrderItemResponseDto;
import com.business.dto.response.OrderResponseDto;
import com.business.helper.AuthenticationHelper;
import com.business.mapper.OrderMapper;
import com.business.service.IOrderService;
import com.common.grpc.CreateOrderDirectRequest;
import com.common.grpc.CreateOrderFromCartRequest;
import com.common.grpc.OrderApplyOrSwapCodeRequest;
import com.common.grpc.OrderCancelRequest;
import com.common.grpc.OrderIdRequest;
import com.common.grpc.OrderItemView;
import com.common.grpc.OrderListRequest;
import com.common.grpc.OrderPatchChargesRequest;
import com.common.grpc.OrderServiceGrpc;
import com.common.grpc.OrderStatusGrpc;
import com.common.grpc.OrderUpdateStatusRequest;
import com.common.grpc.OrderView;
import com.common.grpc.PageOrder;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.math.BigDecimal;
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
public class OrderGrpcController
    extends OrderServiceGrpc.OrderServiceImplBase {
  IOrderService orderService;
  OrderMapper mapper;

  private OrderItemView map(OrderItemResponseDto d){
    return OrderItemView.newBuilder()
        .setId(Objects.toString(d.getId(),""))
        .setVariantId(Objects.toString(d.getVariantId(),""))
        .setSku(Objects.toString(d.getSku(),""))
        .setProductName(Objects.toString(d.getProductName(),""))
        .setPrice(d.getPrice().toPlainString())
        .setQuantity(d.getQuantity())
        .setLineTotal(d.getLineTotal().toPlainString()).build();
  }
  private OrderView map(OrderResponseDto o){
    var b = OrderView.newBuilder()
        .setId(o.getId()).setUserId(o.getUserId())
        .setStatus(OrderStatusGrpc.valueOf(o.getStatus().name().toUpperCase()))
        .setSubtotal(o.getSubtotal().toPlainString())
        .setDiscountAmount(o.getDiscountAmount().toPlainString())
        .setShippingFee(o.getShippingFee().toPlainString())
        .setTotalAmount(o.getTotalAmount().toPlainString())
        .setShippingAddress(Objects.toString(o.getShippingAddress(),""))
        .setBillingAddress(Objects.toString(o.getBillingAddress(),""))
        .setPaymentMethodName(Objects.toString(o.getPaymentMethodName(),""))
        .setShippingMethodName(Objects.toString(o.getShippingMethodName(),""))
        .setDiscountCode(Objects.toString(o.getDiscountCode(),""))
        .setCreatedAt(Objects.toString(o.getCreatedAt(),""));
    o.getItems().forEach(i -> b.addItems(map(i)));
    return b.build();
  }

  @Override
  public void createFromCart(
      CreateOrderFromCartRequest request,
      StreamObserver<OrderView> responseObserver) {
    var dto = CreateOrderFromCartRequestDto.builder()
        .userId(request.getUserId())
        .shippingAddress(request.getShippingAddress())
        .billingAddress(request.getBillingAddress())
        .paymentMethodName(request.getPaymentMethodName())
        .shippingMethodName(request.getShippingMethodName())
        .discountCode(request.getDiscountCode())
        .build();
    GrpcStatusMapper.ok(responseObserver, map(orderService.createFromCart(dto)));
  }

  @Override
  public void createDirect(
      CreateOrderDirectRequest request,
      StreamObserver<OrderView> responseObserver) {
    var dto = CreateOrderDirectRequestDto.builder()
        .userId(request.getUserId())
        .shippingAddress(request.getShippingAddress())
        .billingAddress(request.getBillingAddress())
        .paymentMethodName(request.getPaymentMethodName())
        .shippingMethodName(request.getShippingMethodName())
        .discountCode(request.getDiscountCode())
        .lines(request.getLinesList().stream()
            .map(l -> new CreateOrderDirectRequestDto
                .Line(l.getVariantId(), l.getQuantity()))
            .toList())
        .build();
    GrpcStatusMapper.ok(responseObserver, map(orderService.createDirect(dto)));
  }

  @Override
  public void getDetail(
      OrderIdRequest req,
      StreamObserver<OrderView> obs) {
    GrpcStatusMapper.ok(obs, map(orderService.getDetail(req.getId())));
  }

  @Override
  public void list(
      OrderListRequest request,
      StreamObserver<PageOrder> responseObserver) {
    OrderStatus status = (request.getStatus().isBlank()
        ? null
        : OrderStatus.valueOf(request.getStatus().toLowerCase()));
    Instant from = request.getDateFrom().isBlank()
        ? null
        : Instant.parse(request.getDateFrom());
    Instant to = request.getDateTo().isBlank()
        ? null
        : Instant.parse(request.getDateTo());
    var page = orderService.list(
        request.getUserId(),
        status,
        from, to,
        request.getPage(),
        request.getSize());
    var b = PageOrder.newBuilder()
        .setPage(page.getPage())
        .setSize(page.getSize())
        .setTotal(page.getTotal())
        .setTotalPages(page.getTotalPages());
    page.getDocs().forEach(d -> b.addDocs(map(d)));
    GrpcStatusMapper.ok(responseObserver, b.build());
  }

  @Override
  public void updateStatus(
      OrderUpdateStatusRequest request,
      StreamObserver<Empty> responseObserver) {
    AuthenticationHelper.requireAdmin();
    orderService.updateStatus(
        request.getId(),
        OrderStatus.valueOf(request.getStatus().name().toLowerCase()));
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void cancel(
      OrderCancelRequest request,
      StreamObserver<Empty> responseObserver) {
    orderService.cancel(request.getId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override public void patchCharges(
      OrderPatchChargesRequest request,
      StreamObserver<Empty> responseObserver) {
    AuthenticationHelper.requireAdmin();
    BigDecimal shipping = request.getShippingFee().isBlank()
        ? null
        : new BigDecimal(request.getShippingFee());
    orderService.patchCharges(
        request.getId(),
        shipping,
        request.getPaymentMethodName(),
        request.getShippingMethodName());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void applyOrSwapCode(
      OrderApplyOrSwapCodeRequest request,
      StreamObserver<Empty> responseObserver) {
    orderService.applyOrSwapCode(request.getId(), request.getDiscountCode());
    GrpcStatusMapper.ok(responseObserver);
  }
}
