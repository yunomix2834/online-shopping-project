package com.core.exception;

import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import lombok.NoArgsConstructor;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;

@NoArgsConstructor
public final class GrpcErrorMapper {

  public static <T> Envelope<T> toEnvelope(
      StatusRuntimeException ex) {
    Status status = ex.getStatus();
    String desc = status.getDescription();

    ErrorCode errorCode = resolveErrorCode(status,
        desc);

    return Envelope.err(
        errorCode.http(),
        errorCode.name(),
        errorCode.getMessage(),
        null
    );
  }


  public static ErrorCode resolveErrorCode(Status status,
                                           String desc) {
    if (desc != null && !desc.isBlank()) {
      try {
        return ErrorCode.valueOf(desc);
      } catch (IllegalArgumentException ignored) {
      }
    }

    return switch (status.getCode()) {
      // 400
      case INVALID_ARGUMENT, FAILED_PRECONDITION, OUT_OF_RANGE -> ErrorCode.VALIDATION_FAILED;

      // 401
      case UNAUTHENTICATED -> ErrorCode.UNAUTHENTICATED;

      // 403
      case PERMISSION_DENIED -> ErrorCode.UNAUTHORIZED;

      // 404
      case NOT_FOUND -> ErrorCode.RESOURCE_NOT_FOUND;

      // 409
      case ALREADY_EXISTS -> ErrorCode.RESOURCE_ALREADY_EXISTS;

      // Các lỗi mạng / internal: là lỗi chưa phân loại
      case UNKNOWN,
           INTERNAL,
           UNAVAILABLE,
           DEADLINE_EXCEEDED,
           RESOURCE_EXHAUSTED,
           ABORTED,
           CANCELLED,
           DATA_LOSS -> ErrorCode.UNCATEGORIZED_EXCEPTION;

      default -> ErrorCode.UNCATEGORIZED_EXCEPTION;
    };
  }
}
