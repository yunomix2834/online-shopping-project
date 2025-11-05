package com.gatewayserver.exception;

import io.grpc.StatusRuntimeException;
import org.common.http.Envelope;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(StatusRuntimeException.class)
    public Mono<Envelope<Void>> handleGrpcException(StatusRuntimeException ex){
        return Mono.just(GrpcErrorMapper.toEnvelope(ex));
    }

    @ExceptionHandler(Exception.class)
    public Mono<Envelope<Void>> handleAnyException(Exception ex){
        return Mono.just(Envelope.err(500, "UNCATEGORIZED_EXCEPTION", ex.getMessage(), null));
    }
}