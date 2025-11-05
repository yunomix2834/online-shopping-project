package com.gatewayserver.helper;

import com.gatewayserver.exception.GrpcErrorMapper;
import io.grpc.StatusRuntimeException;
import lombok.experimental.UtilityClass;
import org.common.http.Envelope;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.function.Function;
import java.util.function.Supplier;

@UtilityClass
public class GRPCHelper {

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

    public Mono<ResponseEntity<Envelope<Void>>> callGrpcVoid(Runnable runnable) {
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

}
