package com.gatewayserver.controller;

import com.common.grpc.AuthServiceGrpc;
import com.common.grpc.IntrospectRequest;
import com.common.grpc.IntrospectResponse;
import com.common.grpc.LoginRequest;
import com.common.grpc.LoginResponse;
import com.common.grpc.LogoutRequest;
import com.common.grpc.RefreshRequest;
import com.common.grpc.RefreshResponse;
import com.common.grpc.RegisterRequest;
import com.gatewayserver.dto.request.IntrospectRequestBody;
import com.gatewayserver.dto.request.LoginRequestBody;
import com.gatewayserver.dto.request.LogoutRequestBody;
import com.gatewayserver.dto.request.RefreshRequestBody;
import com.gatewayserver.dto.request.RegisterRequestBody;
import com.gatewayserver.exception.GrpcErrorMapper;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.common.http.Envelope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @GrpcClient("core")
    private AuthServiceGrpc.AuthServiceBlockingStub authServiceBlockingStub;

    @PostMapping(
            value="/register", 
            consumes= MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<Envelope<Void>> register(
            @RequestBody RegisterRequestBody body){
        try {
            authServiceBlockingStub.register(RegisterRequest.newBuilder()
                    .setUsername(body.username())
                    .setEmail(body.email())
                    .setPassword(body.password())
                    .build());
            return Mono.just(Envelope.ok(null));
        } catch (io.grpc.StatusRuntimeException ex){
            return Mono.just(GrpcErrorMapper.toEnvelope(ex));
        }
    }

    @PostMapping("/login")
    public Mono<Envelope<LoginResponse>> login(
            @RequestBody LoginRequestBody body){
        try {
            LoginResponse response = authServiceBlockingStub.login(LoginRequest.newBuilder()
                    .setUsername(body.username())
                    .setEmail(body.email())
                    .setPassword(body.password())
                    .build());
            return Mono.just(Envelope.ok(response));
        } catch (io.grpc.StatusRuntimeException ex){
            return Mono.just(GrpcErrorMapper.toEnvelope(ex));
        }
    }

    @PostMapping("/refresh")
    public Mono<Envelope<RefreshResponse>> refresh(
            @RequestBody RefreshRequestBody body){
        try {
            RefreshResponse resp = authServiceBlockingStub.refresh(
                    RefreshRequest.newBuilder()
                            .setToken(body.token())
                            .build());
            return Mono.just(Envelope.ok(resp));
        } catch (io.grpc.StatusRuntimeException ex){
            return Mono.just(GrpcErrorMapper.toEnvelope(ex));
        }
    }

    @PostMapping("/introspect")
    public Mono<Envelope<IntrospectResponse>> introspect(
            @RequestBody IntrospectRequestBody body){
        try {
            IntrospectResponse response = authServiceBlockingStub.introspect(IntrospectRequest.newBuilder()
                            .setToken(body.token())
                            .build());
            return Mono.just(Envelope.ok(response));
        } catch (io.grpc.StatusRuntimeException ex){
            return Mono.just(GrpcErrorMapper.toEnvelope(ex));
        }
    }

    @PostMapping("/logout")
    public Mono<Envelope<Void>> logout(
            @RequestBody LogoutRequestBody body){
        try {
            authServiceBlockingStub.logout(LogoutRequest.newBuilder()
                            .setToken(body.token())
                            .build());
            return Mono.just(Envelope.ok(null));
        } catch (io.grpc.StatusRuntimeException ex){
            return Mono.just(GrpcErrorMapper.toEnvelope(ex));
        }
    }
}