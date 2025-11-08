package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: business/discount.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DiscountServiceGrpc {

  private DiscountServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "onlineshopping.v1.DiscountService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.DiscountCreateRequest,
      com.google.protobuf.Empty> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = com.common.grpc.DiscountCreateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.DiscountCreateRequest,
      com.google.protobuf.Empty> getCreateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.DiscountCreateRequest, com.google.protobuf.Empty> getCreateMethod;
    if ((getCreateMethod = DiscountServiceGrpc.getCreateMethod) == null) {
      synchronized (DiscountServiceGrpc.class) {
        if ((getCreateMethod = DiscountServiceGrpc.getCreateMethod) == null) {
          DiscountServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.DiscountCreateRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DiscountCreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new DiscountServiceMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.DiscountUpdateRequest,
      com.google.protobuf.Empty> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.common.grpc.DiscountUpdateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.DiscountUpdateRequest,
      com.google.protobuf.Empty> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.DiscountUpdateRequest, com.google.protobuf.Empty> getUpdateMethod;
    if ((getUpdateMethod = DiscountServiceGrpc.getUpdateMethod) == null) {
      synchronized (DiscountServiceGrpc.class) {
        if ((getUpdateMethod = DiscountServiceGrpc.getUpdateMethod) == null) {
          DiscountServiceGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.DiscountUpdateRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DiscountUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new DiscountServiceMethodDescriptorSupplier("Update"))
              .build();
        }
      }
    }
    return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.IdRequest,
      com.google.protobuf.Empty> getSoftDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SoftDelete",
      requestType = com.common.grpc.IdRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.IdRequest,
      com.google.protobuf.Empty> getSoftDeleteMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.IdRequest, com.google.protobuf.Empty> getSoftDeleteMethod;
    if ((getSoftDeleteMethod = DiscountServiceGrpc.getSoftDeleteMethod) == null) {
      synchronized (DiscountServiceGrpc.class) {
        if ((getSoftDeleteMethod = DiscountServiceGrpc.getSoftDeleteMethod) == null) {
          DiscountServiceGrpc.getSoftDeleteMethod = getSoftDeleteMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SoftDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new DiscountServiceMethodDescriptorSupplier("SoftDelete"))
              .build();
        }
      }
    }
    return getSoftDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.IdRequest,
      com.google.protobuf.Empty> getRestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Restore",
      requestType = com.common.grpc.IdRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.IdRequest,
      com.google.protobuf.Empty> getRestoreMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.IdRequest, com.google.protobuf.Empty> getRestoreMethod;
    if ((getRestoreMethod = DiscountServiceGrpc.getRestoreMethod) == null) {
      synchronized (DiscountServiceGrpc.class) {
        if ((getRestoreMethod = DiscountServiceGrpc.getRestoreMethod) == null) {
          DiscountServiceGrpc.getRestoreMethod = getRestoreMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Restore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new DiscountServiceMethodDescriptorSupplier("Restore"))
              .build();
        }
      }
    }
    return getRestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.DiscountToggleActiveRequest,
      com.google.protobuf.Empty> getToggleActiveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ToggleActive",
      requestType = com.common.grpc.DiscountToggleActiveRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.DiscountToggleActiveRequest,
      com.google.protobuf.Empty> getToggleActiveMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.DiscountToggleActiveRequest, com.google.protobuf.Empty> getToggleActiveMethod;
    if ((getToggleActiveMethod = DiscountServiceGrpc.getToggleActiveMethod) == null) {
      synchronized (DiscountServiceGrpc.class) {
        if ((getToggleActiveMethod = DiscountServiceGrpc.getToggleActiveMethod) == null) {
          DiscountServiceGrpc.getToggleActiveMethod = getToggleActiveMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.DiscountToggleActiveRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ToggleActive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DiscountToggleActiveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new DiscountServiceMethodDescriptorSupplier("ToggleActive"))
              .build();
        }
      }
    }
    return getToggleActiveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.DiscountCodeRequest,
      com.common.grpc.DiscountView> getGetByCodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetByCode",
      requestType = com.common.grpc.DiscountCodeRequest.class,
      responseType = com.common.grpc.DiscountView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.DiscountCodeRequest,
      com.common.grpc.DiscountView> getGetByCodeMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.DiscountCodeRequest, com.common.grpc.DiscountView> getGetByCodeMethod;
    if ((getGetByCodeMethod = DiscountServiceGrpc.getGetByCodeMethod) == null) {
      synchronized (DiscountServiceGrpc.class) {
        if ((getGetByCodeMethod = DiscountServiceGrpc.getGetByCodeMethod) == null) {
          DiscountServiceGrpc.getGetByCodeMethod = getGetByCodeMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.DiscountCodeRequest, com.common.grpc.DiscountView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetByCode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DiscountCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DiscountView.getDefaultInstance()))
              .setSchemaDescriptor(new DiscountServiceMethodDescriptorSupplier("GetByCode"))
              .build();
        }
      }
    }
    return getGetByCodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.DiscountCodeRequest,
      com.common.grpc.DiscountValidationView> getValidateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Validate",
      requestType = com.common.grpc.DiscountCodeRequest.class,
      responseType = com.common.grpc.DiscountValidationView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.DiscountCodeRequest,
      com.common.grpc.DiscountValidationView> getValidateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.DiscountCodeRequest, com.common.grpc.DiscountValidationView> getValidateMethod;
    if ((getValidateMethod = DiscountServiceGrpc.getValidateMethod) == null) {
      synchronized (DiscountServiceGrpc.class) {
        if ((getValidateMethod = DiscountServiceGrpc.getValidateMethod) == null) {
          DiscountServiceGrpc.getValidateMethod = getValidateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.DiscountCodeRequest, com.common.grpc.DiscountValidationView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Validate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DiscountCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DiscountValidationView.getDefaultInstance()))
              .setSchemaDescriptor(new DiscountServiceMethodDescriptorSupplier("Validate"))
              .build();
        }
      }
    }
    return getValidateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.DiscountListRequest,
      com.common.grpc.PageDiscount> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.common.grpc.DiscountListRequest.class,
      responseType = com.common.grpc.PageDiscount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.DiscountListRequest,
      com.common.grpc.PageDiscount> getListMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.DiscountListRequest, com.common.grpc.PageDiscount> getListMethod;
    if ((getListMethod = DiscountServiceGrpc.getListMethod) == null) {
      synchronized (DiscountServiceGrpc.class) {
        if ((getListMethod = DiscountServiceGrpc.getListMethod) == null) {
          DiscountServiceGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.DiscountListRequest, com.common.grpc.PageDiscount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DiscountListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageDiscount.getDefaultInstance()))
              .setSchemaDescriptor(new DiscountServiceMethodDescriptorSupplier("List"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DiscountServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DiscountServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DiscountServiceStub>() {
        @java.lang.Override
        public DiscountServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DiscountServiceStub(channel, callOptions);
        }
      };
    return DiscountServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static DiscountServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DiscountServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DiscountServiceBlockingV2Stub>() {
        @java.lang.Override
        public DiscountServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DiscountServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return DiscountServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DiscountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DiscountServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DiscountServiceBlockingStub>() {
        @java.lang.Override
        public DiscountServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DiscountServiceBlockingStub(channel, callOptions);
        }
      };
    return DiscountServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DiscountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DiscountServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DiscountServiceFutureStub>() {
        @java.lang.Override
        public DiscountServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DiscountServiceFutureStub(channel, callOptions);
        }
      };
    return DiscountServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void create(com.common.grpc.DiscountCreateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     */
    default void update(com.common.grpc.DiscountUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    default void softDelete(com.common.grpc.IdRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSoftDeleteMethod(), responseObserver);
    }

    /**
     */
    default void restore(com.common.grpc.IdRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestoreMethod(), responseObserver);
    }

    /**
     */
    default void toggleActive(com.common.grpc.DiscountToggleActiveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getToggleActiveMethod(), responseObserver);
    }

    /**
     */
    default void getByCode(com.common.grpc.DiscountCodeRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.DiscountView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByCodeMethod(), responseObserver);
    }

    /**
     */
    default void validate(com.common.grpc.DiscountCodeRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.DiscountValidationView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateMethod(), responseObserver);
    }

    /**
     */
    default void list(com.common.grpc.DiscountListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageDiscount> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DiscountService.
   */
  public static abstract class DiscountServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return DiscountServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DiscountService.
   */
  public static final class DiscountServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DiscountServiceStub> {
    private DiscountServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiscountServiceStub(channel, callOptions);
    }

    /**
     */
    public void create(com.common.grpc.DiscountCreateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.common.grpc.DiscountUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void softDelete(com.common.grpc.IdRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSoftDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void restore(com.common.grpc.IdRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void toggleActive(com.common.grpc.DiscountToggleActiveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getToggleActiveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getByCode(com.common.grpc.DiscountCodeRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.DiscountView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByCodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validate(com.common.grpc.DiscountCodeRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.DiscountValidationView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void list(com.common.grpc.DiscountListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageDiscount> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DiscountService.
   */
  public static final class DiscountServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<DiscountServiceBlockingV2Stub> {
    private DiscountServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiscountServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty create(com.common.grpc.DiscountCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty update(com.common.grpc.DiscountUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty softDelete(com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSoftDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty restore(com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty toggleActive(com.common.grpc.DiscountToggleActiveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getToggleActiveMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.DiscountView getByCode(com.common.grpc.DiscountCodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByCodeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.DiscountValidationView validate(com.common.grpc.DiscountCodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageDiscount list(com.common.grpc.DiscountListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service DiscountService.
   */
  public static final class DiscountServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DiscountServiceBlockingStub> {
    private DiscountServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiscountServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty create(com.common.grpc.DiscountCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty update(com.common.grpc.DiscountUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty softDelete(com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSoftDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty restore(com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty toggleActive(com.common.grpc.DiscountToggleActiveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getToggleActiveMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.DiscountView getByCode(com.common.grpc.DiscountCodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByCodeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.DiscountValidationView validate(com.common.grpc.DiscountCodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageDiscount list(com.common.grpc.DiscountListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DiscountService.
   */
  public static final class DiscountServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DiscountServiceFutureStub> {
    private DiscountServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DiscountServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> create(
        com.common.grpc.DiscountCreateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> update(
        com.common.grpc.DiscountUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> softDelete(
        com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSoftDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> restore(
        com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> toggleActive(
        com.common.grpc.DiscountToggleActiveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getToggleActiveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.DiscountView> getByCode(
        com.common.grpc.DiscountCodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByCodeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.DiscountValidationView> validate(
        com.common.grpc.DiscountCodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.PageDiscount> list(
        com.common.grpc.DiscountListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_UPDATE = 1;
  private static final int METHODID_SOFT_DELETE = 2;
  private static final int METHODID_RESTORE = 3;
  private static final int METHODID_TOGGLE_ACTIVE = 4;
  private static final int METHODID_GET_BY_CODE = 5;
  private static final int METHODID_VALIDATE = 6;
  private static final int METHODID_LIST = 7;

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
        case METHODID_CREATE:
          serviceImpl.create((com.common.grpc.DiscountCreateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.common.grpc.DiscountUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SOFT_DELETE:
          serviceImpl.softDelete((com.common.grpc.IdRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RESTORE:
          serviceImpl.restore((com.common.grpc.IdRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_TOGGLE_ACTIVE:
          serviceImpl.toggleActive((com.common.grpc.DiscountToggleActiveRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_BY_CODE:
          serviceImpl.getByCode((com.common.grpc.DiscountCodeRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.DiscountView>) responseObserver);
          break;
        case METHODID_VALIDATE:
          serviceImpl.validate((com.common.grpc.DiscountCodeRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.DiscountValidationView>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list((com.common.grpc.DiscountListRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.PageDiscount>) responseObserver);
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
          getCreateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.DiscountCreateRequest,
              com.google.protobuf.Empty>(
                service, METHODID_CREATE)))
        .addMethod(
          getUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.DiscountUpdateRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UPDATE)))
        .addMethod(
          getSoftDeleteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.IdRequest,
              com.google.protobuf.Empty>(
                service, METHODID_SOFT_DELETE)))
        .addMethod(
          getRestoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.IdRequest,
              com.google.protobuf.Empty>(
                service, METHODID_RESTORE)))
        .addMethod(
          getToggleActiveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.DiscountToggleActiveRequest,
              com.google.protobuf.Empty>(
                service, METHODID_TOGGLE_ACTIVE)))
        .addMethod(
          getGetByCodeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.DiscountCodeRequest,
              com.common.grpc.DiscountView>(
                service, METHODID_GET_BY_CODE)))
        .addMethod(
          getValidateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.DiscountCodeRequest,
              com.common.grpc.DiscountValidationView>(
                service, METHODID_VALIDATE)))
        .addMethod(
          getListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.DiscountListRequest,
              com.common.grpc.PageDiscount>(
                service, METHODID_LIST)))
        .build();
  }

  private static abstract class DiscountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DiscountServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.DiscountProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DiscountService");
    }
  }

  private static final class DiscountServiceFileDescriptorSupplier
      extends DiscountServiceBaseDescriptorSupplier {
    DiscountServiceFileDescriptorSupplier() {}
  }

  private static final class DiscountServiceMethodDescriptorSupplier
      extends DiscountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DiscountServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DiscountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DiscountServiceFileDescriptorSupplier())
              .addMethod(getCreateMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getSoftDeleteMethod())
              .addMethod(getRestoreMethod())
              .addMethod(getToggleActiveMethod())
              .addMethod(getGetByCodeMethod())
              .addMethod(getValidateMethod())
              .addMethod(getListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
