package com.core.controller.gateway;

import com.common.grpc.DiscountCodeRequest;
import com.common.grpc.DiscountCreateRequest;
import com.common.grpc.DiscountListRequest;
import com.common.grpc.DiscountServiceGrpc;
import com.common.grpc.DiscountToggleActiveRequest;
import com.common.grpc.DiscountTypeGrpc;
import com.common.grpc.DiscountUpdateRequest;
import com.common.grpc.IdRequest;
import com.core.dto.request.gateway.discount.DiscountCodeRequestBody;
import com.core.dto.request.gateway.discount.DiscountCreateRequestBody;
import com.core.dto.request.gateway.discount.DiscountToggleActiveBody;
import com.core.dto.request.gateway.discount.DiscountUpdateRequestBody;
import com.core.helper.GrpcHelper;
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
@RequestMapping("/business/discounts")
@RequiredArgsConstructor
public class DiscountController {
  @GrpcClient("business")
  private Channel businessChannel;

  private static DiscountTypeGrpc mapType(String t) {
    return ("fixed".equalsIgnoreCase(t) || "fixed_amount".equalsIgnoreCase(t))
        ? DiscountTypeGrpc.FIXED_AMOUNT
        : DiscountTypeGrpc.PERCENTAGE;
  }

  private static String nz(String s) {
    return s == null ? "" : s;
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> create(
      @RequestBody DiscountCreateRequestBody body) {
    return GrpcHelper.callGrpcVoid(businessChannel,
        DiscountServiceGrpc::newBlockingStub,
        s -> s.create(DiscountCreateRequest.newBuilder()
            .setCode(body.code())
            .setType(mapType(body.type()))
            .setValue(body.value())
            .setStartDate(nz(body.startDate()))
            .setEndDate(nz(body.endDate()))
            .setMinOrderValue(nz(body.minOrderValue()))
            .setIsActive(Boolean.TRUE.equals(body.isActive()))
            .build()));
  }

  @PatchMapping(
      value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> update(
      @PathVariable String id,
      @RequestBody DiscountUpdateRequestBody body) {
    return GrpcHelper.callGrpcVoid(businessChannel,
        DiscountServiceGrpc::newBlockingStub,
        s -> s.update(DiscountUpdateRequest.newBuilder()
            .setId(id)
            .setCode(nz(body.code()))
            .setType(mapType(body.type()))
            .setValue(nz(body.value()))
            .setStartDate(nz(body.startDate()))
            .setEndDate(nz(body.endDate()))
            .setMinOrderValue(nz(body.minOrderValue()))
            .setIsActive(body.isActive() != null && body.isActive())
            .build()));
  }

  @DeleteMapping(
      value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> softDelete(
      @PathVariable String id) {
    return GrpcHelper.callGrpcVoid(businessChannel,
        DiscountServiceGrpc::newBlockingStub,
        s -> s.softDelete(IdRequest.newBuilder()
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
    return GrpcHelper.callGrpcVoid(businessChannel,
        DiscountServiceGrpc::newBlockingStub,
        s -> s.restore(IdRequest.newBuilder()
            .setId(id)
            .build()));
  }

  @PostMapping(
      value = "/{id}/active",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> toggleActive(
      @PathVariable String id,
      @RequestBody DiscountToggleActiveBody body) {
    return GrpcHelper.callGrpcVoid(businessChannel,
        DiscountServiceGrpc::newBlockingStub,
        s -> s.toggleActive(DiscountToggleActiveRequest.newBuilder()
            .setId(id)
            .setIsActive(Boolean.TRUE.equals(body.isActive()))
            .build()));
  }

  @GetMapping(
      value = "/code/{code}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<com.core.dto.response.gateway.discount.DiscountView>>> getByCode(
      @PathVariable String code) {
    return GrpcHelper.callGrpc(businessChannel,
        DiscountServiceGrpc::newBlockingStub,
        s -> s.getByCode(DiscountCodeRequest.newBuilder()
            .setCode(code)
            .build()),
        r -> new com.core.dto.response.gateway.discount.DiscountView(
            r.getId(),
            r.getCode(),
            r.getType().name(),
            r.getValue(),
            r.getStartDate(),
            r.getEndDate(),
            r.getMinOrderValue(),
            r.getIsActive()));
  }

  @PostMapping(
      value = "/validate",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<com.core.dto.response.gateway.discount.DiscountValidationView>>> validate(
      @RequestBody DiscountCodeRequestBody body) {
    return GrpcHelper.callGrpc(businessChannel,
        DiscountServiceGrpc::newBlockingStub,
        s -> s.validate(DiscountCodeRequest.newBuilder()
            .setCode(body.code())
            .setOrderValue(nz(body.orderValue()))
            .setAt(nz(body.at()))
            .build()),
        r -> new com.core.dto.response.gateway.discount.DiscountValidationView(
            r.getValid(),
            r.getReason(),
            r.getDiscountAmount()));
  }

  @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Mono<ResponseEntity<Envelope<Envelope.Page<com.core.dto.response.gateway.discount.DiscountView>>>> list(
      @RequestParam(defaultValue = "false") boolean onlyEffective,
      @RequestParam(required = false) String at,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size) {
    return GrpcHelper.callGrpc(businessChannel,
        DiscountServiceGrpc::newBlockingStub,
        s -> s.list(DiscountListRequest.newBuilder()
            .setOnlyEffective(onlyEffective)
            .setAt(at == null ? "" : at)
            .setPage(page)
            .setSize(size)
            .build()),
        p -> Envelope.Page.<com.core.dto.response.gateway.discount.DiscountView>builder()
            .page(p.getPage())
            .size(p.getSize())
            .total(p.getTotal())
            .totalPages(p.getTotalPages())
            .docs(p.getDocsList()
                .stream().map(d -> new com.core.dto.response.gateway.discount.DiscountView(
                    d.getId(),
                    d.getCode(),
                    d.getType().name(),
                    d.getValue(),
                    d.getStartDate(),
                    d.getEndDate(),
                    d.getMinOrderValue(),
                    d.getIsActive()))
                .toList())
            .build());
  }
}
