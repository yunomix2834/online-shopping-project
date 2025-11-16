package com.core.controller.gateway;

import com.common.grpc.IdRequest;
import com.common.grpc.VariantByProductRequest;
import com.common.grpc.VariantBySkuRequest;
import com.common.grpc.VariantCreateRequest;
import com.common.grpc.VariantPricePatchRequest;
import com.common.grpc.VariantServiceGrpc;
import com.common.grpc.VariantUpdateRequest;
import com.core.dto.request.gateway.variant.VariantCreateRequestBody;
import com.core.dto.request.gateway.variant.VariantPricePatchBody;
import com.core.dto.request.gateway.variant.VariantUpdateRequestBody;
import com.core.helper.GrpcHelper;
import io.grpc.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/variants")
@RequiredArgsConstructor
@Slf4j
public class VariantController {
  @GrpcClient("business")
  private Channel channel;

  private static String nz(String s) {
    return s == null ? "" : s;
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> create(
      @RequestBody VariantCreateRequestBody body) {
    return GrpcHelper.callGrpcVoid(
        channel,
        VariantServiceGrpc::newBlockingStub,
        stub -> stub.create(VariantCreateRequest.newBuilder()
            .setProductId(body.productId())
            .setSku(body.sku())
            .setPrice(body.price())
            .setOriginalPrice(nz(body.originalPrice()))
            .build()));
  }

  @PatchMapping(
      value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> update(
      @PathVariable String id,
      @RequestBody VariantUpdateRequestBody body) {
    return GrpcHelper.callGrpcVoid(
        channel,
        VariantServiceGrpc::newBlockingStub,
        stub -> stub.update(VariantUpdateRequest.newBuilder()
            .setId(id)
            .setSku(nz(body.sku()))
            .setPrice(nz(body.price()))
            .setOriginalPrice(nz(body.originalPrice()))
            .build()));
  }

  @PatchMapping(
      value = "/{id}/price",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> patchPrice(
      @PathVariable String id,
      @RequestBody VariantPricePatchBody body) {
    return GrpcHelper.callGrpcVoid(
        channel,
        VariantServiceGrpc::newBlockingStub,
        stub -> stub.patchPrice(VariantPricePatchRequest.newBuilder()
            .setId(id)
            .setPrice(nz(body.price()))
            .setOriginalPrice(nz(body.originalPrice()))
            .build()));
  }

  @DeleteMapping(
      value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> softDelete(
      @PathVariable String id) {
    return GrpcHelper.callGrpcVoid(channel,
        VariantServiceGrpc::newBlockingStub,
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
      @PathVariable String id) {
    return GrpcHelper.callGrpcVoid(channel,
        VariantServiceGrpc::newBlockingStub,
        stub -> stub.restore(IdRequest.newBuilder()
            .setId(id)
            .build()));
  }

  @GetMapping(
      value = "/sku/{sku}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<com.core.dto.response.gateway.variant.VariantView>>> findBySku(
      @PathVariable String sku) {
    return GrpcHelper.callGrpc(channel,
        VariantServiceGrpc::newBlockingStub,
        stub -> stub.findBySku(VariantBySkuRequest.newBuilder().setSku(sku).build()),
        r -> new com.core.dto.response.gateway.variant.VariantView(
            r.getId(),
            r.getProductId(),
            r.getSku(),
            r.getPrice(),
            r.getOriginalPrice().isBlank()
                ? null
                : r.getOriginalPrice()));
  }

  @GetMapping(
      value = "/product/{productId}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Envelope.Page<com.core.dto.response.gateway.variant.VariantView>>>> listByProduct(
      @PathVariable String productId,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size) {
    return GrpcHelper.callGrpc(channel,
        VariantServiceGrpc::newBlockingStub,
        stub -> stub.listByProduct(VariantByProductRequest.newBuilder()
            .setProductId(productId)
            .setPage(page)
            .setSize(size)
            .build()),
        p -> Envelope.Page.<com.core.dto.response.gateway.variant.VariantView>builder()
            .page(p.getPage())
            .size(p.getSize())
            .total(p.getTotal())
            .totalPages(p.getTotalPages())
            .docs(p.getDocsList()
                .stream()
                .map(d -> new com.core.dto.response.gateway.variant.VariantView(
                    d.getId(),
                    d.getProductId(),
                    d.getSku(),
                    d.getPrice(),
                    d.getOriginalPrice().isBlank()
                        ? null
                        : d.getOriginalPrice())).toList())
            .build());
  }
}
