package com.gatewayserver.controller;

import com.common.grpc.IdRequest;
import com.common.grpc.ImageCreateRequest;
import com.common.grpc.ImageListRequest;
import com.common.grpc.ProductImageServiceGrpc;
import com.gatewayserver.dto.request.image.ImageCreateRequestBody;
import com.gatewayserver.helper.GrpcHelper;
import io.grpc.Channel;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.common.http.Envelope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/business/images")
@RequiredArgsConstructor
public class ProductImageController {
  @GrpcClient("business")
  private Channel channel;
  private static String nz(String s){ return s == null ? "" : s; }

  @PostMapping(
      consumes= MediaType.APPLICATION_JSON_VALUE,
      produces=MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> create(
      @RequestBody ImageCreateRequestBody body){
    return GrpcHelper.callGrpcVoid(channel, ProductImageServiceGrpc::newBlockingStub,
        s -> s.create(ImageCreateRequest.newBuilder()
            .setProductId(nz(body.productId()))
            .setVariantId(nz(body.variantId()))
            .setImageUrl(body.imageUrl())
            .build()));
  }

  @DeleteMapping(
      value="/{id}",
      consumes=MediaType.APPLICATION_JSON_VALUE,
      produces=MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> softDelete(
      @PathVariable String id){
    return GrpcHelper.callGrpcVoid(channel, ProductImageServiceGrpc::newBlockingStub,
        s -> s.softDelete(IdRequest.newBuilder()
            .setId(id)
            .build()));
  }
  @PostMapping(
      value="/{id}/restore",
      consumes=MediaType.APPLICATION_JSON_VALUE,
      produces=MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> restore(
      @PathVariable String id){
    return GrpcHelper.callGrpcVoid(channel, ProductImageServiceGrpc::newBlockingStub,
        s -> s.restore(IdRequest.newBuilder()
            .setId(id)
            .build()));
  }

  @PostMapping(
      value="/{id}/thumbnail",
      consumes=MediaType.APPLICATION_JSON_VALUE,
      produces=MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> setThumbnail(
      @PathVariable String id){
    return GrpcHelper.callGrpcVoid(channel, ProductImageServiceGrpc::newBlockingStub,
        s -> s.setThumbnail(IdRequest.newBuilder()
            .setId(id)
            .build()));
  }
  @PostMapping(
      value="/{id}/thumbnail/unset",
      consumes=MediaType.APPLICATION_JSON_VALUE,
      produces=MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> unsetThumbnail(
      @PathVariable String id){
    return GrpcHelper.callGrpcVoid(channel, ProductImageServiceGrpc::newBlockingStub,
        s -> s.unsetThumbnail(IdRequest.newBuilder()
            .setId(id)
            .build()));
  }

  @GetMapping(
      produces=MediaType.APPLICATION_JSON_VALUE,
      consumes=MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Envelope.Page<com.gatewayserver.dto.response.image.ImageView>>>> list(
      @RequestParam(required=false) String productId,
      @RequestParam(required=false) String variantId,
      @RequestParam(defaultValue="0") int page,
      @RequestParam(defaultValue="20") int size){
    return GrpcHelper.callGrpc(channel, ProductImageServiceGrpc::newBlockingStub,
        s -> s.list(ImageListRequest.newBuilder()
            .setProductId(productId == null ? "":productId)
            .setVariantId(variantId == null? "" :variantId)
            .setPage(page)
            .setSize(size)
            .build()),
        p -> Envelope.Page.<com.gatewayserver.dto.response.image.ImageView>builder()
            .page(p.getPage())
            .size(p.getSize())
            .total(p.getTotal())
            .totalPages(p.getTotalPages())
            .docs(p.getDocsList().stream()
                .map(d -> new com.gatewayserver.dto.response.image.ImageView(
                    d.getId(),
                    d.getProductId().isBlank()
                        ? null
                        : d.getProductId(),
                    d.getVariantId().isBlank()
                        ? null
                        : d.getVariantId(),
                    d.getImageUrl(),
                    d.getIsThumbnail()))
                .toList())
            .build());
  }
}
