package com.gatewayserver.controller;

import com.common.grpc.CategoryCreateRequest;
import com.common.grpc.CategoryListRequest;
import com.common.grpc.CategoryReparentRequest;
import com.common.grpc.CategoryServiceGrpc;
import com.common.grpc.CategoryUpdateRequest;
import com.common.grpc.IdRequest;
import com.common.grpc.SlugRequest;
import com.gatewayserver.dto.request.category.CategoryCreateRequestBody;
import com.gatewayserver.dto.request.category.CategoryReparentRequestBody;
import com.gatewayserver.dto.request.category.CategoryUpdateRequestBody;
import com.gatewayserver.dto.response.category.CategoryView;
import com.gatewayserver.helper.GrpcHelper;
import io.grpc.Channel;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.common.http.Envelope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/business/categories")
@RequiredArgsConstructor
public class CategoryController {

    @GrpcClient("business")
    private Channel businessChannel;

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> create(
            @RequestBody CategoryCreateRequestBody body){
        return GrpcHelper.callGrpcVoid(
                businessChannel, CategoryServiceGrpc::newBlockingStub,
                stub -> stub.create(CategoryCreateRequest.newBuilder()
                        .setName(body.name())
                        .setSlug(body.slug())
                        .setDescription(body.description() == null
                                ? ""
                                : body.description())
                        .setParentId(body.parentId() == null
                                ? ""
                                : body.parentId())
                        .build()));
    }

    @PatchMapping(
        value = "/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> update(
        @PathVariable String id,
        @RequestBody CategoryUpdateRequestBody body){
        return GrpcHelper.callGrpcVoid(
                businessChannel, CategoryServiceGrpc::newBlockingStub,
                stub -> stub.update(CategoryUpdateRequest.newBuilder()
                        .setId(id)
                        .setName(body.name() == null
                            ? ""
                            : body.name())
                        .setSlug(body.slug() == null
                            ? ""
                            : body.slug())
                        .setDescription(body.description() == null
                            ? ""
                            : body.description())
                        .build()));
    }

    @PostMapping(
        value = "/{id}/reparent",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> reparent(
        @PathVariable String id,
        @RequestBody CategoryReparentRequestBody body){
        return GrpcHelper.callGrpcVoid(
                businessChannel, CategoryServiceGrpc::newBlockingStub,
                stub -> stub.reparent(CategoryReparentRequest.newBuilder()
                        .setId(id)
                        .setNewParentId(body.newParentId() == null
                            ? ""
                            : body.newParentId())
                        .build()));
    }

    @DeleteMapping(
        value = "/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> softDelete(
        @PathVariable String id){
        return GrpcHelper.callGrpcVoid(
                businessChannel, CategoryServiceGrpc::newBlockingStub,
                stub -> stub.softDelete(IdRequest.newBuilder()
                    .setId(id)
                    .build()));
    }

    @PostMapping(
        value = "/{id}/restore",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> restore(
        @PathVariable String id){
        return GrpcHelper.callGrpcVoid(
                businessChannel, CategoryServiceGrpc::newBlockingStub,
                stub -> stub.restore(IdRequest.newBuilder()
                    .setId(id)
                    .build()));
    }

    @GetMapping(
        value = "/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<CategoryView>>> getById(
        @PathVariable String id){
        return GrpcHelper.callGrpc(
                businessChannel, CategoryServiceGrpc::newBlockingStub,
                stub -> stub.getById(IdRequest.newBuilder()
                    .setId(id)
                    .build()),
                r -> new CategoryView(
                    r.getId(),
                    r.getName(),
                    r.getSlug(),
                    r.getDescription().isBlank()
                        ? null
                        : r.getDescription(),
                    r.getParentId().isBlank()
                        ? null
                        : r.getParentId()));
    }

    @GetMapping(
        value = "/slug/{slug}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<CategoryView>>> getBySlug(
        @PathVariable String slug){
        return GrpcHelper.callGrpc(
                businessChannel, CategoryServiceGrpc::newBlockingStub,
                stub -> stub.getBySlug(SlugRequest.newBuilder()
                    .setSlug(slug)
                    .build()),
                r -> new CategoryView(
                    r.getId(),
                    r.getName(),
                    r.getSlug(),
                    r.getDescription().isBlank()
                        ? null
                        : r.getDescription(),
                    r.getParentId().isBlank()
                        ? null
                        : r.getParentId()));
    }

    @GetMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Envelope.Page<CategoryView>>>> list(
            @RequestParam(required = false) String q,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size){
        return GrpcHelper.callGrpc(
                businessChannel, CategoryServiceGrpc::newBlockingStub,
                stub -> stub.list(CategoryListRequest.newBuilder()
                    .setQ(q == null ? "" : q)
                    .setPage(page)
                    .setSize(size)
                    .build()),
                p -> Envelope.Page.<CategoryView>builder()
                    .page(p.getPage())
                    .size(p.getSize())
                    .total(p.getTotal()).totalPages(p.getTotalPages())
                    .docs(p.getDocsList().stream()
                                .map(d -> new CategoryView(
                                    d.getId(),
                                    d.getName(),
                                    d.getSlug(),
                                    d.getDescription().isBlank()
                                        ? null
                                        : d.getDescription(),
                                        d.getParentId().isBlank()
                                            ? null
                                            : d.getParentId()))
                                .toList())
                        .build());
    }
}
