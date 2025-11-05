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
@ConditionalOnProperty(name = "core.http.error.enabled", havingValue = "true", matchIfMissing = false)
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Envelope<Void>> handleAppException(AppException ex){
        ErrorCode ec = ex.getErrorCode();
        return ResponseEntity.status(ec.getStatusCode()).body(Envelope.err(ec.http(), ec.name(), ec.getMessage(), null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Envelope<Void>> handleAnyException(Exception ex){
        log.error("REST_UNCAUGHT", ex);
        ErrorCode ec = ErrorCode.UNCATEGORIZED_EXCEPTION;
        return ResponseEntity.status(ec.getStatusCode()).body(Envelope.err(ec.http(), ec.name(), ec.getMessage(), null));
    }
}