package com.core.exception;

import io.grpc.StatusRuntimeException;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

  @ExceptionHandler(StatusRuntimeException.class)
  public ResponseEntity<Envelope<Void>> handleGrpcException(
      StatusRuntimeException statusRuntimeException) {
    Envelope<Void> envelope = GrpcErrorMapper.toEnvelope(statusRuntimeException);
    return ResponseEntity.status(envelope.getStatus())
        .body(envelope);
  }


  @ExceptionHandler(AppException.class)
  public ResponseEntity<Envelope<Void>> handleAppException(
      AppException ex) {
    ErrorCode code = ex.getErrorCode();
    Envelope<Void> envelope = Envelope.err(
        code.http(),
        code.name(),
        code.getMessage(),
        null
    );
    return ResponseEntity.status(code.http()).body(envelope);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Envelope<Void>> handleAnyException(
      Exception exception) {
    Envelope<Void> envelope = Envelope.err(
        500,
        "UNCATEGORIZED_EXCEPTION",
        exception.getMessage(),
        null
    );
    return ResponseEntity.status(500).body(envelope);
  }
}
