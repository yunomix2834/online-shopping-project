package com.core.controller;

import com.common.grpc.OtpResponse;
import com.common.grpc.OtpServiceGrpc;
import com.common.grpc.OtpVerificationRequest;
import com.common.grpc.ResetPasswordRequest;
import com.common.grpc.UserOtpRequest;
import com.core.dto.request.otp.OtpVerificationRequestDto;
import com.core.dto.request.otp.ResetPasswordRequestDto;
import com.core.dto.request.otp.UserOtpRequestDto;
import com.core.dto.response.otp.OtpResponseDto;
import com.core.service.IOtpService;
import com.core.service.IPasswordResetService;
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
public class OtpGrpcController
        extends OtpServiceGrpc.OtpServiceImplBase {

    IOtpService otpService;
    IPasswordResetService passwordResetService;


    @Override
    public void sendOtp(
            UserOtpRequest request,
            StreamObserver<OtpResponse> responseObserver) {
        OtpResponseDto otpResponseDto =
                otpService.sendOtp(UserOtpRequestDto.builder()
                        .email(request.getEmail())
                        .build());

        GrpcStatusMapper.ok(responseObserver, OtpResponse.newBuilder()
                .setEmail(otpResponseDto.getEmail())
                .setMessage(otpResponseDto.getMessage())
                .build());
    }

    @Override
    public void verifyOtp(
            OtpVerificationRequest request,
            StreamObserver<Empty> responseObserver) {
        otpService.verifyOtp(OtpVerificationRequestDto.builder()
                .email(request.getEmail())
                .otpCode(request.getOtpCode())
                .build());

        GrpcStatusMapper.ok(responseObserver);
    }

    @Override
    public void requestResetPassword(
            UserOtpRequest request,
            StreamObserver<OtpResponse> responseObserver) {
        OtpResponseDto otpResponseDto = passwordResetService
                .requestResetPassword(UserOtpRequestDto.builder()
                        .email(request.getEmail())
                        .build());

        GrpcStatusMapper.ok(responseObserver, OtpResponse.newBuilder()
                .setEmail(otpResponseDto.getEmail())
                .setMessage(otpResponseDto.getMessage())
                .build());
    }

    @Override
    public void verifyOtpPassword(
            OtpVerificationRequest request,
            StreamObserver<Empty> responseObserver) {
        passwordResetService.verifyOtpPassword(
                OtpVerificationRequestDto.builder()
                        .email(request.getEmail())
                        .otpCode(request.getOtpCode())
                        .build());

        GrpcStatusMapper.ok(responseObserver);
    }


    @Override
    public void resetPassword(
            ResetPasswordRequest request,
            StreamObserver<Empty> responseObserver) {
        passwordResetService.resetPassword(ResetPasswordRequestDto.builder()
                .email(request.getEmail())
                .otp(request.getOtp())
                .newPassword(request.getNewPassword())
                .build());

        GrpcStatusMapper.ok(responseObserver);
    }
}
