package com.gatewayserver.controller;

import com.common.grpc.AttributeCreateRequest;
import com.common.grpc.AttributeListRequest;
import com.common.grpc.AttributeServiceGrpc;
import com.common.grpc.IdRequest;
import com.common.grpc.VariantAttributeAssignRequest;
import com.common.grpc.VariantIdRequest;
import com.gatewayserver.dto.request.attribute.AssignAttributeRequestBody;
import com.gatewayserver.dto.request.attribute.AttributeCreateRequestBody;
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
@RequestMapping("/attributes")
@RequiredArgsConstructor
public class AttributeController {
  @GrpcClient("business")
  private Channel channel;

  @PostMapping(
      consumes= MediaType.APPLICATION_JSON_VALUE,
      produces=MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> create(
      @RequestBody AttributeCreateRequestBody body){
    return GrpcHelper.callGrpcVoid(channel, AttributeServiceGrpc::newBlockingStub,
        s -> s.create(AttributeCreateRequest.newBuilder()
            .setName(body.name())
            .setValue(body.value())
            .build()));
  }
  @DeleteMapping(
      value="/{id}",
      consumes=MediaType.APPLICATION_JSON_VALUE,
      produces=MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> softDelete(
      @PathVariable String id){
    return GrpcHelper.callGrpcVoid(channel, AttributeServiceGrpc::newBlockingStub,
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
    return GrpcHelper.callGrpcVoid(channel, AttributeServiceGrpc::newBlockingStub,
        s -> s.restore(IdRequest.newBuilder()
            .setId(id)
            .build()));
  }
  @GetMapping(
      produces=MediaType.APPLICATION_JSON_VALUE,
      consumes=MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Envelope.Page<com.gatewayserver.dto.response.attribute.AttributeView>>>> list(
      @RequestParam(required=false) String q,
      @RequestParam(defaultValue="0") int page,
      @RequestParam(defaultValue="20") int size){
    return GrpcHelper.callGrpc(channel, AttributeServiceGrpc::newBlockingStub,
        s -> s.list(AttributeListRequest.newBuilder()
            .setQ(q == null ? "" : q)
            .setPage(page)
            .setSize(size)
            .build()),
        p -> Envelope.Page.<com.gatewayserver.dto.response.attribute.AttributeView>builder()
            .page(p.getPage())
            .size(p.getSize())
            .total(p.getTotal())
            .totalPages(p.getTotalPages())
            .docs(p.getDocsList().stream()
                .map(d -> new com.gatewayserver.dto.response.attribute.AttributeView(
                    d.getId(),
                    d.getName(),
                    d.getValue()))
                .toList())
            .build());
  }

  @PostMapping(
      value="/assign",
      consumes=MediaType.APPLICATION_JSON_VALUE,
      produces=MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> assign(
      @RequestBody AssignAttributeRequestBody body){
    return GrpcHelper.callGrpcVoid(channel, AttributeServiceGrpc::newBlockingStub,
        s -> s.assignToVariant(VariantAttributeAssignRequest.newBuilder()
            .setVariantId(body.variantId())
            .setAttributeId(body.attributeId())
            .build()));
  }
  @PostMapping(value="/unassign", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Envelope<Void>>> unassign(@RequestBody AssignAttributeRequestBody body){
    return GrpcHelper.callGrpcVoid(channel, AttributeServiceGrpc::newBlockingStub,
        s -> s.unassignFromVariant(VariantAttributeAssignRequest.newBuilder()
            .setVariantId(body.variantId())
            .setAttributeId(body.attributeId())
            .build()));
  }
  @GetMapping(
      value="/variant/{variantId}",
      consumes=MediaType.APPLICATION_JSON_VALUE,
      produces=MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Envelope.Page<com.gatewayserver.dto.response.attribute.AttributeView>>>> listByVariant(
      @PathVariable String variantId,
      @RequestParam(defaultValue="0") int page,
      @RequestParam(defaultValue="20") int size){
    return GrpcHelper.callGrpc(channel, AttributeServiceGrpc::newBlockingStub,
        s -> s.listByVariant(VariantIdRequest.newBuilder()
            .setVariantId(variantId)
            .setPage(page)
            .setSize(size)
            .build()),
        p -> Envelope.Page.<com.gatewayserver.dto.response.attribute.AttributeView>builder()
            .page(p.getPage())
            .size(p.getSize())
            .total(p.getTotal())
            .totalPages(p.getTotalPages())
            .docs(p.getDocsList().stream()
                .map(d -> new com.gatewayserver.dto.response.attribute.AttributeView(
                    d.getId(),
                    d.getName(),
                    d.getValue()))
                .toList())
            .build());
  }
}
