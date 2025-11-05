package org.common.exception;

import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GrpcStatusMapper {

    public Status statusFor(ErrorCode ec) {
        return switch (ec) {
            case UNAUTHENTICATED, INVALID_CREDENTIALS, INVALID_TOKEN, TOKEN_REVOKED -> Status.UNAUTHENTICATED;
            case UNAUTHORIZED        -> Status.PERMISSION_DENIED;
            case USER_NOT_FOUND      -> Status.NOT_FOUND;
            case USER_ALREADY_EXISTS, EMAIL_ALREADY_EXISTS, PASSWORD_ALREADY_EXISTS -> Status.ALREADY_EXISTS;
            case FAILED_GENERATE_TOKEN, FAILED_VALIDATE_TOKEN, UNCATEGORIZED_EXCEPTION -> Status.INTERNAL;
            default -> Status.INTERNAL;
        };
    }

    public StatusRuntimeException ex(ErrorCode ec){
        return statusFor(ec).withDescription(ec.name()).asRuntimeException();
    }

    public <T> void fail(StreamObserver<T> obs, ErrorCode errorCode){
        obs.onError(ex(errorCode));
    }

    public void ok(StreamObserver<Empty> obs){
        obs.onNext(Empty.getDefaultInstance());
        obs.onCompleted();
    }
}
