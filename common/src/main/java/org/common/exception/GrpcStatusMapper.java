package org.common.exception;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GrpcStatusMapper {

  public Status statusFor(ErrorCode errorCode) {
    return switch (errorCode) {
      // 400
      case VALIDATION_FAILED,
           INVALID_OTP,
           OTP_EXPIRED,
           EMAIL_SEND_FAILED,
           FAILED_VALIDATE_TOKEN
          -> Status.INVALID_ARGUMENT;

      // 401
      case UNAUTHENTICATED,
           INVALID_CREDENTIALS,
           INVALID_TOKEN,
           TOKEN_REVOKED
          -> Status.UNAUTHENTICATED;

      // 403
      case UNAUTHORIZED
          -> Status.PERMISSION_DENIED;

      // 404
      case RESOURCE_NOT_FOUND
          -> Status.NOT_FOUND;

      // 409
      case RESOURCE_ALREADY_EXISTS
          -> Status.ALREADY_EXISTS;

      // 500
      default -> Status.INTERNAL;
    };
  }

    public StatusRuntimeException ex(
            ErrorCode errorCode) {
        return statusFor(errorCode)
            .withDescription(errorCode.name())
                .asRuntimeException();
    }

    public <T> void fail(
            StreamObserver<T> streamObserver,
            ErrorCode errorCode) {
        streamObserver.onError(ex(errorCode));
    }

    public void ok(
            StreamObserver<Empty> streamObserver) {
        streamObserver.onNext(Empty.getDefaultInstance());
        streamObserver.onCompleted();
    }

    public static <T> void ok(StreamObserver<? super T> streamObserver, T payload) {
        streamObserver.onNext(payload);
        streamObserver.onCompleted();
    }
}
