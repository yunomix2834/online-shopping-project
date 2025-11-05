package com.gatewayserver.exception;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import lombok.NoArgsConstructor;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

@NoArgsConstructor
public final class GrpcErrorMapper {
    private static final Map<Status.Code, ErrorCode> FALLBACK_BY_GRPC =
            new EnumMap<>(Status.Code.class);
    static {
        FALLBACK_BY_GRPC.put(Status.Code.UNAUTHENTICATED, ErrorCode.UNAUTHENTICATED);
        FALLBACK_BY_GRPC.put(Status.Code.PERMISSION_DENIED, ErrorCode.UNAUTHORIZED);
        FALLBACK_BY_GRPC.put(Status.Code.NOT_FOUND, ErrorCode.USER_NOT_FOUND);
        FALLBACK_BY_GRPC.put(Status.Code.ALREADY_EXISTS, ErrorCode.USER_ALREADY_EXISTS);
        FALLBACK_BY_GRPC.put(Status.Code.INVALID_ARGUMENT, ErrorCode.FAILED_VALIDATE_TOKEN);
        FALLBACK_BY_GRPC.put(Status.Code.FAILED_PRECONDITION, ErrorCode.FAILED_VALIDATE_TOKEN);
    }

    private static Optional<ErrorCode> fromName(
            String name){
        if (name == null || name.isBlank()) {
            return Optional.empty();
        }
        try {
            return Optional.of(ErrorCode.valueOf(name));
        } catch (IllegalArgumentException ex) {
            return Optional.empty();
        }
    }

    public static <T> Envelope<T> toEnvelope(
            StatusRuntimeException exception){
        String description = exception.getStatus().getDescription();
        Status.Code grpc = exception.getStatus().getCode();

        ErrorCode errorCode = fromName(description)
                .orElse(FALLBACK_BY_GRPC.getOrDefault(grpc, ErrorCode.UNCATEGORIZED_EXCEPTION));

        return Envelope.err(
                errorCode.http(),
                errorCode.name(),
                errorCode.getMessage(),
                null
        );
    }
}