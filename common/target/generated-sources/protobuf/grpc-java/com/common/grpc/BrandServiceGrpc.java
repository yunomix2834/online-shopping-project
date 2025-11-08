package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: business/brand.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BrandServiceGrpc {

  private BrandServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "onlineshopping.v1.BrandService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.BrandCreateRequest,
      com.google.protobuf.Empty> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = com.common.grpc.BrandCreateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.BrandCreateRequest,
      com.google.protobuf.Empty> getCreateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.BrandCreateRequest, com.google.protobuf.Empty> getCreateMethod;
    if ((getCreateMethod = BrandServiceGrpc.getCreateMethod) == null) {
      synchronized (BrandServiceGrpc.class) {
        if ((getCreateMethod = BrandServiceGrpc.getCreateMethod) == null) {
          BrandServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.BrandCreateRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.BrandCreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BrandServiceMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.BrandUpdateRequest,
      com.google.protobuf.Empty> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.common.grpc.BrandUpdateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.BrandUpdateRequest,
      com.google.protobuf.Empty> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.BrandUpdateRequest, com.google.protobuf.Empty> getUpdateMethod;
    if ((getUpdateMethod = BrandServiceGrpc.getUpdateMethod) == null) {
      synchronized (BrandServiceGrpc.class) {
        if ((getUpdateMethod = BrandServiceGrpc.getUpdateMethod) == null) {
          BrandServiceGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.BrandUpdateRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.BrandUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BrandServiceMethodDescriptorSupplier("Update"))
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
    if ((getSoftDeleteMethod = BrandServiceGrpc.getSoftDeleteMethod) == null) {
      synchronized (BrandServiceGrpc.class) {
        if ((getSoftDeleteMethod = BrandServiceGrpc.getSoftDeleteMethod) == null) {
          BrandServiceGrpc.getSoftDeleteMethod = getSoftDeleteMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SoftDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BrandServiceMethodDescriptorSupplier("SoftDelete"))
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
    if ((getRestoreMethod = BrandServiceGrpc.getRestoreMethod) == null) {
      synchronized (BrandServiceGrpc.class) {
        if ((getRestoreMethod = BrandServiceGrpc.getRestoreMethod) == null) {
          BrandServiceGrpc.getRestoreMethod = getRestoreMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Restore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new BrandServiceMethodDescriptorSupplier("Restore"))
              .build();
        }
      }
    }
    return getRestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.IdRequest,
      com.common.grpc.BrandView> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = com.common.grpc.IdRequest.class,
      responseType = com.common.grpc.BrandView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.IdRequest,
      com.common.grpc.BrandView> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.IdRequest, com.common.grpc.BrandView> getGetByIdMethod;
    if ((getGetByIdMethod = BrandServiceGrpc.getGetByIdMethod) == null) {
      synchronized (BrandServiceGrpc.class) {
        if ((getGetByIdMethod = BrandServiceGrpc.getGetByIdMethod) == null) {
          BrandServiceGrpc.getGetByIdMethod = getGetByIdMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.common.grpc.BrandView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.BrandView.getDefaultInstance()))
              .setSchemaDescriptor(new BrandServiceMethodDescriptorSupplier("GetById"))
              .build();
        }
      }
    }
    return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.SlugRequest,
      com.common.grpc.BrandView> getGetBySlugMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBySlug",
      requestType = com.common.grpc.SlugRequest.class,
      responseType = com.common.grpc.BrandView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.SlugRequest,
      com.common.grpc.BrandView> getGetBySlugMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.SlugRequest, com.common.grpc.BrandView> getGetBySlugMethod;
    if ((getGetBySlugMethod = BrandServiceGrpc.getGetBySlugMethod) == null) {
      synchronized (BrandServiceGrpc.class) {
        if ((getGetBySlugMethod = BrandServiceGrpc.getGetBySlugMethod) == null) {
          BrandServiceGrpc.getGetBySlugMethod = getGetBySlugMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.SlugRequest, com.common.grpc.BrandView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBySlug"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.SlugRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.BrandView.getDefaultInstance()))
              .setSchemaDescriptor(new BrandServiceMethodDescriptorSupplier("GetBySlug"))
              .build();
        }
      }
    }
    return getGetBySlugMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.BrandListRequest,
      com.common.grpc.PageBrand> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.common.grpc.BrandListRequest.class,
      responseType = com.common.grpc.PageBrand.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.BrandListRequest,
      com.common.grpc.PageBrand> getListMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.BrandListRequest, com.common.grpc.PageBrand> getListMethod;
    if ((getListMethod = BrandServiceGrpc.getListMethod) == null) {
      synchronized (BrandServiceGrpc.class) {
        if ((getListMethod = BrandServiceGrpc.getListMethod) == null) {
          BrandServiceGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.BrandListRequest, com.common.grpc.PageBrand>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.BrandListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageBrand.getDefaultInstance()))
              .setSchemaDescriptor(new BrandServiceMethodDescriptorSupplier("List"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BrandServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BrandServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BrandServiceStub>() {
        @java.lang.Override
        public BrandServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BrandServiceStub(channel, callOptions);
        }
      };
    return BrandServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static BrandServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BrandServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BrandServiceBlockingV2Stub>() {
        @java.lang.Override
        public BrandServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BrandServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return BrandServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BrandServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BrandServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BrandServiceBlockingStub>() {
        @java.lang.Override
        public BrandServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BrandServiceBlockingStub(channel, callOptions);
        }
      };
    return BrandServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BrandServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BrandServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BrandServiceFutureStub>() {
        @java.lang.Override
        public BrandServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BrandServiceFutureStub(channel, callOptions);
        }
      };
    return BrandServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void create(com.common.grpc.BrandCreateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     */
    default void update(com.common.grpc.BrandUpdateRequest request,
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
    default void getById(com.common.grpc.IdRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.BrandView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    default void getBySlug(com.common.grpc.SlugRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.BrandView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBySlugMethod(), responseObserver);
    }

    /**
     */
    default void list(com.common.grpc.BrandListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageBrand> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BrandService.
   */
  public static abstract class BrandServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return BrandServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BrandService.
   */
  public static final class BrandServiceStub
      extends io.grpc.stub.AbstractAsyncStub<BrandServiceStub> {
    private BrandServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrandServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BrandServiceStub(channel, callOptions);
    }

    /**
     */
    public void create(com.common.grpc.BrandCreateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.common.grpc.BrandUpdateRequest request,
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
    public void getById(com.common.grpc.IdRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.BrandView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBySlug(com.common.grpc.SlugRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.BrandView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBySlugMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void list(com.common.grpc.BrandListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageBrand> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BrandService.
   */
  public static final class BrandServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<BrandServiceBlockingV2Stub> {
    private BrandServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrandServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BrandServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty create(com.common.grpc.BrandCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty update(com.common.grpc.BrandUpdateRequest request) {
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
    public com.common.grpc.BrandView getById(com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.BrandView getBySlug(com.common.grpc.SlugRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBySlugMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageBrand list(com.common.grpc.BrandListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service BrandService.
   */
  public static final class BrandServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BrandServiceBlockingStub> {
    private BrandServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrandServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BrandServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty create(com.common.grpc.BrandCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty update(com.common.grpc.BrandUpdateRequest request) {
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
    public com.common.grpc.BrandView getById(com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.BrandView getBySlug(com.common.grpc.SlugRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBySlugMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageBrand list(com.common.grpc.BrandListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BrandService.
   */
  public static final class BrandServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<BrandServiceFutureStub> {
    private BrandServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrandServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BrandServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> create(
        com.common.grpc.BrandCreateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> update(
        com.common.grpc.BrandUpdateRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.BrandView> getById(
        com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.BrandView> getBySlug(
        com.common.grpc.SlugRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBySlugMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.PageBrand> list(
        com.common.grpc.BrandListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_UPDATE = 1;
  private static final int METHODID_SOFT_DELETE = 2;
  private static final int METHODID_RESTORE = 3;
  private static final int METHODID_GET_BY_ID = 4;
  private static final int METHODID_GET_BY_SLUG = 5;
  private static final int METHODID_LIST = 6;

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
          serviceImpl.create((com.common.grpc.BrandCreateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.common.grpc.BrandUpdateRequest) request,
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
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.common.grpc.IdRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.BrandView>) responseObserver);
          break;
        case METHODID_GET_BY_SLUG:
          serviceImpl.getBySlug((com.common.grpc.SlugRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.BrandView>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list((com.common.grpc.BrandListRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.PageBrand>) responseObserver);
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
              com.common.grpc.BrandCreateRequest,
              com.google.protobuf.Empty>(
                service, METHODID_CREATE)))
        .addMethod(
          getUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.BrandUpdateRequest,
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
          getGetByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.IdRequest,
              com.common.grpc.BrandView>(
                service, METHODID_GET_BY_ID)))
        .addMethod(
          getGetBySlugMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.SlugRequest,
              com.common.grpc.BrandView>(
                service, METHODID_GET_BY_SLUG)))
        .addMethod(
          getListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.BrandListRequest,
              com.common.grpc.PageBrand>(
                service, METHODID_LIST)))
        .build();
  }

  private static abstract class BrandServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BrandServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.BrandProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BrandService");
    }
  }

  private static final class BrandServiceFileDescriptorSupplier
      extends BrandServiceBaseDescriptorSupplier {
    BrandServiceFileDescriptorSupplier() {}
  }

  private static final class BrandServiceMethodDescriptorSupplier
      extends BrandServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BrandServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BrandServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BrandServiceFileDescriptorSupplier())
              .addMethod(getCreateMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getSoftDeleteMethod())
              .addMethod(getRestoreMethod())
              .addMethod(getGetByIdMethod())
              .addMethod(getGetBySlugMethod())
              .addMethod(getListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
