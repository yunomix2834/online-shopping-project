package com.core.controller.core;

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
import com.core.dto.request.authentication.AuthenticationRequestDto;
import com.core.dto.request.authentication.IntrospectRequestDto;
import com.core.dto.request.authentication.RefreshRequestDto;
import com.core.dto.request.authentication.UserCreationRequestDto;
import com.core.dto.response.authentication.AuthenticationResponseDto;
import com.core.dto.response.authentication.IntrospectResponseDto;
import com.core.service.IAuthenticationService;
import com.nimbusds.jose.JOSEException;
import io.grpc.stub.StreamObserver;
import java.text.ParseException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.common.exception.ErrorCode;
import org.common.exception.GrpcStatusMapper;

@GrpcService
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AuthenticationGrpcController
    extends AuthServiceGrpc.AuthServiceImplBase {

  IAuthenticationService authenticationService;

  @Override
  public void register(
      RegisterRequest registerRequest,
      StreamObserver<RegisterResponse> streamObserver) {
    authenticationService.register(UserCreationRequestDto.builder()
        .username(registerRequest.getUsername())
        .email(registerRequest.getEmail())
        .password(registerRequest.getPassword())
        .build());

    GrpcStatusMapper.ok(streamObserver,
        RegisterResponse.newBuilder().build());
  }

  @Override
  public void login(
      LoginRequest loginRequest,
      StreamObserver<LoginResponse> streamObserver) {
    try {
      AuthenticationResponseDto authenticationResponseDto =
          authenticationService.login(
              AuthenticationRequestDto.builder()
                  .username(loginRequest.getUsername())
                  .email(loginRequest.getEmail())
                  .password(loginRequest.getPassword())
                  .build());

      GrpcStatusMapper.ok(streamObserver,
          LoginResponse.newBuilder()
              .setAccessToken(authenticationResponseDto.getAccessToken())
              .setRefreshToken(
                  authenticationResponseDto.getRefreshToken())
              .setAccessExpiry(
                  authenticationResponseDto.getAccessExpiry()
                      .toString())
              .setRefreshExpiry(
                  authenticationResponseDto.getRefreshExpiry()
                      .toString())
              .build());
    } catch (ParseException exception) {
      GrpcStatusMapper.fail(streamObserver,
          ErrorCode.FAILED_VALIDATE_TOKEN);
    }
  }

  @Override
  public void refresh(
      RefreshRequest refreshRequest,
      StreamObserver<RefreshResponse> streamObserver) {
    try {
      AuthenticationResponseDto authenticationResponseDto =
          authenticationService
              .refreshToken(RefreshRequestDto.builder()
                  .token(refreshRequest.getToken())
                  .build());

      GrpcStatusMapper.ok(streamObserver,
          RefreshResponse.newBuilder()
              .setAccessToken(authenticationResponseDto.getAccessToken())
              .setRefreshToken(
                  authenticationResponseDto.getRefreshToken())
              .setAccessExpiry(String.valueOf(
                  authenticationResponseDto.getAccessExpiry()))
              .setRefreshExpiry(String.valueOf(
                  authenticationResponseDto.getRefreshExpiry()))
              .build());
    } catch (ParseException | JOSEException exception) {
      GrpcStatusMapper.fail(streamObserver,
          ErrorCode.FAILED_VALIDATE_TOKEN);
    }
  }

  @Override
  public void introspect(
      IntrospectRequest introspectRequest,
      StreamObserver<IntrospectResponse> responseObserver) {
    try {
      IntrospectResponseDto introspectResponseDto = authenticationService
          .introspect(IntrospectRequestDto.builder()
              .token(introspectRequest.getToken())
              .build());

      GrpcStatusMapper.ok(responseObserver,
          IntrospectResponse.newBuilder()
              .setValid(introspectResponseDto.isValid())
              .setUserId(introspectResponseDto.getUserId() == null
                  ? ""
                  : introspectResponseDto.getUserId())
              .build());
    } catch (ParseException | JOSEException exception) {
      GrpcStatusMapper.fail(responseObserver,
          ErrorCode.FAILED_VALIDATE_TOKEN);
    }
  }

  @Override
  public void logout(
      LogoutRequest logoutRequest,
      StreamObserver<LogoutResponse> responseObserver) {
    try {
      authenticationService.logout(logoutRequest.getToken());
      GrpcStatusMapper.ok(responseObserver,
          LogoutResponse.newBuilder().build());
    } catch (ParseException | JOSEException exception) {
      GrpcStatusMapper.fail(responseObserver,
          ErrorCode.FAILED_VALIDATE_TOKEN);
    }
  }
}
