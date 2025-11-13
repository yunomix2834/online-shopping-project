package com.business.controller;

import com.business.dto.request.VariantCreateRequestDto;
import com.business.dto.request.VariantUpdateRequestDto;
import com.business.dto.response.VariantResponseDto;
import com.business.service.IVariantService;
import com.common.grpc.IdRequest;
import com.common.grpc.PageVariant;
import com.common.grpc.VariantByProductRequest;
import com.common.grpc.VariantBySkuRequest;
import com.common.grpc.VariantCreateRequest;
import com.common.grpc.VariantPricePatchRequest;
import com.common.grpc.VariantServiceGrpc;
import com.common.grpc.VariantUpdateRequest;
import com.common.grpc.VariantView;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.devh.boot.grpc.server.service.GrpcService;
import org.common.exception.GrpcStatusMapper;
import org.common.http.Envelope;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VariantGrpcController extends VariantServiceGrpc.VariantServiceImplBase {
  IVariantService variantService;

  private VariantView mapVariantResponseDtoToVariantView(
      VariantResponseDto d) {
    return VariantView.newBuilder()
        .setId(d.getId()).setProductId(d.getProductId() == null
            ? ""
            : d.getProductId())
        .setSku(d.getSku())
        .setPrice(d.getPrice().toPlainString())
        .setOriginalPrice(d.getOriginalPrice() == null
            ? ""
            : d.getOriginalPrice().toPlainString())
        .build();
  }

  @Override
  public void create(
      VariantCreateRequest request,
      StreamObserver<Empty> responseObserver) {
    variantService.create(VariantCreateRequestDto.builder()
        .productId(request.getProductId())
        .sku(request.getSku())
        .price(new BigDecimal(request.getPrice()))
        .originalPrice(request.getOriginalPrice().isBlank()
            ? null
            : new BigDecimal(request.getOriginalPrice()))
        .build());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void update(
      VariantUpdateRequest request,
      StreamObserver<Empty> responseObserver) {
    variantService.update(request.getId(), VariantUpdateRequestDto.builder()
        .sku(request.getSku().isBlank()
            ? null
            : request.getSku())
        .price(request.getPrice().isBlank()
            ? null
            : new BigDecimal(request.getPrice()))
        .originalPrice(request.getOriginalPrice().isBlank()
            ? null
            : new BigDecimal(request.getOriginalPrice()))
        .build()); GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void softDelete(
      IdRequest request,
      StreamObserver<Empty> responseObserver){
    variantService.softDelete(request.getId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void restore(
      IdRequest request,
      StreamObserver<Empty> responseObserver){
    variantService.restore(request.getId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void findBySku(
      VariantBySkuRequest request,
      StreamObserver<VariantView> responseObserver){
    GrpcStatusMapper.ok(
        responseObserver,
        mapVariantResponseDtoToVariantView(variantService.findBySku(request.getSku()))
    );
  }

  @Override public void patchPrice(
      VariantPricePatchRequest req,
      StreamObserver<Empty> obs){
    variantService.patchPrice(req.getId(),
        req.getPrice().isBlank()
            ? null
            : new BigDecimal(req.getPrice()),
        req.getOriginalPrice().isBlank()
            ? null
            : new BigDecimal(req.getOriginalPrice()));
    GrpcStatusMapper.ok(obs);
  }

  @Override
  public void listByProduct(
      VariantByProductRequest req,
      StreamObserver<PageVariant> obs){
    Envelope.Page<VariantResponseDto> page = variantService.listByProduct(
        req.getProductId(),
        req.getPage(),
        req.getSize()
    );
    PageVariant.Builder b = PageVariant.newBuilder()
        .setPage(page.getPage())
        .setSize(page.getSize())
        .setTotal(page.getTotal())
        .setTotalPages(page.getTotalPages());
    page.getDocs().forEach(d -> b.addDocs(mapVariantResponseDtoToVariantView(d)));
    GrpcStatusMapper.ok(obs, b.build());
  }
}
