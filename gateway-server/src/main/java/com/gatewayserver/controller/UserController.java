package com.gatewayserver.controller;

import com.common.grpc.ToggleActiveRequest;
import com.common.grpc.UpdateProfileRequest;
import com.common.grpc.UserServiceGrpc;
import com.gatewayserver.dto.request.user.UpdateProfileRequestBody;
import com.gatewayserver.dto.response.user.MeResponseView;
import com.gatewayserver.helper.GrpcHelper;
import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.common.http.Envelope;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final GenericResponseService responseBuilder;
    @GrpcClient("core")
    private UserServiceGrpc.UserServiceBlockingStub stub;

    @PostMapping("/toggle-active")
    public Mono<ResponseEntity<Envelope<Void>>> toggleActive(
            @RequestParam String userId,
            @RequestParam boolean active){
        return GrpcHelper.callGrpcVoid(() -> stub.toggleActive(
                ToggleActiveRequest.newBuilder()
                        .setUserId(userId)
                        .setActive(active)
                        .build()));
    }

    @GetMapping("/me")
    public Mono<ResponseEntity<Envelope<MeResponseView>>> me(){
        return GrpcHelper.callGrpc(
                () -> stub.getMe(Empty.getDefaultInstance()),
                response -> new MeResponseView(
                        response.getId(),
                        response.getUsername(),
                        response.getEmail(),
                        response.getFullName(),
                        response.getPhoneNumber(),
                        response.getIsActive(),
                        response.getIsVerified()
                )
        );
    }

    @PatchMapping("/me")
    public Mono<ResponseEntity<Envelope<Void>>> update(
            @RequestBody UpdateProfileRequestBody body){
        return GrpcHelper.callGrpcVoid(() ->
                stub.updateProfile(UpdateProfileRequest.newBuilder()
                        .setFullName(body.fullName() == null
                                ? ""
                                : body.fullName())
                        .setPhoneNumber(body.phoneNumber()==null
                                ? ""
                                : body.phoneNumber())
                        .build()));
    }
}
