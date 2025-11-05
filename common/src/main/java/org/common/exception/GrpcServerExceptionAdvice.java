package org.common.exception;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;
import org.springframework.security.access.AccessDeniedException;

@Slf4j
@GrpcAdvice
public class GrpcServerExceptionAdvice {

    @GrpcExceptionHandler(AppException.class)
    public StatusRuntimeException handleAppException(AppException ex) {
        return GrpcStatusMapper.ex(ex.getErrorCode());
    }

    @GrpcExceptionHandler(AccessDeniedException.class)
    public StatusRuntimeException handleDeniedException(AccessDeniedException ex) {
        return GrpcStatusMapper.ex(ErrorCode.UNAUTHORIZED);
    }

    @GrpcExceptionHandler(ConstraintViolationException.class)
    public StatusRuntimeException handleBadException(ConstraintViolationException ex) {
        return GrpcStatusMapper.ex(ErrorCode.FAILED_VALIDATE_TOKEN);
    }

    @GrpcExceptionHandler(Throwable.class)
    public StatusRuntimeException handleAnyException(Throwable th) {
        log.error("UNCAUGHT_GRPC_ERROR", th);
        return Status.INTERNAL.withDescription(ErrorCode.UNCATEGORIZED_EXCEPTION.name())
                .asRuntimeException();
    }
}