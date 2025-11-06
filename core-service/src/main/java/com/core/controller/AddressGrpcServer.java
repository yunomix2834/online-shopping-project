package com.core.controller;

import com.common.grpc.AddressCreateRequest;
import com.common.grpc.AddressServiceGrpc;
import com.common.grpc.AddressUpdateRequest;
import com.common.grpc.AddressView;
import com.common.grpc.IdRequest;
import com.common.grpc.PageAddress;
import com.common.grpc.UserIdRequest;
import com.core.dto.request.user.AddressCreateRequestDto;
import com.core.dto.request.user.AddressUpdateRequestDto;
import com.core.dto.response.user.AddressResponseDto;
import com.core.service.IAddressService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.common.exception.GrpcStatusMapper;
import org.common.http.Envelope;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AddressGrpcServer extends AddressServiceGrpc.AddressServiceImplBase {
    private final IAddressService addressService;

    @Override 
    public void create(
            AddressCreateRequest r,
            StreamObserver<Empty> responseObserver){
        AddressCreateRequestDto dto = AddressCreateRequestDto.builder()
                .contactName(r.getContactName())
                .contactPhone(r.getContactPhone())
                .addressLine1(r.getAddressLine1())
                .addressLine2(r.getAddressLine2())
                .district(r.getDistrict())
                .city(r.getCity())
                .country(r.getCountry())
                .postalCode(r.getPostalCode())
                .build();
        addressService.create(dto);

        GrpcStatusMapper.ok(responseObserver);
    }

    @Override 
    public void update(
            AddressUpdateRequest r, 
            StreamObserver<Empty> responseObserver){
        AddressUpdateRequestDto dto = AddressUpdateRequestDto.builder()
                .contactName(r.getContactName())
                .contactPhone(r.getContactPhone())
                .addressLine1(r.getAddressLine1())
                .addressLine2(r.getAddressLine2())
                .district(r.getDistrict())
                .city(r.getCity())
                .country(r.getCountry())
                .postalCode(r.getPostalCode())
                .build();
        addressService.update(r.getId(), dto);
        GrpcStatusMapper.ok(responseObserver);
    }
    
    
    @Override 
    public void softDelete(
            IdRequest r, StreamObserver<Empty> responseObserver){
        addressService.softDelete(r.getId());
        GrpcStatusMapper.ok(responseObserver);
    }
    @Override
    public void setDefaultShipping(
            IdRequest r,
            StreamObserver<Empty> responseObserver){
        addressService.setDefaultShipping(r.getId());
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void setDefaultBilling(
            IdRequest r,
            StreamObserver<Empty> responseObserver){
        addressService.setDefaultBilling(r.getId());
        GrpcStatusMapper.ok(responseObserver);
    }
    @Override
    public void listByUser(
            UserIdRequest r,
            StreamObserver<PageAddress> responseObserver){
        Envelope.Page<AddressResponseDto> page = addressService.listByUser(
                r.getUserId(),
                r.getPage(),
                r.getSize()
        );

        PageAddress.Builder b = PageAddress.newBuilder()
                .setPage(page.getPage())
                .setSize(page.getSize())
                .setTotal(page.getTotal())
                .setTotalPages(page.getTotalPages());

        page.getDocs().forEach(v -> b.addDocs(AddressView.newBuilder()
                .setId(v.getId())
                .setContactName(v.getContactName())
                .setContactPhone(v.getContactPhone())
                .setAddressLine1(v.getAddressLine1())
                .setAddressLine2(v.getAddressLine2() == null
                        ? ""
                        : v.getAddressLine2())
                .setDistrict(v.getDistrict())
                .setCity(v.getCity()).setCountry(v.getCountry() == null
                        ? ""
                        : v.getCountry())
                .setPostalCode(v.getPostalCode()==null
                        ? ""
                        : v.getPostalCode())
                .setIsDefaultShipping(Boolean.TRUE.equals(v.getIsDefaultShipping()))
                .setIsDefaultBilling(Boolean.TRUE.equals(v.getIsDefaultBilling()))
                .build()));

        GrpcStatusMapper.ok(responseObserver, b.build());
    }
}