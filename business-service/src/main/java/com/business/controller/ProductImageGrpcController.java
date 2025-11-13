package com.business.controller;

import com.business.dto.request.ImageCreateRequestDto;
import com.business.dto.response.ImageResponseDto;
import com.business.service.IProductImageService;
import com.common.grpc.IdRequest;
import com.common.grpc.ImageListRequest;
import com.common.grpc.ImageView;
import com.common.grpc.PageImage;
import com.common.grpc.ProductImageServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
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
public class ProductImageGrpcController
    extends ProductImageServiceGrpc.ProductImageServiceImplBase {

  IProductImageService imageService;

  private ImageView map(ImageResponseDto d) {
    return ImageView.newBuilder()
        .setId(d.getId())
        .setProductId(Objects.toString(d.getProductId(), ""))
        .setVariantId(Objects.toString(d.getVariantId(), ""))
        .setImageUrl(d.getImageUrl())
        .setIsThumbnail(Boolean.TRUE.equals(d.getThumbnail()))
        .build();
  }

  @Override
  public void create(
      com.common.grpc.ImageCreateRequest request,
      StreamObserver<Empty> responseObserver) {
    imageService.create(ImageCreateRequestDto.builder()
        .productId(request.getProductId().isBlank()
            ? null
            : request.getProductId())
        .variantId(request.getVariantId().isBlank()
            ? null
            : request.getVariantId())
        .imageUrl(request.getImageUrl())
        .build());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void softDelete(
      IdRequest request,
      StreamObserver<Empty> responseObserver) {
    imageService.softDelete(request.getId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void restore(
      IdRequest request,
      StreamObserver<Empty> responseObserver) {
    imageService.restore(request.getId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void setThumbnail(
      IdRequest request,
      StreamObserver<Empty> responseObserver) {
    imageService.setThumbnail(request.getId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void unsetThumbnail(
      IdRequest request,
      StreamObserver<Empty> responseObserver) {
    imageService.unsetThumbnail(request.getId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void list(
      ImageListRequest request,
      StreamObserver<PageImage> responseObserver) {
    String productId = request.getProductId().isBlank()
        ? null
        : request.getProductId();
    String variantId = request.getVariantId().isBlank()
        ? null
        : request.getVariantId();

    Envelope.Page<ImageResponseDto> page = imageService
        .list(productId, variantId, request.getPage(), request.getSize());

    PageImage.Builder b = PageImage.newBuilder()
        .setPage(page.getPage())
        .setSize(page.getSize())
        .setTotal(page.getTotal())
        .setTotalPages(page.getTotalPages());
    page.getDocs().forEach(d -> b.addDocs(map(d)));
    GrpcStatusMapper.ok(responseObserver, b.build());
  }
}
