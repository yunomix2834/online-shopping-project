package com.gatewayserver.controller;

import com.common.grpc.OtpServiceGrpc;
import com.common.grpc.OtpVerificationRequest;
import com.common.grpc.ResetPasswordRequest;
import com.common.grpc.UserOtpRequest;
import com.gatewayserver.dto.request.otp.OtpVerificationRequestBody;
import com.gatewayserver.dto.request.otp.ResetPasswordRequestBody;
import com.gatewayserver.dto.request.otp.UserOtpRequestBody;
import com.gatewayserver.dto.response.otp.OtpResponseView;
import com.gatewayserver.helper.GrpcHelper;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.common.http.Envelope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class OtpController {

    @GrpcClient("core")
    private OtpServiceGrpc.OtpServiceBlockingStub stub;

    //OTP
    @PostMapping(
            value = "/otp",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<OtpResponseView>>> sendOtp(
            @RequestBody UserOtpRequestBody body) {
        return GrpcHelper.callGrpc(() -> stub.sendOtp(UserOtpRequest.newBuilder()
                        .setEmail(body.email())
                        .build()),
                response -> new OtpResponseView(
                        response.getEmail(),
                        response.getMessage()
                )
        );
    }

    @PostMapping(
            value = "/otp/verify",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> verifyOtp(
            @RequestBody OtpVerificationRequestBody body) {
        return GrpcHelper.callGrpcVoid(() -> stub.verifyOtp(
                OtpVerificationRequest.newBuilder()
                        .setEmail(body.email())
                        .setOtpCode(body.otpCode())
                        .build()));
    }

    //Password
    @PostMapping(
            value = "/password-reset",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<OtpResponseView>>> requestResetPassword(
            @RequestBody UserOtpRequestBody body) {
        return GrpcHelper.callGrpc(() -> stub.requestResetPassword(
                        UserOtpRequest.newBuilder()
                                .setEmail(body.email()).build()),
                response -> new OtpResponseView(
                        response.getEmail(),
                        response.getMessage()
                )
        );
    }

    @PostMapping(
            value = "/password-reset/verify",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> verifyOtpPassword(
            @RequestBody OtpVerificationRequestBody body) {
        return GrpcHelper.callGrpcVoid(() -> stub.verifyOtpPassword(
                OtpVerificationRequest.newBuilder()
                        .setEmail(body.email())
                        .setOtpCode(body.otpCode())
                        .build()));
    }

    @PostMapping(
            value = "/password-reset/reset",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> resetPassword(
            @RequestBody ResetPasswordRequestBody body) {
        return GrpcHelper.callGrpcVoid(() -> stub.resetPassword(
                ResetPasswordRequest.newBuilder()
                        .setEmail(body.email())
                        .setOtp(body.otp())
                        .setNewPassword(body.newPassword())
                        .build()));
    }
}


