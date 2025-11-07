package com.gatewayserver.helper;

import com.gatewayserver.configuration.grpc.ClientBearerInterceptor;
import com.gatewayserver.configuration.helper.ReactiveTokenHelper;
import com.gatewayserver.exception.GrpcErrorMapper;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;
import lombok.experimental.UtilityClass;
import org.common.http.Envelope;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.function.Function;
import java.util.function.Supplier;

@UtilityClass
public class GrpcHelper {

    // ===== Helper chung cho tất cả endpoint =====
    public <R, V> Mono<ResponseEntity<Envelope<V>>> callGrpc(
            Supplier<R> supplier,
            Function<R, V> mapper) {
        return Mono.fromCallable(supplier::get)
                .map(mapper)
                .map(Envelope::ok)
                .map(ResponseEntity::ok)
                .onErrorResume(StatusRuntimeException.class, ex ->
                        Mono.just(GrpcErrorMapper.<V>toEnvelope(ex))
                                .map(env -> ResponseEntity
                                        .status(env.getStatus())
                                        .body(env)))
                .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<ResponseEntity<Envelope<Void>>> callGrpcVoid(
            Runnable runnable) {
        return Mono.fromRunnable(runnable)
                .thenReturn(Envelope.<Void>ok(null))
                .map(ResponseEntity::ok)
                .onErrorResume(io.grpc.StatusRuntimeException.class, ex ->
                        Mono.just(GrpcErrorMapper.<Void>toEnvelope(ex))
                                .map(env -> ResponseEntity
                                        .status(env.getStatus())
                                        .body(env)))
                .subscribeOn(Schedulers.boundedElastic());
    }

    /**
     * Tạo STUB theo từng request + gắn Bearer token vào Metadata
     * @param channel   Channel đã @GrpcClient(...)
     * @param stubMaker Hàm nhận Channel => trả về Stub (BlockingStub)
     * @param caller    Gọi gRPC bằng stub đã gắn token
     * @param mapper    Map response ra view
     */
    public <StubT, RespT, ViewT> Mono<ResponseEntity<Envelope<ViewT>>> callGrpc(
            Channel channel,
            Function<Channel, StubT> stubMaker,
            Function<StubT, RespT> caller,
            Function<RespT, ViewT> mapper
    ) {
        return ReactiveTokenHelper.currentBearerToken()
                .switchIfEmpty(Mono.error(new RuntimeException("UNAUTHENTICATED")))
                .flatMap(token -> Mono.fromCallable(() -> {
                                    Channel authed = ClientBearerInterceptor.withToken(channel, token);
                                    StubT stub = stubMaker.apply(authed);
                                    return caller.apply(stub);
                                })
                                .map(mapper)
                                .map(Envelope::ok)
                                .map(ResponseEntity::ok)
                                .onErrorResume(io.grpc.StatusRuntimeException.class, ex ->
                                        Mono.just(com.gatewayserver.exception.GrpcErrorMapper.<ViewT>toEnvelope(ex))
                                                .map(env -> ResponseEntity.status(env.getStatus()).body(env)))
                                .subscribeOn(Schedulers.boundedElastic())
                );
    }

    public <StubT> Mono<ResponseEntity<Envelope<Void>>> callGrpcVoid(
            Channel channel,
            Function<Channel, StubT> stubMaker,
            java.util.function.Consumer<StubT> caller
    ) {
        return ReactiveTokenHelper.currentBearerToken()
                .switchIfEmpty(Mono.error(new RuntimeException("UNAUTHENTICATED")))
                .flatMap(token -> Mono.fromRunnable(() -> {
                                    Channel authed = ClientBearerInterceptor.withToken(channel, token);
                                    StubT stub = stubMaker.apply(authed);
                                    caller.accept(stub);
                                })
                                .thenReturn(Envelope.<Void>ok(null))
                                .map(ResponseEntity::ok)
                                .onErrorResume(io.grpc.StatusRuntimeException.class, ex ->
                                        Mono.just(com.gatewayserver.exception.GrpcErrorMapper.<Void>toEnvelope(ex))
                                                .map(env -> ResponseEntity.status(env.getStatus()).body(env)))
                                .subscribeOn(Schedulers.boundedElastic())
                );
    }
}
