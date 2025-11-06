package com.core.controller;

import com.common.grpc.MeResponse;
import com.common.grpc.ToggleActiveRequest;
import com.common.grpc.UpdateProfileRequest;
import com.common.grpc.UserServiceGrpc;
import com.core.dto.request.user.UpdateProfileRequestDto;
import com.core.dto.response.user.MeResponseDto;
import com.core.service.IUserService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.common.exception.GrpcStatusMapper;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserGrpcServer extends UserServiceGrpc.UserServiceImplBase {
    private final IUserService userService;

    @Override
    public void toggleActive(
            ToggleActiveRequest request, 
            StreamObserver<Empty> responseObserver) {
        userService.toggleActive(
                request.getUserId(), 
                request.getActive());
        
        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void getMe(
            Empty request,
            StreamObserver<MeResponse> responseObserver) {
        MeResponseDto me = userService.getMe();
        GrpcStatusMapper.ok(responseObserver, MeResponse.newBuilder()
                .setId(me.getId())
                .setUsername(me.getUsername())
                .setEmail(me.getEmail())
                .setFullName(me.getFullName() == null
                        ? ""
                        : me.getFullName())
                .setPhoneNumber(me.getPhoneNumber() == null
                        ? ""
                        : me.getPhoneNumber())
                .setIsActive(Boolean.TRUE.equals(me.getIsActive()))
                .setIsVerified(Boolean.TRUE.equals(me.getIsVerified()))
                .build());
    }

    @Override
    public void updateProfile(
            UpdateProfileRequest request,
            StreamObserver<Empty> responseObserver) {
        userService.updateProfile(UpdateProfileRequestDto.builder()
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .build());
        GrpcStatusMapper.ok(responseObserver);
    }
}