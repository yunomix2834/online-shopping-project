package com.gatewayserver.controller;

import com.common.grpc.ArchiveRequest;
import com.common.grpc.AssignCategoryRequest;
import com.common.grpc.IdRequest;
import com.common.grpc.ProductCreateRequest;
import com.common.grpc.ProductListRequest;
import com.common.grpc.ProductServiceGrpc;
import com.common.grpc.ProductStatus;
import com.common.grpc.ProductUpdateRequest;
import com.common.grpc.PublishRequest;
import com.common.grpc.SlugRequest;
import com.common.grpc.UnassignCategoryRequest;
import com.common.grpc.UnpublishRequest;
import com.gatewayserver.dto.request.product.AssignCategoryRequestBody;
import com.gatewayserver.dto.request.product.ProductCreateRequestBody;
import com.gatewayserver.dto.request.product.ProductUpdateRequestBody;
import com.gatewayserver.dto.response.product.ProductView;
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
@RequestMapping("/business/products")
@RequiredArgsConstructor
public class ProductController {

    @GrpcClient("business")
    private Channel businessChannel;

    private static String nz(String s){return s == null ? "" : s;}
    private static String z(String s){return (s == null || s.isBlank()) ? null : s;}

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> create(
        @RequestBody ProductCreateRequestBody body){
        return GrpcHelper.callGrpcVoid(
                businessChannel, ProductServiceGrpc::newBlockingStub,
                stub -> stub.create(ProductCreateRequest.newBuilder()
                    .setName(body.name())
                    .setSlug(body.slug())
                    .setDescription(nz(body.description()))
                    .setBrandId(nz(body.brandId()))
                    .build()));
    }

    @PatchMapping(
        value="/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<Envelope<Void>>> update(
        @PathVariable String id,
        @RequestBody ProductUpdateRequestBody body){
        return GrpcHelper.callGrpcVoid(
                businessChannel, ProductServiceGrpc::newBlockingStub,
                stub -> stub.update(ProductUpdateRequest.newBuilder()
                        .setId(id)
                        .setName(nz(body.name()))
                        .setSlug(nz(body.slug()))
                        .setDescription(nz(body.description()))
                        .setBrandId(nz(body.brandId()))
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
                businessChannel, ProductServiceGrpc::newBlockingStub,
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
                businessChannel, ProductServiceGrpc::newBlockingStub,
                stub -> stub.restore(IdRequest.newBuilder()
                    .setId(id)
                    .build()));
    }

    @PostMapping(
        value = "/{id}/publish",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> publish(
        @PathVariable String id){
        return GrpcHelper.callGrpcVoid(
                businessChannel, ProductServiceGrpc::newBlockingStub,
                stub -> stub.publish(PublishRequest.newBuilder()
                    .setId(id)
                    .build()));
    }
    @PostMapping(
        value = "/{id}/unpublish",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> unpublish(
        @PathVariable String id){
        return GrpcHelper.callGrpcVoid(
                businessChannel, ProductServiceGrpc::newBlockingStub,
                stub -> stub.unpublish(UnpublishRequest.newBuilder().setId(id)
                    .build()));
    }
    @PostMapping(
        value = "/{id}/archive",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> archive(
        @PathVariable String id){
        return GrpcHelper.callGrpcVoid(
                businessChannel, ProductServiceGrpc::newBlockingStub,
                stub -> stub.archive(ArchiveRequest.newBuilder()
                    .setId(id)
                    .build()));
    }

    @GetMapping(
        value = "/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<ProductView>>> getById(
        @PathVariable String id){
        return GrpcHelper.callGrpc(
                businessChannel, ProductServiceGrpc::newBlockingStub,
                stub -> stub.getById(IdRequest.newBuilder()
                    .setId(id)
                    .build()),
                r -> new ProductView(
                    r.getId(),
                    r.getName(),
                    r.getSlug(),
                    r.getDescription().isBlank()
                        ? null
                        : r.getDescription(),
                    r.getStatus().name(),
                    r.getBrandId().isBlank()
                        ? null
                        : r.getBrandId()));
    }

    @GetMapping(
        value = "/slug/{slug}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<ProductView>>> getBySlug(
        @PathVariable String slug){
        return GrpcHelper.callGrpc(
                businessChannel, ProductServiceGrpc::newBlockingStub,
                stub -> stub.getBySlug(SlugRequest.newBuilder()
                    .setSlug(slug)
                    .build()),
                r -> new ProductView(
                    r.getId(),
                    r.getName(),
                    r.getSlug(),
                    r.getDescription().isBlank()
                        ? null
                        : r.getDescription(),
                    r.getStatus().name(),
                    r.getBrandId().isBlank()
                        ? null
                        : r.getBrandId()));
    }

    @GetMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Envelope.Page<ProductView>>>> list(
            @RequestParam(required = false) String q,
            @RequestParam(required = false) String brandId,
            @RequestParam(required = false) String categoryId,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size){
        return GrpcHelper.callGrpc(
                businessChannel, ProductServiceGrpc::newBlockingStub,
                stub -> {
                    ProductListRequest.Builder b = ProductListRequest.newBuilder()
                            .setQ(nz(q))
                            .setBrandId(nz(brandId))
                            .setCategoryId(nz(categoryId))
                            .setPage(page).setSize(size);
                    if (status!=null && !status.isBlank()) {
                        b.setStatus(ProductStatus.valueOf(status));
                    }
                    return stub.list(b.build());
                },
                p -> Envelope.Page.<ProductView>builder()
                    .page(p.getPage())
                    .size(p.getSize())
                    .total(p.getTotal())
                    .totalPages(p.getTotalPages())
                    .docs(p.getDocsList().stream()
                                .map(d -> new ProductView(
                                        d.getId(), d.getName(), d.getSlug(),
                                        d.getDescription().isBlank()?null:d.getDescription(),
                                        d.getStatus().name(),
                                        d.getBrandId().isBlank()?null:d.getBrandId()))
                                .toList())
                        .build());
    }

    @PostMapping(
        value = "/assign-category",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> assignCategory(
        @RequestBody AssignCategoryRequestBody body){
        return GrpcHelper.callGrpcVoid(
                businessChannel, ProductServiceGrpc::newBlockingStub,
                stub -> stub.assignCategory(AssignCategoryRequest.newBuilder()
                        .setProductId(body.productId())
                        .setCategoryId(body.categoryId())
                        .build()));
    }

    @PostMapping(
        value = "/unassign-category",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> unassignCategory(
        @RequestBody AssignCategoryRequestBody body){
        return GrpcHelper.callGrpcVoid(
                businessChannel, ProductServiceGrpc::newBlockingStub,
                stub -> stub.unassignCategory(UnassignCategoryRequest.newBuilder()
                        .setProductId(body.productId())
                        .setCategoryId(body.categoryId())
                        .build()));
    }
}
