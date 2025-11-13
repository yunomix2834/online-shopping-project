package com.business.controller;

import com.business.dto.request.ProductCreateRequestDto;
import com.business.dto.request.ProductUpdateRequestDto;
import com.business.dto.response.ProductResponseDto;
import com.business.service.IProductService;
import com.common.grpc.ArchiveRequest;
import com.common.grpc.AssignCategoryRequest;
import com.common.grpc.IdRequest;
import com.common.grpc.PageProduct;
import com.common.grpc.ProductCreateRequest;
import com.common.grpc.ProductListRequest;
import com.common.grpc.ProductServiceGrpc;
import com.common.grpc.ProductStatus;
import com.common.grpc.ProductUpdateRequest;
import com.common.grpc.ProductView;
import com.common.grpc.PublishRequest;
import com.common.grpc.SlugRequest;
import com.common.grpc.UnassignCategoryRequest;
import com.common.grpc.UnpublishRequest;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.devh.boot.grpc.server.service.GrpcService;
import org.common.exception.GrpcStatusMapper;
import org.common.http.Envelope;

import static com.business.constant.ProductStatus.ARCHIVED;
import static com.business.constant.ProductStatus.DRAFT;
import static com.business.constant.ProductStatus.PUBLISHED;
import static com.business.constant.ProductStatus.UNPUBLISHED;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductGrpcController extends ProductServiceGrpc.ProductServiceImplBase {
    IProductService productService;

    private ProductView map(ProductResponseDto d){
        return ProductView.newBuilder()
                .setId(d.getId())
                .setName(d.getName())
                .setSlug(d.getSlug())
                .setDescription(d.getDescription()==null?"":d.getDescription())
                .setStatus(ProductStatus.valueOf(d.getStatus().name()))
                .setBrandId(d.getBrandId()==null?"":d.getBrandId())
                .build();
    }

    private ProductStatus toGrpc(com.business.constant.ProductStatus s) {
        switch (s) {
            case PUBLISHED: return ProductStatus.PUBLISHED;
            case ARCHIVED:  return ProductStatus.ARCHIVED;
            case UNPUBLISHED: return ProductStatus.UNPUBLISHED;
            default: return ProductStatus.DRAFT;
        }
    }

    private com.business.constant.ProductStatus toDomain(ProductStatus s) {
        switch (s) {
            case ProductStatus.PUBLISHED:     return PUBLISHED;
            case ProductStatus.ARCHIVED: return ARCHIVED;
            case ProductStatus.UNPUBLISHED:  return UNPUBLISHED;
            default: return DRAFT;
        }
    }


    @Override
    public void create(
            ProductCreateRequest request,
            StreamObserver<Empty> responseObserver) {
        productService.create(ProductCreateRequestDto.builder()
                .name(request.getName())
                .slug(request.getSlug())
                .description(request.getDescription())
                .brandId(request.getBrandId().isBlank()
                        ? null
                        : request.getBrandId())
                .build());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void update(
            ProductUpdateRequest request,
            StreamObserver<Empty> responseObserver) {
        productService.update(
                request.getId(),
                ProductUpdateRequestDto.builder()
                    .name(request.getName())
                    .slug(request.getSlug())
                    .description(request.getDescription())
                    .brandId(request.getBrandId().isBlank()?null:request.getBrandId())
                    .build());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override public void softDelete(
            IdRequest request,
            StreamObserver<Empty> responseObserver){
        productService.softDelete(request.getId());
        GrpcStatusMapper.ok(responseObserver);
    }
    @Override public void restore(
            IdRequest request,
            StreamObserver<Empty> responseObserver){
        productService.restore(request.getId());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override public void publish(
            PublishRequest request,
            StreamObserver<Empty> responseObserver){
        productService.publish(request.getId());
        GrpcStatusMapper.ok(responseObserver);
    }
    @Override public void unpublish(
            UnpublishRequest request,
            StreamObserver<Empty> responseObserver){
        productService.unpublish(request.getId());
        GrpcStatusMapper.ok(responseObserver);
    }
    @Override public void archive(
            ArchiveRequest request,
            StreamObserver<Empty> responseObserver){
        productService.archive(request.getId());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void getById(
            IdRequest request,
            StreamObserver<ProductView> responseObserver) {
        GrpcStatusMapper.ok(responseObserver, map(productService.getById(request.getId())));
    }
    @Override
    public void getBySlug(
            SlugRequest request,
            StreamObserver<ProductView> responseObserver) {
        GrpcStatusMapper.ok(responseObserver, map(productService.getBySlug(request.getSlug())));
    }

    @Override
    public void list(
            ProductListRequest request,
            StreamObserver<PageProduct> responseObserver) {
        ProductStatus status = request.hasStatus()
                ? ProductStatus.valueOf(request.getStatus().name())
                : null;
        Envelope.Page<ProductResponseDto> page = productService.list(
                request.getQ(),
                request.getBrandId().isBlank()
                        ? null
                        : request.getBrandId(),
                request.getCategoryId().isBlank()
                        ? null
                        : request.getCategoryId(),
                toDomain(status), request.getPage(), request.getSize());

        PageProduct.Builder b = PageProduct.newBuilder()
                .setPage(page.getPage())
                .setSize(page.getSize())
                .setTotal(page.getTotal())
                .setTotalPages(page.getTotalPages());
        page.getDocs().forEach(d -> b.addDocs(map(d)));
        GrpcStatusMapper.ok(responseObserver, b.build());
    }

    @Override
    public void assignCategory(
            AssignCategoryRequest request,
            StreamObserver<Empty> responseObserver) {
        productService.assignCategory(request.getProductId(), request.getCategoryId());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void unassignCategory(
            UnassignCategoryRequest request,
            StreamObserver<Empty> responseObserver) {
        productService.unassignCategory(request.getProductId(), request.getCategoryId());
        GrpcStatusMapper.ok(responseObserver);
    }
}
