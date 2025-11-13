package com.business.controller;

import com.business.dto.request.BrandCreateRequestDto;
import com.business.dto.request.BrandUpdateRequestDto;
import com.business.dto.response.BrandResponseDto;
import com.business.service.IBrandService;
import com.common.grpc.BrandCreateRequest;
import com.common.grpc.BrandListRequest;
import com.common.grpc.BrandServiceGrpc;
import com.common.grpc.BrandUpdateRequest;
import com.common.grpc.BrandView;
import com.common.grpc.IdRequest;
import com.common.grpc.PageBrand;
import com.common.grpc.SlugRequest;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.devh.boot.grpc.server.service.GrpcService;
import org.common.exception.GrpcStatusMapper;
import org.common.http.Envelope;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandGrpcController
        extends BrandServiceGrpc.BrandServiceImplBase {
    IBrandService brandService;

    @Override
    public void create(
            BrandCreateRequest request,
            StreamObserver<Empty> responseObserver) {
        brandService.create(BrandCreateRequestDto.builder()
                .name(request.getName())
                .slug(request.getSlug())
                .description(request.getDescription())
                .build());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void update(
            BrandUpdateRequest brandUpdateRequest,
            StreamObserver<Empty> responseObserver) {
        brandService.update(
                brandUpdateRequest.getId(),
                BrandUpdateRequestDto.builder()
                        .name(brandUpdateRequest.getName())
                        .slug(brandUpdateRequest.getSlug())
                        .description(brandUpdateRequest.getDescription())
                        .build()
        );
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void softDelete(
            IdRequest request,
            StreamObserver<Empty> responseObserver) {
        brandService.softDelete(request.getId());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void restore(
            IdRequest request,
            StreamObserver<Empty> responseObserver) {
        brandService.restore(request.getId());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void getById(
            IdRequest request,
            StreamObserver<BrandView> responseObserver) {
        BrandResponseDto d = brandService.getById(request.getId());
        GrpcStatusMapper.ok(
                responseObserver,
                BrandView.newBuilder()
                        .setId(d.getId())
                        .setName(d.getName()).setSlug(d.getSlug())
                        .setDescription(d.getDescription() == null
                                ? ""
                                : d.getDescription())
                .build());
    }

    @Override
    public void getBySlug(
            SlugRequest request,
            StreamObserver<BrandView> responseObserver) {
        BrandResponseDto d = brandService.getBySlug(request.getSlug());
        GrpcStatusMapper.ok(
                responseObserver,
                BrandView.newBuilder()
                        .setId(d.getId())
                        .setName(d.getName())
                        .setSlug(d.getSlug())
                        .setDescription(d.getDescription() == null
                                ? ""
                                : d.getDescription())
                        .build());
    }

    @Override
    public void list(
            BrandListRequest request,
            StreamObserver<PageBrand> responseObserver) {
        Envelope.Page<BrandResponseDto> page = brandService.list(
                request.getQ(),
                request.getPage(),
                request.getSize()
        );
        PageBrand.Builder b = PageBrand.newBuilder()
                .setPage(page.getPage())
                .setSize(page.getSize())
                .setTotal(page.getTotal())
                .setTotalPages(page.getTotalPages());
        page.getDocs().forEach(d -> b.addDocs(BrandView.newBuilder()
                .setId(d.getId())
                .setName(d.getName())
                .setSlug(d.getSlug())
                .setDescription(d.getDescription() == null
                        ? ""
                        : d.getDescription())
                .build()));
        GrpcStatusMapper.ok(responseObserver, b.build());
    }
}
