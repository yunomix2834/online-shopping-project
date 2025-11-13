package com.business.controller;

import com.business.dto.request.CategoryCreateRequestDto;
import com.business.dto.request.CategoryUpdateRequestDto;
import com.business.dto.response.CategoryResponseDto;
import com.business.service.ICategoryService;
import com.common.grpc.CategoryChildrenRequest;
import com.common.grpc.CategoryCreateRequest;
import com.common.grpc.CategoryListRequest;
import com.common.grpc.CategoryReparentRequest;
import com.common.grpc.CategoryServiceGrpc;
import com.common.grpc.CategoryTreeNode;
import com.common.grpc.CategoryUpdateRequest;
import com.common.grpc.CategoryView;
import com.common.grpc.IdRequest;
import com.common.grpc.PageCategory;
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
public class CategoryGrpcController extends CategoryServiceGrpc.CategoryServiceImplBase {

    ICategoryService categoryService;

    @Override
    public void create(
            CategoryCreateRequest request,
            StreamObserver<Empty> responseObserver) {
        categoryService.create(CategoryCreateRequestDto.builder()
                .name(request.getName())
                .slug(request.getSlug())
                .description(request.getDescription())
                .parentId(request.getParentId().isBlank()
                        ? null
                        : request.getParentId())
                .build());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void update(
            CategoryUpdateRequest request,
            StreamObserver<Empty> responseObserver) {
        categoryService.update(
                request.getId(),
                CategoryUpdateRequestDto.builder()
                    .name(request.getName())
                    .slug(request.getSlug())
                    .description(request.getDescription())
                    .build());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void softDelete(
            IdRequest request,
            StreamObserver<Empty> responseObserver) {
        categoryService.softDelete(request.getId());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void restore(IdRequest request, StreamObserver<Empty> responseObserver) {
        categoryService.restore(request.getId());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void reparent(
            CategoryReparentRequest request,
            StreamObserver<Empty> responseObserver) {
        categoryService.reparent(request.getId(),
                request.getNewParentId().isBlank()
                        ? null
                        : request.getNewParentId());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void getById(
            IdRequest request,
            StreamObserver<CategoryView> responseObserver) {
        CategoryResponseDto d = categoryService.getById(request.getId());
        GrpcStatusMapper.ok(responseObserver, CategoryView.newBuilder()
                .setId(d.getId())
                .setName(d.getName())
                .setSlug(d.getSlug())
                .setDescription(d.getDescription() == null
                        ? ""
                        : d.getDescription())
                .setParentId(d.getParentId() == null
                        ? ""
                        : d.getParentId())
                .build());
    }

    @Override
    public void getBySlug(
            SlugRequest request,
            StreamObserver<CategoryView> responseObserver) {
        CategoryResponseDto d = categoryService.getBySlug(request.getSlug());
        GrpcStatusMapper.ok(
                responseObserver,
                CategoryView.newBuilder()
                    .setId(d.getId())
                    .setName(d.getName())
                    .setSlug(d.getSlug())
                    .setDescription(d.getDescription()==null
                            ? ""
                            : d.getDescription())
                    .setParentId(d.getParentId() == null
                            ? ""
                            : d.getParentId())
                    .build());
    }

    @Override
    public void list(
            CategoryListRequest request,
            StreamObserver<PageCategory> responseObserver) {
        Envelope.Page<CategoryResponseDto> page = categoryService.list(
                request.getQ(),
                request.getPage(),
                request.getSize()
        );
        PageCategory.Builder b = PageCategory.newBuilder()
                .setPage(page.getPage())
                .setSize(page.getSize())
                .setTotal(page.getTotal())
                .setTotalPages(page.getTotalPages());
        page.getDocs().forEach(d -> b.addDocs(CategoryView.newBuilder()
                .setId(d.getId())
                .setName(d.getName())
                .setSlug(d.getSlug())
                .setDescription(d.getDescription() == null
                        ? ""
                        : d.getDescription())
                .setParentId(d.getParentId() == null
                        ? ""
                        : d.getParentId())
                .build()));
        GrpcStatusMapper.ok(responseObserver, b.build());
    }

    // full tree
    @Override
    public void tree(
            Empty request,
            StreamObserver<CategoryTreeNode> responseObserver) {
        com.business.dto.model.CategoryTreeNode root = categoryService.tree();
        GrpcStatusMapper.ok(responseObserver, toGrpc(root));
    }

    private CategoryTreeNode toGrpc(com.business.dto.model.CategoryTreeNode n){
        CategoryTreeNode.Builder builder = CategoryTreeNode.newBuilder();
        if (n.getData()!=null){
            var d = n.getData();
            builder.setData(CategoryView.newBuilder()
                    .setId(d.getId())
                    .setName(d.getName())
                    .setSlug(d.getSlug())
                    .setDescription(d.getDescription() == null
                            ? ""
                            : d.getDescription())
                    .setParentId(d.getParentId() == null
                            ? ""
                            : d.getParentId())
                    .build());
        }
        n.getChildren().forEach(c -> builder.addChildren(toGrpc(c)));
        return builder.build();
    }

    @Override
    public void children(
            CategoryChildrenRequest request,
            StreamObserver<PageCategory> responseObserver) {
        Envelope.Page<CategoryResponseDto> page = categoryService.children(
                request.getId().isBlank()
                        ? null
                        : request.getId(),
                0, Integer.MAX_VALUE);
        PageCategory.Builder b = PageCategory.newBuilder()
                .setPage(page.getPage())
                .setSize(page.getSize())
                .setTotal(page.getTotal())
                .setTotalPages(page.getTotalPages());
        page.getDocs().forEach(d -> b.addDocs(CategoryView.newBuilder()
                .setId(d.getId())
                .setName(d.getName())
                .setSlug(d.getSlug())
                .setDescription(d.getDescription() == null
                        ? ""
                        : d.getDescription())
                .setParentId(d.getParentId() == null
                        ? ""
                        : d.getParentId())
                .build()));
        GrpcStatusMapper.ok(responseObserver, b.build());
    }
}
