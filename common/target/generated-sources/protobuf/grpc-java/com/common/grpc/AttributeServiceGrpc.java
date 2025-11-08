package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: business/attribute.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AttributeServiceGrpc {

  private AttributeServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "onlineshopping.v1.AttributeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.AttributeCreateRequest,
      com.google.protobuf.Empty> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = com.common.grpc.AttributeCreateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.AttributeCreateRequest,
      com.google.protobuf.Empty> getCreateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.AttributeCreateRequest, com.google.protobuf.Empty> getCreateMethod;
    if ((getCreateMethod = AttributeServiceGrpc.getCreateMethod) == null) {
      synchronized (AttributeServiceGrpc.class) {
        if ((getCreateMethod = AttributeServiceGrpc.getCreateMethod) == null) {
          AttributeServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.AttributeCreateRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.AttributeCreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AttributeServiceMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
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
    if ((getSoftDeleteMethod = AttributeServiceGrpc.getSoftDeleteMethod) == null) {
      synchronized (AttributeServiceGrpc.class) {
        if ((getSoftDeleteMethod = AttributeServiceGrpc.getSoftDeleteMethod) == null) {
          AttributeServiceGrpc.getSoftDeleteMethod = getSoftDeleteMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SoftDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AttributeServiceMethodDescriptorSupplier("SoftDelete"))
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
    if ((getRestoreMethod = AttributeServiceGrpc.getRestoreMethod) == null) {
      synchronized (AttributeServiceGrpc.class) {
        if ((getRestoreMethod = AttributeServiceGrpc.getRestoreMethod) == null) {
          AttributeServiceGrpc.getRestoreMethod = getRestoreMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Restore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AttributeServiceMethodDescriptorSupplier("Restore"))
              .build();
        }
      }
    }
    return getRestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.AttributeListRequest,
      com.common.grpc.PageAttribute> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.common.grpc.AttributeListRequest.class,
      responseType = com.common.grpc.PageAttribute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.AttributeListRequest,
      com.common.grpc.PageAttribute> getListMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.AttributeListRequest, com.common.grpc.PageAttribute> getListMethod;
    if ((getListMethod = AttributeServiceGrpc.getListMethod) == null) {
      synchronized (AttributeServiceGrpc.class) {
        if ((getListMethod = AttributeServiceGrpc.getListMethod) == null) {
          AttributeServiceGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.AttributeListRequest, com.common.grpc.PageAttribute>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.AttributeListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageAttribute.getDefaultInstance()))
              .setSchemaDescriptor(new AttributeServiceMethodDescriptorSupplier("List"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.VariantAttributeAssignRequest,
      com.google.protobuf.Empty> getAssignToVariantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AssignToVariant",
      requestType = com.common.grpc.VariantAttributeAssignRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.VariantAttributeAssignRequest,
      com.google.protobuf.Empty> getAssignToVariantMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.VariantAttributeAssignRequest, com.google.protobuf.Empty> getAssignToVariantMethod;
    if ((getAssignToVariantMethod = AttributeServiceGrpc.getAssignToVariantMethod) == null) {
      synchronized (AttributeServiceGrpc.class) {
        if ((getAssignToVariantMethod = AttributeServiceGrpc.getAssignToVariantMethod) == null) {
          AttributeServiceGrpc.getAssignToVariantMethod = getAssignToVariantMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.VariantAttributeAssignRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AssignToVariant"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.VariantAttributeAssignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AttributeServiceMethodDescriptorSupplier("AssignToVariant"))
              .build();
        }
      }
    }
    return getAssignToVariantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.VariantAttributeAssignRequest,
      com.google.protobuf.Empty> getUnassignFromVariantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnassignFromVariant",
      requestType = com.common.grpc.VariantAttributeAssignRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.VariantAttributeAssignRequest,
      com.google.protobuf.Empty> getUnassignFromVariantMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.VariantAttributeAssignRequest, com.google.protobuf.Empty> getUnassignFromVariantMethod;
    if ((getUnassignFromVariantMethod = AttributeServiceGrpc.getUnassignFromVariantMethod) == null) {
      synchronized (AttributeServiceGrpc.class) {
        if ((getUnassignFromVariantMethod = AttributeServiceGrpc.getUnassignFromVariantMethod) == null) {
          AttributeServiceGrpc.getUnassignFromVariantMethod = getUnassignFromVariantMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.VariantAttributeAssignRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnassignFromVariant"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.VariantAttributeAssignRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new AttributeServiceMethodDescriptorSupplier("UnassignFromVariant"))
              .build();
        }
      }
    }
    return getUnassignFromVariantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.VariantIdRequest,
      com.common.grpc.PageAttribute> getListByVariantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListByVariant",
      requestType = com.common.grpc.VariantIdRequest.class,
      responseType = com.common.grpc.PageAttribute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.VariantIdRequest,
      com.common.grpc.PageAttribute> getListByVariantMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.VariantIdRequest, com.common.grpc.PageAttribute> getListByVariantMethod;
    if ((getListByVariantMethod = AttributeServiceGrpc.getListByVariantMethod) == null) {
      synchronized (AttributeServiceGrpc.class) {
        if ((getListByVariantMethod = AttributeServiceGrpc.getListByVariantMethod) == null) {
          AttributeServiceGrpc.getListByVariantMethod = getListByVariantMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.VariantIdRequest, com.common.grpc.PageAttribute>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListByVariant"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.VariantIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageAttribute.getDefaultInstance()))
              .setSchemaDescriptor(new AttributeServiceMethodDescriptorSupplier("ListByVariant"))
              .build();
        }
      }
    }
    return getListByVariantMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AttributeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttributeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AttributeServiceStub>() {
        @java.lang.Override
        public AttributeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AttributeServiceStub(channel, callOptions);
        }
      };
    return AttributeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static AttributeServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttributeServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AttributeServiceBlockingV2Stub>() {
        @java.lang.Override
        public AttributeServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AttributeServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return AttributeServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AttributeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttributeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AttributeServiceBlockingStub>() {
        @java.lang.Override
        public AttributeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AttributeServiceBlockingStub(channel, callOptions);
        }
      };
    return AttributeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AttributeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttributeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AttributeServiceFutureStub>() {
        @java.lang.Override
        public AttributeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AttributeServiceFutureStub(channel, callOptions);
        }
      };
    return AttributeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void create(com.common.grpc.AttributeCreateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
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
    default void list(com.common.grpc.AttributeListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageAttribute> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     */
    default void assignToVariant(com.common.grpc.VariantAttributeAssignRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAssignToVariantMethod(), responseObserver);
    }

    /**
     */
    default void unassignFromVariant(com.common.grpc.VariantAttributeAssignRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnassignFromVariantMethod(), responseObserver);
    }

    /**
     */
    default void listByVariant(com.common.grpc.VariantIdRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageAttribute> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListByVariantMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AttributeService.
   */
  public static abstract class AttributeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AttributeServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AttributeService.
   */
  public static final class AttributeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AttributeServiceStub> {
    private AttributeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttributeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttributeServiceStub(channel, callOptions);
    }

    /**
     */
    public void create(com.common.grpc.AttributeCreateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
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
    public void list(com.common.grpc.AttributeListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageAttribute> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void assignToVariant(com.common.grpc.VariantAttributeAssignRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAssignToVariantMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unassignFromVariant(com.common.grpc.VariantAttributeAssignRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnassignFromVariantMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listByVariant(com.common.grpc.VariantIdRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageAttribute> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListByVariantMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AttributeService.
   */
  public static final class AttributeServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AttributeServiceBlockingV2Stub> {
    private AttributeServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttributeServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttributeServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty create(com.common.grpc.AttributeCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
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
    public com.common.grpc.PageAttribute list(com.common.grpc.AttributeListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty assignToVariant(com.common.grpc.VariantAttributeAssignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignToVariantMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty unassignFromVariant(com.common.grpc.VariantAttributeAssignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnassignFromVariantMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageAttribute listByVariant(com.common.grpc.VariantIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListByVariantMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AttributeService.
   */
  public static final class AttributeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AttributeServiceBlockingStub> {
    private AttributeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttributeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttributeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty create(com.common.grpc.AttributeCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
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
    public com.common.grpc.PageAttribute list(com.common.grpc.AttributeListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty assignToVariant(com.common.grpc.VariantAttributeAssignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignToVariantMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty unassignFromVariant(com.common.grpc.VariantAttributeAssignRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnassignFromVariantMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageAttribute listByVariant(com.common.grpc.VariantIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListByVariantMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AttributeService.
   */
  public static final class AttributeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AttributeServiceFutureStub> {
    private AttributeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttributeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttributeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> create(
        com.common.grpc.AttributeCreateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.PageAttribute> list(
        com.common.grpc.AttributeListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> assignToVariant(
        com.common.grpc.VariantAttributeAssignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAssignToVariantMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> unassignFromVariant(
        com.common.grpc.VariantAttributeAssignRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnassignFromVariantMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.PageAttribute> listByVariant(
        com.common.grpc.VariantIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListByVariantMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_SOFT_DELETE = 1;
  private static final int METHODID_RESTORE = 2;
  private static final int METHODID_LIST = 3;
  private static final int METHODID_ASSIGN_TO_VARIANT = 4;
  private static final int METHODID_UNASSIGN_FROM_VARIANT = 5;
  private static final int METHODID_LIST_BY_VARIANT = 6;

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
          serviceImpl.create((com.common.grpc.AttributeCreateRequest) request,
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
        case METHODID_LIST:
          serviceImpl.list((com.common.grpc.AttributeListRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.PageAttribute>) responseObserver);
          break;
        case METHODID_ASSIGN_TO_VARIANT:
          serviceImpl.assignToVariant((com.common.grpc.VariantAttributeAssignRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UNASSIGN_FROM_VARIANT:
          serviceImpl.unassignFromVariant((com.common.grpc.VariantAttributeAssignRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_BY_VARIANT:
          serviceImpl.listByVariant((com.common.grpc.VariantIdRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.PageAttribute>) responseObserver);
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
              com.common.grpc.AttributeCreateRequest,
              com.google.protobuf.Empty>(
                service, METHODID_CREATE)))
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
          getListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.AttributeListRequest,
              com.common.grpc.PageAttribute>(
                service, METHODID_LIST)))
        .addMethod(
          getAssignToVariantMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.VariantAttributeAssignRequest,
              com.google.protobuf.Empty>(
                service, METHODID_ASSIGN_TO_VARIANT)))
        .addMethod(
          getUnassignFromVariantMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.VariantAttributeAssignRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UNASSIGN_FROM_VARIANT)))
        .addMethod(
          getListByVariantMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.VariantIdRequest,
              com.common.grpc.PageAttribute>(
                service, METHODID_LIST_BY_VARIANT)))
        .build();
  }

  private static abstract class AttributeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AttributeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.AttributeProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AttributeService");
    }
  }

  private static final class AttributeServiceFileDescriptorSupplier
      extends AttributeServiceBaseDescriptorSupplier {
    AttributeServiceFileDescriptorSupplier() {}
  }

  private static final class AttributeServiceMethodDescriptorSupplier
      extends AttributeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AttributeServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AttributeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AttributeServiceFileDescriptorSupplier())
              .addMethod(getCreateMethod())
              .addMethod(getSoftDeleteMethod())
              .addMethod(getRestoreMethod())
              .addMethod(getListMethod())
              .addMethod(getAssignToVariantMethod())
              .addMethod(getUnassignFromVariantMethod())
              .addMethod(getListByVariantMethod())
              .build();
        }
      }
    }
    return result;
  }
}
