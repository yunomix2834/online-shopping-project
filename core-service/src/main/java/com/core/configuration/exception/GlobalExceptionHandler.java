package com.core.configuration.exception;

import lombok.extern.slf4j.Slf4j;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@ConditionalOnProperty(
        name = "core.http.error.enabled",
        havingValue = "true",
        matchIfMissing = false
)
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Envelope<Void>> handleAppException(
            AppException appException){
        ErrorCode errorCode = appException.getErrorCode();
        return ResponseEntity.status(errorCode.getStatusCode())
                .body(Envelope.err(
                        errorCode.http(),
                        errorCode.name(),
                        errorCode.getMessage(),
                        null)
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Envelope<Void>> handleAnyException(
            Exception exception){
        ErrorCode errorCode = ErrorCode.UNCATEGORIZED_EXCEPTION;
        return ResponseEntity.status(errorCode.getStatusCode())
                .body(Envelope.err(
                        errorCode.http(),
                        errorCode.name(),
                        errorCode.getMessage(),
                        null)
                );
    }
}
