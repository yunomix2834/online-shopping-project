package com.gatewayserver.controller;

import com.common.grpc.AddressCreateRequest;
import com.common.grpc.AddressServiceGrpc;
import com.common.grpc.AddressUpdateRequest;
import com.common.grpc.IdRequest;
import com.common.grpc.UserIdRequest;
import com.gatewayserver.dto.request.user.AddressCreateRequestBody;
import com.gatewayserver.dto.request.user.AddressUpdateRequestBody;
import com.gatewayserver.dto.response.user.AddressResponseView;
import com.gatewayserver.helper.GrpcHelper;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.common.http.Envelope;
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
    private AddressServiceGrpc.AddressServiceBlockingStub stub;

    private static String normalize(String s){
        return s == null ? "" : s;
    }

    private static String z(String s){
        return (s == null || s.isBlank()) ? null : s;
    }

    @PostMapping
    public Mono<ResponseEntity<Envelope<Void>>> create(
            @RequestBody AddressCreateRequestBody body){
        return GrpcHelper.callGrpcVoid(() ->
                stub.create(AddressCreateRequest.newBuilder()
                        .setContactName(body.contactName())
                        .setContactPhone(body.contactName())
                        .setAddressLine1(body.addressLine1())
                        .setAddressLine2(body.addressLine2() == null
                                ? ""
                                : body.addressLine2())
                        .setDistrict(body.district())
                        .setCity(body.city())
                        .setCountry(body.country()==null
                                ? ""
                                : body.country())
                        .setPostalCode(body.postalCode()==null
                                ? ""
                                : body.postalCode())
                        .build()));
    }

    @PatchMapping("/{id}")
    public Mono<ResponseEntity<Envelope<Void>>> update(
            @PathVariable String id,
            @RequestBody AddressUpdateRequestBody body){
        return GrpcHelper.callGrpcVoid(() ->
                stub.update(AddressUpdateRequest.newBuilder()
                        .setId(id)
                        .setContactName(normalize(body.contactName()))
                        .setContactPhone(normalize(body.contactPhone()))
                        .setAddressLine1(normalize(body.addressLine1()))
                        .setAddressLine2(normalize(body.addressLine2()))
                        .setDistrict(normalize(body.district()))
                        .setCity(normalize(body.city()))
                        .setCountry(normalize(body.country()))
                        .setPostalCode(normalize(body.postalCode()))
                        .build()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Envelope<Void>>> softDelete(
            @PathVariable String id){
        return GrpcHelper.callGrpcVoid(() -> stub.softDelete(IdRequest.newBuilder()
                .setId(id)
                .build()));
    }

    @PostMapping("/{id}/default-shipping")
    public Mono<ResponseEntity<Envelope<Void>>> setDefaultShipping(
            @PathVariable String id){
        return GrpcHelper.callGrpcVoid(() -> stub.setDefaultShipping(IdRequest.newBuilder()
                .setId(id)
                .build()));
    }

    @PostMapping("/{id}/default-billing")
    public Mono<ResponseEntity<Envelope<Void>>> setDefaultBilling(@PathVariable String id){
        return GrpcHelper.callGrpcVoid(() -> stub.setDefaultBilling(IdRequest.newBuilder()
                .setId(id)
                .build()));
    }

    @GetMapping("/user/{userId}")
    public Mono<ResponseEntity<Envelope<Envelope.Page<AddressResponseView>>>> listByUser(
            @PathVariable String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size){
        return GrpcHelper.callGrpc(
                () -> stub.listByUser(
                        UserIdRequest.newBuilder()
                                .setUserId(userId)
                                .setPage(page)
                                .setSize(size)
                                .build()),
                p -> Envelope.Page.<AddressResponseView>builder()
                        .page(p.getPage())
                        .size(p.getSize())
                        .total(p.getTotal())
                        .totalPages(p.getTotalPages())
                        .docs(p.getDocsList()
                                .stream()
                                .map(d -> new AddressResponseView(
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
                                        d.getIsDefaultBilling())
                                )
                                .toList())
                        .build());
    }
}