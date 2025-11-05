package com.core.controller;

import com.common.grpc.AuthServiceGrpc;
import com.common.grpc.IntrospectRequest;
import com.common.grpc.IntrospectResponse;
import com.common.grpc.LoginRequest;
import com.common.grpc.LoginResponse;
import com.common.grpc.LogoutRequest;
import com.common.grpc.LogoutResponse;
import com.common.grpc.RefreshRequest;
import com.common.grpc.RefreshResponse;
import com.common.grpc.RegisterRequest;
import com.common.grpc.RegisterResponse;
import com.core.dto.request.AuthenticationRequestDto;
import com.core.dto.request.IntrospectRequestDto;
import com.core.dto.request.RefreshRequestDto;
import com.core.dto.request.UserCreationRequestDto;
import com.core.dto.response.AuthenticationResponseDto;
import com.core.dto.response.IntrospectResponseDto;
import com.core.service.IAuthenticationService;
import io.grpc.stub.StreamObserver;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.exception.GrpcStatusMapper;

import java.text.ParseException;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AuthenticationGrpcServer extends AuthServiceGrpc.AuthServiceImplBase {

    IAuthenticationService authenticationService;

    @Override
    public void register(
            RegisterRequest registerRequest,
            StreamObserver<RegisterResponse> streamObserver) {
        try {
            authenticationService.register(UserCreationRequestDto.builder()
                    .username(registerRequest.getUsername())
                    .email(registerRequest.getEmail())
                    .password(registerRequest.getPassword())
                    .build());
            streamObserver.onNext(RegisterResponse.newBuilder().build());
            streamObserver.onCompleted();
        } catch (AppException appException){
            GrpcStatusMapper.fail(streamObserver, appException.getErrorCode());
        } catch (RuntimeException exception){
            GrpcStatusMapper.fail(streamObserver, ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
    }

    @Override
    public void login(
            LoginRequest loginRequest,
            StreamObserver<LoginResponse> streamObserver) {
        try {
            AuthenticationResponseDto authenticationResponseDto = authenticationService.login(
                    AuthenticationRequestDto.builder()
                    .username(loginRequest.getUsername())
                    .email(loginRequest.getEmail())
                    .password(loginRequest.getPassword())
                    .build());

            streamObserver.onNext(LoginResponse.newBuilder()
                    .setAccessToken(authenticationResponseDto.getAccessToken())
                    .setRefreshToken(authenticationResponseDto.getRefreshToken())
                    .setAccessExpiry(
                            authenticationResponseDto.getAccessExpiry().toString())
                    .setRefreshExpiry(
                            authenticationResponseDto.getRefreshExpiry().toString())
                    .build());
            streamObserver.onCompleted();

        } catch (AppException appException){
            GrpcStatusMapper.fail(streamObserver, appException.getErrorCode());
        } catch (ParseException parseException){
            GrpcStatusMapper.fail(streamObserver, ErrorCode.FAILED_VALIDATE_TOKEN);
        } catch (RuntimeException exception){
            log.error("LOGIN_UNHANDLED", exception);
            GrpcStatusMapper.fail(streamObserver, ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
    }

    @Override
    public void refresh(
            RefreshRequest refreshRequest,
            StreamObserver<RefreshResponse> streamObserver) {
        try {
            AuthenticationResponseDto authenticationResponseDto = authenticationService
                    .refreshToken(RefreshRequestDto.builder()
                            .token(refreshRequest.getToken()).build());

            streamObserver.onNext(RefreshResponse.newBuilder()
                    .setAccessToken(authenticationResponseDto.getAccessToken())
                    .setRefreshToken(authenticationResponseDto.getRefreshToken())
                    .setAccessExpiry(String.valueOf(
                            authenticationResponseDto.getAccessExpiry()))
                    .setRefreshExpiry(String.valueOf(
                            authenticationResponseDto.getRefreshExpiry()))
                    .build());
            streamObserver.onCompleted();

        } catch (AppException appException){
            GrpcStatusMapper.fail(streamObserver, appException.getErrorCode());
        } catch (Exception exception){
            GrpcStatusMapper.fail(streamObserver, ErrorCode.FAILED_VALIDATE_TOKEN);
        }
    }

    @Override
    public void introspect(
            IntrospectRequest introspectRequest,
            StreamObserver<IntrospectResponse> responseObserver) {
        try {
            IntrospectResponseDto introspectResponseDto = authenticationService.introspect(IntrospectRequestDto.builder()
                    .token(introspectRequest.getToken()).build());

            responseObserver.onNext(IntrospectResponse.newBuilder()
                    .setValid(introspectResponseDto.isValid())
                    .setUserId(introspectResponseDto.getUserId() == null ? "" : introspectResponseDto.getUserId())
                    .build());
            responseObserver.onCompleted();

        } catch (AppException appException){
            GrpcStatusMapper.fail(responseObserver, appException.getErrorCode());
        } catch (Exception exception){
            GrpcStatusMapper.fail(responseObserver, ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
    }

    @Override
    public void logout(
            LogoutRequest logoutRequest,
            StreamObserver<LogoutResponse> responseObserver) {
        try {
            authenticationService.logout(logoutRequest.getToken());
            responseObserver.onNext(LogoutResponse.newBuilder().build());
            responseObserver.onCompleted();
        } catch (AppException appException){
            GrpcStatusMapper.fail(responseObserver, appException.getErrorCode());
        } catch (Exception exception){
            GrpcStatusMapper.fail(responseObserver, ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
    }
}
