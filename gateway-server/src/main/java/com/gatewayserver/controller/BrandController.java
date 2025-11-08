package com.gatewayserver.controller;

import com.common.grpc.BrandCreateRequest;
import com.common.grpc.BrandListRequest;
import com.common.grpc.BrandServiceGrpc;
import com.common.grpc.BrandUpdateRequest;
import com.common.grpc.IdRequest;
import com.common.grpc.SlugRequest;
import com.gatewayserver.dto.request.brand.BrandCreateRequestBody;
import com.gatewayserver.dto.request.brand.BrandUpdateRequestBody;
import com.gatewayserver.dto.response.brand.BrandView;
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
@RequestMapping("/business/brands")
@RequiredArgsConstructor
public class BrandController {

    @GrpcClient("business")
    private Channel businessChannel;

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> create(
            @RequestBody BrandCreateRequestBody body){
        return GrpcHelper.callGrpcVoid(
                businessChannel,
                BrandServiceGrpc::newBlockingStub,
                stub -> stub.create(BrandCreateRequest.newBuilder()
                        .setName(body.name())
                        .setSlug(body.slug())
                        .setDescription(body.description()==null?"":body.description())
                        .build()));
    }

    @PatchMapping(
        value ="/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> update(
            @PathVariable String id,
            @RequestBody BrandUpdateRequestBody body){
        return GrpcHelper.callGrpcVoid(
                businessChannel,
                BrandServiceGrpc::newBlockingStub,
                stub -> stub.update(BrandUpdateRequest.newBuilder()
                        .setId(id)
                        .setName(body.name()==null?"":body.name())
                        .setSlug(body.slug()==null?"":body.slug())
                        .setDescription(body.description() == null
                                ? ""
                                : body.description())
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
                businessChannel, BrandServiceGrpc::newBlockingStub,
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
                businessChannel, BrandServiceGrpc::newBlockingStub,
                stub -> stub.restore(IdRequest.newBuilder()
                        .setId(id)
                        .build()));
    }

    @GetMapping(
        value = "/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<BrandView>>> getById(
            @PathVariable String id){
        return GrpcHelper.callGrpc(
                businessChannel, BrandServiceGrpc::newBlockingStub,
                stub -> stub.getById(IdRequest.newBuilder()
                        .setId(id)
                        .build()),
                r -> new BrandView(
                        r.getId(),
                        r.getName(),
                        r.getSlug(),
                        r.getDescription().isBlank()
                                ? null
                                : r.getDescription()));
    }

    @GetMapping(
        value = "/slug/{slug}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<BrandView>>> getBySlug(
            @PathVariable String slug){
        return GrpcHelper.callGrpc(
                businessChannel, BrandServiceGrpc::newBlockingStub,
                stub -> stub.getBySlug(SlugRequest.newBuilder()
                        .setSlug(slug)
                        .build()),
                r -> new BrandView(
                        r.getId(),
                        r.getName(),
                        r.getSlug(),
                        r.getDescription().isBlank()
                                ? null
                                : r.getDescription()));
    }

    @GetMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Envelope.Page<BrandView>>>> list(
            @RequestParam(required = false) String q,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size){
        return GrpcHelper.callGrpc(
                businessChannel, BrandServiceGrpc::newBlockingStub,
                stub -> stub.list(BrandListRequest.newBuilder()
                        .setQ(q == null ? "" : q)
                        .setPage(page)
                        .setSize(size)
                        .build()),
                p -> Envelope.Page.<BrandView>builder()
                        .page(p.getPage())
                        .size(p.getSize())
                        .total(p.getTotal())
                        .totalPages(p.getTotalPages())
                        .docs(p.getDocsList()
                                .stream()
                                .map(d -> new BrandView(
                                        d.getId(),
                                        d.getName(),
                                        d.getSlug(),
                                        d.getDescription().isBlank()
                                                ? null
                                                : d.getDescription()))
                                .toList())
                        .build());
    }
}
