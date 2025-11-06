package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * ===== Services =====
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: user-role-address.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "core.v1.UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.MeRequest,
      com.common.grpc.MeResponse> getMeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Me",
      requestType = com.common.grpc.MeRequest.class,
      responseType = com.common.grpc.MeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.MeRequest,
      com.common.grpc.MeResponse> getMeMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.MeRequest, com.common.grpc.MeResponse> getMeMethod;
    if ((getMeMethod = UserServiceGrpc.getMeMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getMeMethod = UserServiceGrpc.getMeMethod) == null) {
          UserServiceGrpc.getMeMethod = getMeMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.MeRequest, com.common.grpc.MeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Me"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.MeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.MeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("Me"))
              .build();
        }
      }
    }
    return getMeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.UpdateProfileRequest,
      com.common.grpc.UpdateProfileResponse> getUpdateProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProfile",
      requestType = com.common.grpc.UpdateProfileRequest.class,
      responseType = com.common.grpc.UpdateProfileResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.UpdateProfileRequest,
      com.common.grpc.UpdateProfileResponse> getUpdateProfileMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.UpdateProfileRequest, com.common.grpc.UpdateProfileResponse> getUpdateProfileMethod;
    if ((getUpdateProfileMethod = UserServiceGrpc.getUpdateProfileMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getUpdateProfileMethod = UserServiceGrpc.getUpdateProfileMethod) == null) {
          UserServiceGrpc.getUpdateProfileMethod = getUpdateProfileMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.UpdateProfileRequest, com.common.grpc.UpdateProfileResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.UpdateProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.UpdateProfileResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("UpdateProfile"))
              .build();
        }
      }
    }
    return getUpdateProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.ChangePasswordRequest,
      com.common.grpc.ChangePasswordResponse> getChangePasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ChangePassword",
      requestType = com.common.grpc.ChangePasswordRequest.class,
      responseType = com.common.grpc.ChangePasswordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.ChangePasswordRequest,
      com.common.grpc.ChangePasswordResponse> getChangePasswordMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.ChangePasswordRequest, com.common.grpc.ChangePasswordResponse> getChangePasswordMethod;
    if ((getChangePasswordMethod = UserServiceGrpc.getChangePasswordMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getChangePasswordMethod = UserServiceGrpc.getChangePasswordMethod) == null) {
          UserServiceGrpc.getChangePasswordMethod = getChangePasswordMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.ChangePasswordRequest, com.common.grpc.ChangePasswordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ChangePassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ChangePasswordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ChangePasswordResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("ChangePassword"))
              .build();
        }
      }
    }
    return getChangePasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.VerifyEmailOrPhoneRequest,
      com.common.grpc.VerifyEmailOrPhoneResponse> getVerifyEmailOrPhoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyEmailOrPhone",
      requestType = com.common.grpc.VerifyEmailOrPhoneRequest.class,
      responseType = com.common.grpc.VerifyEmailOrPhoneResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.VerifyEmailOrPhoneRequest,
      com.common.grpc.VerifyEmailOrPhoneResponse> getVerifyEmailOrPhoneMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.VerifyEmailOrPhoneRequest, com.common.grpc.VerifyEmailOrPhoneResponse> getVerifyEmailOrPhoneMethod;
    if ((getVerifyEmailOrPhoneMethod = UserServiceGrpc.getVerifyEmailOrPhoneMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getVerifyEmailOrPhoneMethod = UserServiceGrpc.getVerifyEmailOrPhoneMethod) == null) {
          UserServiceGrpc.getVerifyEmailOrPhoneMethod = getVerifyEmailOrPhoneMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.VerifyEmailOrPhoneRequest, com.common.grpc.VerifyEmailOrPhoneResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyEmailOrPhone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.VerifyEmailOrPhoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.VerifyEmailOrPhoneResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("VerifyEmailOrPhone"))
              .build();
        }
      }
    }
    return getVerifyEmailOrPhoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.LockUserRequest,
      com.common.grpc.LockUserResponse> getLockUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LockUser",
      requestType = com.common.grpc.LockUserRequest.class,
      responseType = com.common.grpc.LockUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.LockUserRequest,
      com.common.grpc.LockUserResponse> getLockUserMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.LockUserRequest, com.common.grpc.LockUserResponse> getLockUserMethod;
    if ((getLockUserMethod = UserServiceGrpc.getLockUserMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getLockUserMethod = UserServiceGrpc.getLockUserMethod) == null) {
          UserServiceGrpc.getLockUserMethod = getLockUserMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.LockUserRequest, com.common.grpc.LockUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LockUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.LockUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.LockUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("LockUser"))
              .build();
        }
      }
    }
    return getLockUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.DuplicateCheckRequest,
      com.common.grpc.DuplicateCheckResponse> getDuplicateCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DuplicateCheck",
      requestType = com.common.grpc.DuplicateCheckRequest.class,
      responseType = com.common.grpc.DuplicateCheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.DuplicateCheckRequest,
      com.common.grpc.DuplicateCheckResponse> getDuplicateCheckMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.DuplicateCheckRequest, com.common.grpc.DuplicateCheckResponse> getDuplicateCheckMethod;
    if ((getDuplicateCheckMethod = UserServiceGrpc.getDuplicateCheckMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getDuplicateCheckMethod = UserServiceGrpc.getDuplicateCheckMethod) == null) {
          UserServiceGrpc.getDuplicateCheckMethod = getDuplicateCheckMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.DuplicateCheckRequest, com.common.grpc.DuplicateCheckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DuplicateCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DuplicateCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DuplicateCheckResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("DuplicateCheck"))
              .build();
        }
      }
    }
    return getDuplicateCheckMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static UserServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingV2Stub>() {
        @java.lang.Override
        public UserServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return UserServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * ===== Services =====
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void me(com.common.grpc.MeRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.MeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMeMethod(), responseObserver);
    }

    /**
     */
    default void updateProfile(com.common.grpc.UpdateProfileRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.UpdateProfileResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateProfileMethod(), responseObserver);
    }

    /**
     */
    default void changePassword(com.common.grpc.ChangePasswordRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ChangePasswordResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChangePasswordMethod(), responseObserver);
    }

    /**
     */
    default void verifyEmailOrPhone(com.common.grpc.VerifyEmailOrPhoneRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.VerifyEmailOrPhoneResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyEmailOrPhoneMethod(), responseObserver);
    }

    /**
     */
    default void lockUser(com.common.grpc.LockUserRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.LockUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLockUserMethod(), responseObserver);
    }

    /**
     */
    default void duplicateCheck(com.common.grpc.DuplicateCheckRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.DuplicateCheckResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDuplicateCheckMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service UserService.
   * <pre>
   * ===== Services =====
   * </pre>
   */
  public static abstract class UserServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return UserServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service UserService.
   * <pre>
   * ===== Services =====
   * </pre>
   */
  public static final class UserServiceStub
      extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     */
    public void me(com.common.grpc.MeRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.MeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateProfile(com.common.grpc.UpdateProfileRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.UpdateProfileResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void changePassword(com.common.grpc.ChangePasswordRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ChangePasswordResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChangePasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verifyEmailOrPhone(com.common.grpc.VerifyEmailOrPhoneRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.VerifyEmailOrPhoneResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyEmailOrPhoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void lockUser(com.common.grpc.LockUserRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.LockUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLockUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void duplicateCheck(com.common.grpc.DuplicateCheckRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.DuplicateCheckResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDuplicateCheckMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service UserService.
   * <pre>
   * ===== Services =====
   * </pre>
   */
  public static final class UserServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingV2Stub> {
    private UserServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.common.grpc.MeResponse me(com.common.grpc.MeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.UpdateProfileResponse updateProfile(com.common.grpc.UpdateProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProfileMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ChangePasswordResponse changePassword(com.common.grpc.ChangePasswordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChangePasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.VerifyEmailOrPhoneResponse verifyEmailOrPhone(com.common.grpc.VerifyEmailOrPhoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyEmailOrPhoneMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.LockUserResponse lockUser(com.common.grpc.LockUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLockUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.DuplicateCheckResponse duplicateCheck(com.common.grpc.DuplicateCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDuplicateCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service UserService.
   * <pre>
   * ===== Services =====
   * </pre>
   */
  public static final class UserServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.common.grpc.MeResponse me(com.common.grpc.MeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.UpdateProfileResponse updateProfile(com.common.grpc.UpdateProfileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProfileMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ChangePasswordResponse changePassword(com.common.grpc.ChangePasswordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChangePasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.VerifyEmailOrPhoneResponse verifyEmailOrPhone(com.common.grpc.VerifyEmailOrPhoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyEmailOrPhoneMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.LockUserResponse lockUser(com.common.grpc.LockUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLockUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.DuplicateCheckResponse duplicateCheck(com.common.grpc.DuplicateCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDuplicateCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service UserService.
   * <pre>
   * ===== Services =====
   * </pre>
   */
  public static final class UserServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.MeResponse> me(
        com.common.grpc.MeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.UpdateProfileResponse> updateProfile(
        com.common.grpc.UpdateProfileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProfileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.ChangePasswordResponse> changePassword(
        com.common.grpc.ChangePasswordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChangePasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.VerifyEmailOrPhoneResponse> verifyEmailOrPhone(
        com.common.grpc.VerifyEmailOrPhoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyEmailOrPhoneMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.LockUserResponse> lockUser(
        com.common.grpc.LockUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLockUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.DuplicateCheckResponse> duplicateCheck(
        com.common.grpc.DuplicateCheckRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDuplicateCheckMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ME = 0;
  private static final int METHODID_UPDATE_PROFILE = 1;
  private static final int METHODID_CHANGE_PASSWORD = 2;
  private static final int METHODID_VERIFY_EMAIL_OR_PHONE = 3;
  private static final int METHODID_LOCK_USER = 4;
  private static final int METHODID_DUPLICATE_CHECK = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ME:
          serviceImpl.me((com.common.grpc.MeRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.MeResponse>) responseObserver);
          break;
        case METHODID_UPDATE_PROFILE:
          serviceImpl.updateProfile((com.common.grpc.UpdateProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.UpdateProfileResponse>) responseObserver);
          break;
        case METHODID_CHANGE_PASSWORD:
          serviceImpl.changePassword((com.common.grpc.ChangePasswordRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.ChangePasswordResponse>) responseObserver);
          break;
        case METHODID_VERIFY_EMAIL_OR_PHONE:
          serviceImpl.verifyEmailOrPhone((com.common.grpc.VerifyEmailOrPhoneRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.VerifyEmailOrPhoneResponse>) responseObserver);
          break;
        case METHODID_LOCK_USER:
          serviceImpl.lockUser((com.common.grpc.LockUserRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.LockUserResponse>) responseObserver);
          break;
        case METHODID_DUPLICATE_CHECK:
          serviceImpl.duplicateCheck((com.common.grpc.DuplicateCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.DuplicateCheckResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getMeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.MeRequest,
              com.common.grpc.MeResponse>(
                service, METHODID_ME)))
        .addMethod(
          getUpdateProfileMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.UpdateProfileRequest,
              com.common.grpc.UpdateProfileResponse>(
                service, METHODID_UPDATE_PROFILE)))
        .addMethod(
          getChangePasswordMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.ChangePasswordRequest,
              com.common.grpc.ChangePasswordResponse>(
                service, METHODID_CHANGE_PASSWORD)))
        .addMethod(
          getVerifyEmailOrPhoneMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.VerifyEmailOrPhoneRequest,
              com.common.grpc.VerifyEmailOrPhoneResponse>(
                service, METHODID_VERIFY_EMAIL_OR_PHONE)))
        .addMethod(
          getLockUserMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.LockUserRequest,
              com.common.grpc.LockUserResponse>(
                service, METHODID_LOCK_USER)))
        .addMethod(
          getDuplicateCheckMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.DuplicateCheckRequest,
              com.common.grpc.DuplicateCheckResponse>(
                service, METHODID_DUPLICATE_CHECK)))
        .build();
  }

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.UserRoleAddressProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    UserServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getMeMethod())
              .addMethod(getUpdateProfileMethod())
              .addMethod(getChangePasswordMethod())
              .addMethod(getVerifyEmailOrPhoneMethod())
              .addMethod(getLockUserMethod())
              .addMethod(getDuplicateCheckMethod())
              .build();
        }
      }
    }
    return result;
  }
}
