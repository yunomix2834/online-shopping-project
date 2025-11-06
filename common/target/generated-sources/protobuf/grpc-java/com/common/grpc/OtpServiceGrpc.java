package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: otp.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OtpServiceGrpc {

  private OtpServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "core.v1.OtpService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.UserOtpRequest,
      com.common.grpc.OtpResponse> getSendOtpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendOtp",
      requestType = com.common.grpc.UserOtpRequest.class,
      responseType = com.common.grpc.OtpResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.UserOtpRequest,
      com.common.grpc.OtpResponse> getSendOtpMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.UserOtpRequest, com.common.grpc.OtpResponse> getSendOtpMethod;
    if ((getSendOtpMethod = OtpServiceGrpc.getSendOtpMethod) == null) {
      synchronized (OtpServiceGrpc.class) {
        if ((getSendOtpMethod = OtpServiceGrpc.getSendOtpMethod) == null) {
          OtpServiceGrpc.getSendOtpMethod = getSendOtpMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.UserOtpRequest, com.common.grpc.OtpResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendOtp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.UserOtpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OtpResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OtpServiceMethodDescriptorSupplier("SendOtp"))
              .build();
        }
      }
    }
    return getSendOtpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.OtpVerificationRequest,
      com.google.protobuf.Empty> getVerifyOtpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyOtp",
      requestType = com.common.grpc.OtpVerificationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.OtpVerificationRequest,
      com.google.protobuf.Empty> getVerifyOtpMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.OtpVerificationRequest, com.google.protobuf.Empty> getVerifyOtpMethod;
    if ((getVerifyOtpMethod = OtpServiceGrpc.getVerifyOtpMethod) == null) {
      synchronized (OtpServiceGrpc.class) {
        if ((getVerifyOtpMethod = OtpServiceGrpc.getVerifyOtpMethod) == null) {
          OtpServiceGrpc.getVerifyOtpMethod = getVerifyOtpMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.OtpVerificationRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyOtp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OtpVerificationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OtpServiceMethodDescriptorSupplier("VerifyOtp"))
              .build();
        }
      }
    }
    return getVerifyOtpMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.UserOtpRequest,
      com.common.grpc.OtpResponse> getRequestResetPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestResetPassword",
      requestType = com.common.grpc.UserOtpRequest.class,
      responseType = com.common.grpc.OtpResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.UserOtpRequest,
      com.common.grpc.OtpResponse> getRequestResetPasswordMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.UserOtpRequest, com.common.grpc.OtpResponse> getRequestResetPasswordMethod;
    if ((getRequestResetPasswordMethod = OtpServiceGrpc.getRequestResetPasswordMethod) == null) {
      synchronized (OtpServiceGrpc.class) {
        if ((getRequestResetPasswordMethod = OtpServiceGrpc.getRequestResetPasswordMethod) == null) {
          OtpServiceGrpc.getRequestResetPasswordMethod = getRequestResetPasswordMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.UserOtpRequest, com.common.grpc.OtpResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestResetPassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.UserOtpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OtpResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OtpServiceMethodDescriptorSupplier("RequestResetPassword"))
              .build();
        }
      }
    }
    return getRequestResetPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.OtpVerificationRequest,
      com.google.protobuf.Empty> getVerifyOtpPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyOtpPassword",
      requestType = com.common.grpc.OtpVerificationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.OtpVerificationRequest,
      com.google.protobuf.Empty> getVerifyOtpPasswordMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.OtpVerificationRequest, com.google.protobuf.Empty> getVerifyOtpPasswordMethod;
    if ((getVerifyOtpPasswordMethod = OtpServiceGrpc.getVerifyOtpPasswordMethod) == null) {
      synchronized (OtpServiceGrpc.class) {
        if ((getVerifyOtpPasswordMethod = OtpServiceGrpc.getVerifyOtpPasswordMethod) == null) {
          OtpServiceGrpc.getVerifyOtpPasswordMethod = getVerifyOtpPasswordMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.OtpVerificationRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyOtpPassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OtpVerificationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OtpServiceMethodDescriptorSupplier("VerifyOtpPassword"))
              .build();
        }
      }
    }
    return getVerifyOtpPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.ResetPasswordRequest,
      com.google.protobuf.Empty> getResetPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResetPassword",
      requestType = com.common.grpc.ResetPasswordRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.ResetPasswordRequest,
      com.google.protobuf.Empty> getResetPasswordMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.ResetPasswordRequest, com.google.protobuf.Empty> getResetPasswordMethod;
    if ((getResetPasswordMethod = OtpServiceGrpc.getResetPasswordMethod) == null) {
      synchronized (OtpServiceGrpc.class) {
        if ((getResetPasswordMethod = OtpServiceGrpc.getResetPasswordMethod) == null) {
          OtpServiceGrpc.getResetPasswordMethod = getResetPasswordMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.ResetPasswordRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResetPassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ResetPasswordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OtpServiceMethodDescriptorSupplier("ResetPassword"))
              .build();
        }
      }
    }
    return getResetPasswordMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OtpServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OtpServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OtpServiceStub>() {
        @java.lang.Override
        public OtpServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OtpServiceStub(channel, callOptions);
        }
      };
    return OtpServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static OtpServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OtpServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OtpServiceBlockingV2Stub>() {
        @java.lang.Override
        public OtpServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OtpServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return OtpServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OtpServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OtpServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OtpServiceBlockingStub>() {
        @java.lang.Override
        public OtpServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OtpServiceBlockingStub(channel, callOptions);
        }
      };
    return OtpServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OtpServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OtpServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OtpServiceFutureStub>() {
        @java.lang.Override
        public OtpServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OtpServiceFutureStub(channel, callOptions);
        }
      };
    return OtpServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     * <pre>
     * OTP
     * </pre>
     */
    default void sendOtp(com.common.grpc.UserOtpRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.OtpResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendOtpMethod(), responseObserver);
    }

    /**
     */
    default void verifyOtp(com.common.grpc.OtpVerificationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyOtpMethod(), responseObserver);
    }

    /**
     * <pre>
     * Password
     * </pre>
     */
    default void requestResetPassword(com.common.grpc.UserOtpRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.OtpResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestResetPasswordMethod(), responseObserver);
    }

    /**
     */
    default void verifyOtpPassword(com.common.grpc.OtpVerificationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyOtpPasswordMethod(), responseObserver);
    }

    /**
     */
    default void resetPassword(com.common.grpc.ResetPasswordRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResetPasswordMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OtpService.
   */
  public static abstract class OtpServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OtpServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OtpService.
   */
  public static final class OtpServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OtpServiceStub> {
    private OtpServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OtpServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OtpServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * OTP
     * </pre>
     */
    public void sendOtp(com.common.grpc.UserOtpRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.OtpResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendOtpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verifyOtp(com.common.grpc.OtpVerificationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyOtpMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Password
     * </pre>
     */
    public void requestResetPassword(com.common.grpc.UserOtpRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.OtpResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestResetPasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verifyOtpPassword(com.common.grpc.OtpVerificationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyOtpPasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void resetPassword(com.common.grpc.ResetPasswordRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetPasswordMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OtpService.
   */
  public static final class OtpServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OtpServiceBlockingV2Stub> {
    private OtpServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OtpServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OtpServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * OTP
     * </pre>
     */
    public com.common.grpc.OtpResponse sendOtp(com.common.grpc.UserOtpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendOtpMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty verifyOtp(com.common.grpc.OtpVerificationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyOtpMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Password
     * </pre>
     */
    public com.common.grpc.OtpResponse requestResetPassword(com.common.grpc.UserOtpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestResetPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty verifyOtpPassword(com.common.grpc.OtpVerificationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyOtpPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty resetPassword(com.common.grpc.ResetPasswordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetPasswordMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service OtpService.
   */
  public static final class OtpServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OtpServiceBlockingStub> {
    private OtpServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OtpServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OtpServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * OTP
     * </pre>
     */
    public com.common.grpc.OtpResponse sendOtp(com.common.grpc.UserOtpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendOtpMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty verifyOtp(com.common.grpc.OtpVerificationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyOtpMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Password
     * </pre>
     */
    public com.common.grpc.OtpResponse requestResetPassword(com.common.grpc.UserOtpRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestResetPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty verifyOtpPassword(com.common.grpc.OtpVerificationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyOtpPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty resetPassword(com.common.grpc.ResetPasswordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetPasswordMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OtpService.
   */
  public static final class OtpServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OtpServiceFutureStub> {
    private OtpServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OtpServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OtpServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * OTP
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.OtpResponse> sendOtp(
        com.common.grpc.UserOtpRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendOtpMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> verifyOtp(
        com.common.grpc.OtpVerificationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyOtpMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Password
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.OtpResponse> requestResetPassword(
        com.common.grpc.UserOtpRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestResetPasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> verifyOtpPassword(
        com.common.grpc.OtpVerificationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyOtpPasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> resetPassword(
        com.common.grpc.ResetPasswordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetPasswordMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_OTP = 0;
  private static final int METHODID_VERIFY_OTP = 1;
  private static final int METHODID_REQUEST_RESET_PASSWORD = 2;
  private static final int METHODID_VERIFY_OTP_PASSWORD = 3;
  private static final int METHODID_RESET_PASSWORD = 4;

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
        case METHODID_SEND_OTP:
          serviceImpl.sendOtp((com.common.grpc.UserOtpRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.OtpResponse>) responseObserver);
          break;
        case METHODID_VERIFY_OTP:
          serviceImpl.verifyOtp((com.common.grpc.OtpVerificationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REQUEST_RESET_PASSWORD:
          serviceImpl.requestResetPassword((com.common.grpc.UserOtpRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.OtpResponse>) responseObserver);
          break;
        case METHODID_VERIFY_OTP_PASSWORD:
          serviceImpl.verifyOtpPassword((com.common.grpc.OtpVerificationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RESET_PASSWORD:
          serviceImpl.resetPassword((com.common.grpc.ResetPasswordRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
          getSendOtpMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.UserOtpRequest,
              com.common.grpc.OtpResponse>(
                service, METHODID_SEND_OTP)))
        .addMethod(
          getVerifyOtpMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.OtpVerificationRequest,
              com.google.protobuf.Empty>(
                service, METHODID_VERIFY_OTP)))
        .addMethod(
          getRequestResetPasswordMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.UserOtpRequest,
              com.common.grpc.OtpResponse>(
                service, METHODID_REQUEST_RESET_PASSWORD)))
        .addMethod(
          getVerifyOtpPasswordMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.OtpVerificationRequest,
              com.google.protobuf.Empty>(
                service, METHODID_VERIFY_OTP_PASSWORD)))
        .addMethod(
          getResetPasswordMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.ResetPasswordRequest,
              com.google.protobuf.Empty>(
                service, METHODID_RESET_PASSWORD)))
        .build();
  }

  private static abstract class OtpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OtpServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.OtpProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OtpService");
    }
  }

  private static final class OtpServiceFileDescriptorSupplier
      extends OtpServiceBaseDescriptorSupplier {
    OtpServiceFileDescriptorSupplier() {}
  }

  private static final class OtpServiceMethodDescriptorSupplier
      extends OtpServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OtpServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OtpServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OtpServiceFileDescriptorSupplier())
              .addMethod(getSendOtpMethod())
              .addMethod(getVerifyOtpMethod())
              .addMethod(getRequestResetPasswordMethod())
              .addMethod(getVerifyOtpPasswordMethod())
              .addMethod(getResetPasswordMethod())
              .build();
        }
      }
    }
    return result;
  }
}
