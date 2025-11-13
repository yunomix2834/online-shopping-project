package com.business.controller;

import com.business.constant.DiscountType;
import com.business.dto.model.DiscountValidation;
import com.business.dto.request.DiscountCreateRequestDto;
import com.business.dto.request.DiscountUpdateRequestDto;
import com.business.dto.response.DiscountResponseDto;
import com.business.service.IDiscountService;
import com.common.grpc.DiscountCodeRequest;
import com.common.grpc.DiscountCreateRequest;
import com.common.grpc.DiscountListRequest;
import com.common.grpc.DiscountServiceGrpc;
import com.common.grpc.DiscountToggleActiveRequest;
import com.common.grpc.DiscountTypeGrpc;
import com.common.grpc.DiscountUpdateRequest;
import com.common.grpc.DiscountValidationView;
import com.common.grpc.DiscountView;
import com.common.grpc.IdRequest;
import com.common.grpc.PageDiscount;
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
import org.common.http.Envelope;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DiscountGrpcController
    extends DiscountServiceGrpc.DiscountServiceImplBase {

  IDiscountService discountService;

  /* ===== Helpers ===== */

  private static BigDecimal parseDecimal(String s) {
    return (s == null || s.isBlank()) ? null : new BigDecimal(s);
    // ném NumberFormatException sẽ được GrpcAdvice chuyển INVALID_ARGUMENT
  }

  private static Instant parseInstant(String s) {
    return (s == null || s.isBlank()) ? null : Instant.parse(s);
  }

  private DiscountType toDomain(DiscountTypeGrpc t) {
    if (t == null) return DiscountType.fixed_amount; // default an toàn
    return switch (t) {
      case PERCENTAGE -> DiscountType.percentage;
      case FIXED_AMOUNT, UNRECOGNIZED -> DiscountType.fixed_amount;
    };
  }

  private DiscountTypeGrpc toGrpc(DiscountType t) {
    if (t == null) return DiscountTypeGrpc.FIXED_AMOUNT;
    return switch (t) {
      case percentage -> DiscountTypeGrpc.PERCENTAGE;
      case fixed_amount -> DiscountTypeGrpc.FIXED_AMOUNT;
    };
  }

  private DiscountView map(DiscountResponseDto d) {
    return DiscountView.newBuilder()
        .setId(d.getId())
        .setCode(d.getCode())
        .setType(toGrpc(d.getType()))
        .setValue(Objects.toString(d.getValue(), "0"))
        .setStartDate(Objects.toString(d.getStartDate(), ""))
        .setEndDate(Objects.toString(d.getEndDate(), ""))
        .setMinOrderValue(Objects.toString(d.getMinOrderValue(), "0"))
        .setIsActive(Boolean.TRUE.equals(d.getActive()))
        .build();
  }

  private DiscountValidationView mapValidation(
      DiscountValidation v) {
    return DiscountValidationView.newBuilder()
        .setValid(v.isValid())
        .setReason(Objects.toString(v.getReason(), ""))
        .setDiscountAmount(Objects.toString(v.getAmount(), "0"))
        .build();
  }


  @Override
  public void create(
      DiscountCreateRequest request,
      StreamObserver<Empty> responseObserver) {
    discountService.create(DiscountCreateRequestDto.builder()
        .code(request.getCode())
        .type(toDomain(request.getType()))
        .value(parseDecimal(request.getValue()))
        .startDate(parseInstant(request.getStartDate()))
        .endDate(parseInstant(request.getEndDate()))
        .minOrderValue(parseDecimal(request.getMinOrderValue()))
        .active(request.getIsActive())
        .build());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void update(
      DiscountUpdateRequest request,
      StreamObserver<Empty> responseObserver) {
    discountService.update(request.getId(), DiscountUpdateRequestDto.builder()
        .code(request.getCode().isBlank()
            ? null
            : request.getCode())
        .type(request.getType() == DiscountTypeGrpc.UNRECOGNIZED
            ? null
            : toDomain(request.getType()))
        .value(parseDecimal(request.getValue()))
        .startDate(parseInstant(request.getStartDate()))
        .endDate(parseInstant(request.getEndDate()))
        .minOrderValue(parseDecimal(request.getMinOrderValue()))
        .active(request.getIsActive())
        .build());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void softDelete(
      IdRequest request,
      StreamObserver<Empty> responseObserver) {
    discountService.softDelete(request.getId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void restore(
      IdRequest request,
      StreamObserver<Empty> responseObserver) {
    discountService.restore(request.getId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void toggleActive(
      DiscountToggleActiveRequest request,
      StreamObserver<Empty> responseObserver) {
    discountService.toggleActive(request.getId(), request.getIsActive());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void getByCode(
      DiscountCodeRequest request,
      StreamObserver<DiscountView> responseObserver) {
    var d = discountService.getByCode(request.getCode());
    GrpcStatusMapper.ok(responseObserver, map(d));
  }

  @Override
  public void validate(
      DiscountCodeRequest request,
      StreamObserver<DiscountValidationView> responseObserver) {
    var v = discountService.validateAndAmount(
        request.getCode(),
        parseDecimal(request.getOrderValue()) == null
            ? BigDecimal.ZERO
            : parseDecimal(request.getOrderValue()),
        parseInstant(request.getAt()) == null
            ? Instant.now()
            : parseInstant(request.getAt())
    );
    GrpcStatusMapper.ok(responseObserver, mapValidation(v));
  }

  @Override
  public void list(
      DiscountListRequest request,
      StreamObserver<PageDiscount> responseObserver) {
    var at = parseInstant(request.getAt());
    Envelope.Page<DiscountResponseDto> page = discountService.list(
        request.getOnlyEffective(),
        at == null ? Instant.now() : at,
        request.getPage(),
        request.getSize()
    );

    PageDiscount.Builder b = PageDiscount.newBuilder()
        .setPage(page.getPage())
        .setSize(page.getSize())
        .setTotal(page.getTotal())
        .setTotalPages(page.getTotalPages());
    page.getDocs().forEach(d -> b.addDocs(map(d)));
    GrpcStatusMapper.ok(responseObserver, b.build());
  }
}
