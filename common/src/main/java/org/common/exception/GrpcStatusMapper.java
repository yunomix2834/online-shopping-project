package org.common.exception;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GrpcStatusMapper {

    public Status statusFor(
            ErrorCode errorCode) {
        return switch (errorCode) {
            case UNAUTHENTICATED, INVALID_CREDENTIALS, INVALID_TOKEN, TOKEN_REVOKED -> Status.UNAUTHENTICATED;
            case UNAUTHORIZED        -> Status.PERMISSION_DENIED;
            case USER_NOT_FOUND      -> Status.NOT_FOUND;
            case USER_ALREADY_EXISTS, EMAIL_ALREADY_EXISTS, PASSWORD_ALREADY_EXISTS -> Status.ALREADY_EXISTS;
            case FAILED_VALIDATE_TOKEN -> Status.INVALID_ARGUMENT;
            default -> Status.INTERNAL;
        };
    }

    public StatusRuntimeException ex(
            ErrorCode errorCode){
        return statusFor(errorCode).withDescription(errorCode.name())
                .asRuntimeException();
    }

    public <T> void fail(
            StreamObserver<T> streamObserver,
            ErrorCode errorCode){
        streamObserver.onError(ex(errorCode));
    }

    public void ok(
            StreamObserver<Empty> streamObserver){
        streamObserver.onNext(Empty.getDefaultInstance());
        streamObserver.onCompleted();
    }
}
