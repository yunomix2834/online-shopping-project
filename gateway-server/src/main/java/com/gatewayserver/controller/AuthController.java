package com.gatewayserver.controller;

import com.common.grpc.AuthServiceGrpc;
import com.common.grpc.IntrospectRequest;
import com.common.grpc.LoginRequest;
import com.common.grpc.LogoutRequest;
import com.common.grpc.RefreshRequest;
import com.common.grpc.RegisterRequest;
import com.gatewayserver.dto.request.authentication.IntrospectRequestBody;
import com.gatewayserver.dto.request.authentication.LoginRequestBody;
import com.gatewayserver.dto.request.authentication.LogoutRequestBody;
import com.gatewayserver.dto.request.authentication.RefreshRequestBody;
import com.gatewayserver.dto.request.authentication.RegisterRequestBody;
import com.gatewayserver.dto.response.authentication.IntrospectView;
import com.gatewayserver.dto.response.authentication.LoginView;
import com.gatewayserver.dto.response.authentication.RefreshView;
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
public class AuthController {


    @GrpcClient("core")
    private AuthServiceGrpc.AuthServiceBlockingStub auth;

    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> register(
            @RequestBody RegisterRequestBody body) {
        return GrpcHelper.callGrpcVoid(
                () -> auth.register(RegisterRequest.newBuilder()
                        .setUsername(body.username())
                        .setEmail(body.email())
                        .setPassword(body.password())
                        .build()));
    }

    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<LoginView>>> login(
            @RequestBody LoginRequestBody body) {
        return GrpcHelper.callGrpc(() -> auth.login(LoginRequest.newBuilder()
                        .setUsername(body.username())
                        .setEmail(body.email())
                        .setPassword(body.password())
                        .build()),
                response -> new LoginView(
                        response.getAccessToken(),
                        response.getRefreshToken(),
                        response.getAccessExpiry(),
                        response.getRefreshExpiry()
                )
        );
    }

    @PostMapping(
            value = "/refresh",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<RefreshView>>> refresh(
            @RequestBody RefreshRequestBody body) {
        return GrpcHelper.callGrpc(
                () -> auth.refresh(
                        RefreshRequest.newBuilder().setToken(body.token())
                                .build()),
                resp -> new RefreshView(
                        resp.getAccessToken(),
                        resp.getRefreshToken(),
                        resp.getAccessExpiry(),
                        resp.getRefreshExpiry()
                )
        );
    }

    @PostMapping(
            value = "/introspect",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<IntrospectView>>> introspect(
            @RequestBody IntrospectRequestBody body) {
        return GrpcHelper.callGrpc(
                () -> auth.introspect(
                        IntrospectRequest.newBuilder().setToken(body.token())
                                .build()),
                resp -> new IntrospectView(resp.getValid(), resp.getUserId())
        );
    }

    @PostMapping(
            value = "/logout",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> logout(
            @RequestBody LogoutRequestBody body) {
        return GrpcHelper.callGrpcVoid(
                () -> auth.logout(LogoutRequest.newBuilder()
                        .setToken(body.token())
                        .build()));
    }
}