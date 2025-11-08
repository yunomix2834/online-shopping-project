package com.business.controller;

import com.business.dto.request.AttributeCreateRequestDto;
import com.business.dto.response.AttributeResponseDto;
import com.business.service.IAttributeService;
import com.common.grpc.AttributeListRequest;
import com.common.grpc.AttributeServiceGrpc;
import com.common.grpc.AttributeView;
import com.common.grpc.IdRequest;
import com.common.grpc.PageAttribute;
import com.common.grpc.VariantAttributeAssignRequest;
import com.common.grpc.VariantIdRequest;
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
public class AttributeGrpcServer
    extends AttributeServiceGrpc.AttributeServiceImplBase {

  IAttributeService attributeService;

  private AttributeView map(AttributeResponseDto d) {
    return AttributeView.newBuilder()
        .setId(d.getId())
        .setName(d.getName())
        .setValue(d.getValue())
        .build();
  }

  @Override
  public void create(
      com.common.grpc.AttributeCreateRequest request,
      StreamObserver<Empty> responseObserver) {
    attributeService.create(AttributeCreateRequestDto.builder()
        .name(request.getName())
        .value(request.getValue())
        .build());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void softDelete(
      IdRequest request,
      StreamObserver<Empty> responseObserver) {
    attributeService.softDelete(request.getId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void restore(
      IdRequest request,
      StreamObserver<Empty> responseObserver) {
    attributeService.restore(request.getId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void list(
      AttributeListRequest request,
      StreamObserver<PageAttribute> responseObserver) {
    Envelope.Page<AttributeResponseDto> page = attributeService.list(
        request.getQ(), request.getPage(), request.getSize());

    PageAttribute.Builder b = PageAttribute.newBuilder()
        .setPage(page.getPage())
        .setSize(page.getSize())
        .setTotal(page.getTotal())
        .setTotalPages(page.getTotalPages());
    page.getDocs().forEach(d -> b.addDocs(map(d)));
    GrpcStatusMapper.ok(responseObserver, b.build());
  }

  @Override
  public void assignToVariant(
      VariantAttributeAssignRequest request,
      StreamObserver<Empty> responseObserver) {
    attributeService.assignToVariant(request.getVariantId(), request.getAttributeId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void unassignFromVariant(
      VariantAttributeAssignRequest request,
      StreamObserver<Empty> responseObserver) {
    attributeService.unassignFromVariant(request.getVariantId(), request.getAttributeId());
    GrpcStatusMapper.ok(responseObserver);
  }

  @Override
  public void listByVariant(
      VariantIdRequest request,
      StreamObserver<PageAttribute> responseObserver) {
    Envelope.Page<AttributeResponseDto> page = attributeService.listByVariant(
        request.getVariantId(), request.getPage(), request.getSize());

    PageAttribute.Builder b = PageAttribute.newBuilder()
        .setPage(page.getPage())
        .setSize(page.getSize())
        .setTotal(page.getTotal())
        .setTotalPages(page.getTotalPages());
    page.getDocs().forEach(d -> b.addDocs(map(d)));
    GrpcStatusMapper.ok(responseObserver, b.build());
  }
}
