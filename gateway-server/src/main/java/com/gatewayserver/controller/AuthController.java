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
import com.gatewayserver.dto.response.IntrospectView;
import com.gatewayserver.dto.response.LoginView;
import com.gatewayserver.dto.response.RefreshView;
import com.gatewayserver.exception.GrpcErrorMapper;
import com.gatewayserver.helper.GRPCHelper;
import io.grpc.StatusRuntimeException;
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
import reactor.core.scheduler.Schedulers;

import java.util.function.Function;
import java.util.function.Supplier;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    @GrpcClient("core")
    private AuthServiceGrpc.AuthServiceBlockingStub auth;

    // ===== Endpoints =====
    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> register(@RequestBody RegisterRequestBody body) {
        return GRPCHelper.callGrpcVoid(() -> auth.register(RegisterRequest.newBuilder()
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
    public Mono<ResponseEntity<Envelope<LoginView>>> login(@RequestBody LoginRequestBody body) {
        return GRPCHelper.callGrpc(() -> auth.login(LoginRequest.newBuilder()
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
    public Mono<ResponseEntity<Envelope<RefreshView>>> refresh(@RequestBody RefreshRequestBody body) {
        return GRPCHelper.callGrpc(
                () -> auth.refresh(RefreshRequest.newBuilder().setToken(body.token()).build()),
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
    public Mono<ResponseEntity<Envelope<IntrospectView>>> introspect(@RequestBody IntrospectRequestBody body) {
        return GRPCHelper.callGrpc(
                () -> auth.introspect(IntrospectRequest.newBuilder().setToken(body.token()).build()),
                resp -> new IntrospectView(resp.getValid(), resp.getUserId())
        );
    }

    @PostMapping(
            value = "/logout",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Mono<ResponseEntity<Envelope<Void>>> logout(@RequestBody LogoutRequestBody body) {
        return GRPCHelper.callGrpcVoid(() -> auth.logout(LogoutRequest.newBuilder()
                .setToken(body.token())
                .build()));
    }
}