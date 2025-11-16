package com.core.controller.gateway;

import com.common.grpc.AddressCreateRequest;
import com.common.grpc.AddressServiceGrpc;
import com.common.grpc.AddressUpdateRequest;
import com.common.grpc.IdRequest;
import com.common.grpc.UserIdRequest;
import com.core.dto.request.gateway.user.AddressCreateRequestBody;
import com.core.dto.request.gateway.user.AddressUpdateRequestBody;
import com.core.dto.response.gateway.user.AddressResponseView;
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
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

  @GrpcClient("core")
  private Channel coreChannel;

  private static String nz(String s) {
    return s == null ? "" : s;
  }

  private static String z(String s) {
    return (s == null || s.isBlank()) ? null : s;
  }

  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> create(
      @RequestBody AddressCreateRequestBody body) {
    return GrpcHelper.callGrpcVoid(
        coreChannel,
        ch -> AddressServiceGrpc.newBlockingStub(ch),
        stub -> stub.create(AddressCreateRequest.newBuilder()
            .setContactName(body.contactName())
            .setContactPhone(body.contactPhone())
            .setAddressLine1(body.addressLine1())
            .setAddressLine2(nz(body.addressLine2()))
            .setDistrict(body.district())
            .setCity(body.city())
            .setCountry(nz(body.country()))
            .setPostalCode(nz(body.postalCode()))
            .build())
    );
  }

  @PatchMapping(value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> update(
      @PathVariable String id,
      @RequestBody AddressUpdateRequestBody body) {
    return GrpcHelper.callGrpcVoid(
        coreChannel,
        AddressServiceGrpc::newBlockingStub,
        stub -> stub.update(AddressUpdateRequest.newBuilder()
            .setId(id)
            .setContactName(nz(body.contactName()))
            .setContactPhone(nz(body.contactPhone()))
            .setAddressLine1(nz(body.addressLine1()))
            .setAddressLine2(nz(body.addressLine2()))
            .setDistrict(nz(body.district()))
            .setCity(nz(body.city()))
            .setCountry(nz(body.country()))
            .setPostalCode(nz(body.postalCode()))
            .build())
    );
  }

  @DeleteMapping(value = "/{id}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> softDelete(
      @PathVariable String id) {
    return GrpcHelper.callGrpcVoid(
        coreChannel,
        AddressServiceGrpc::newBlockingStub,
        stub -> stub.softDelete(IdRequest.newBuilder()
            .setId(id)
            .build())
    );
  }

  @PostMapping(value = "/{id}/default-shipping",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> setDefaultShipping(
      @PathVariable String id) {
    return GrpcHelper.callGrpcVoid(
        coreChannel,
        AddressServiceGrpc::newBlockingStub,
        stub -> stub.setDefaultShipping(IdRequest.newBuilder().setId(id).build())
    );
  }

  @PostMapping(value = "/{id}/default-billing",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Void>>> setDefaultBilling(@PathVariable String id) {
    return GrpcHelper.callGrpcVoid(
        coreChannel,
        AddressServiceGrpc::newBlockingStub,
        stub -> stub.setDefaultBilling(IdRequest.newBuilder()
            .setId(id)
            .build())
    );
  }

  @GetMapping(value = "/user/{userId}",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Mono<ResponseEntity<Envelope<Envelope.Page<AddressResponseView>>>> listByUser(
      @PathVariable String userId,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "20") int size) {
    return GrpcHelper.callGrpc(
        coreChannel,
        AddressServiceGrpc::newBlockingStub,
        stub -> stub.listByUser(UserIdRequest.newBuilder()
            .setUserId(userId)
            .setPage(page)
            .setSize(size)
            .build()),
        p -> Envelope.Page.<AddressResponseView>builder()
            .page(p.getPage())
            .size(p.getSize())
            .total(p.getTotal())
            .totalPages(p.getTotalPages())
            .docs(p.getDocsList().stream().map(d -> new AddressResponseView(
                d.getId(),
                d.getContactName(),
                d.getContactPhone(),
                d.getAddressLine1(),
                z(d.getAddressLine2()),
                d.getDistrict(),
                d.getCity(),
                z(d.getCountry()),
                z(d.getPostalCode()),
                d.getIsDefaultShipping(),
                d.getIsDefaultBilling()
            )).toList())
            .build()
    );
  }
}
