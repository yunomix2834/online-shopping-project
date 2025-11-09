package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: business/cart.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CartServiceGrpc {

  private CartServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "onlineshopping.v1.CartService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CartGetOrCreateRequest,
      com.common.grpc.CartView> getGetOrCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrCreate",
      requestType = com.common.grpc.CartGetOrCreateRequest.class,
      responseType = com.common.grpc.CartView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CartGetOrCreateRequest,
      com.common.grpc.CartView> getGetOrCreateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CartGetOrCreateRequest, com.common.grpc.CartView> getGetOrCreateMethod;
    if ((getGetOrCreateMethod = CartServiceGrpc.getGetOrCreateMethod) == null) {
      synchronized (CartServiceGrpc.class) {
        if ((getGetOrCreateMethod = CartServiceGrpc.getGetOrCreateMethod) == null) {
          CartServiceGrpc.getGetOrCreateMethod = getGetOrCreateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CartGetOrCreateRequest, com.common.grpc.CartView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOrCreate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CartGetOrCreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CartView.getDefaultInstance()))
              .setSchemaDescriptor(new CartServiceMethodDescriptorSupplier("GetOrCreate"))
              .build();
        }
      }
    }
    return getGetOrCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CartAddItemRequest,
      com.google.protobuf.Empty> getAddItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddItem",
      requestType = com.common.grpc.CartAddItemRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CartAddItemRequest,
      com.google.protobuf.Empty> getAddItemMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CartAddItemRequest, com.google.protobuf.Empty> getAddItemMethod;
    if ((getAddItemMethod = CartServiceGrpc.getAddItemMethod) == null) {
      synchronized (CartServiceGrpc.class) {
        if ((getAddItemMethod = CartServiceGrpc.getAddItemMethod) == null) {
          CartServiceGrpc.getAddItemMethod = getAddItemMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CartAddItemRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddItem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CartAddItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CartServiceMethodDescriptorSupplier("AddItem"))
              .build();
        }
      }
    }
    return getAddItemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CartUpdateQtyRequest,
      com.google.protobuf.Empty> getUpdateQtyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateQty",
      requestType = com.common.grpc.CartUpdateQtyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CartUpdateQtyRequest,
      com.google.protobuf.Empty> getUpdateQtyMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CartUpdateQtyRequest, com.google.protobuf.Empty> getUpdateQtyMethod;
    if ((getUpdateQtyMethod = CartServiceGrpc.getUpdateQtyMethod) == null) {
      synchronized (CartServiceGrpc.class) {
        if ((getUpdateQtyMethod = CartServiceGrpc.getUpdateQtyMethod) == null) {
          CartServiceGrpc.getUpdateQtyMethod = getUpdateQtyMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CartUpdateQtyRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateQty"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CartUpdateQtyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CartServiceMethodDescriptorSupplier("UpdateQty"))
              .build();
        }
      }
    }
    return getUpdateQtyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CartRemoveItemRequest,
      com.google.protobuf.Empty> getRemoveItemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveItem",
      requestType = com.common.grpc.CartRemoveItemRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CartRemoveItemRequest,
      com.google.protobuf.Empty> getRemoveItemMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CartRemoveItemRequest, com.google.protobuf.Empty> getRemoveItemMethod;
    if ((getRemoveItemMethod = CartServiceGrpc.getRemoveItemMethod) == null) {
      synchronized (CartServiceGrpc.class) {
        if ((getRemoveItemMethod = CartServiceGrpc.getRemoveItemMethod) == null) {
          CartServiceGrpc.getRemoveItemMethod = getRemoveItemMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CartRemoveItemRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveItem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CartRemoveItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CartServiceMethodDescriptorSupplier("RemoveItem"))
              .build();
        }
      }
    }
    return getRemoveItemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CartClearRequest,
      com.google.protobuf.Empty> getClearMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Clear",
      requestType = com.common.grpc.CartClearRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CartClearRequest,
      com.google.protobuf.Empty> getClearMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CartClearRequest, com.google.protobuf.Empty> getClearMethod;
    if ((getClearMethod = CartServiceGrpc.getClearMethod) == null) {
      synchronized (CartServiceGrpc.class) {
        if ((getClearMethod = CartServiceGrpc.getClearMethod) == null) {
          CartServiceGrpc.getClearMethod = getClearMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CartClearRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Clear"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CartClearRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CartServiceMethodDescriptorSupplier("Clear"))
              .build();
        }
      }
    }
    return getClearMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CartListRequest,
      com.common.grpc.CartView> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.common.grpc.CartListRequest.class,
      responseType = com.common.grpc.CartView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CartListRequest,
      com.common.grpc.CartView> getListMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CartListRequest, com.common.grpc.CartView> getListMethod;
    if ((getListMethod = CartServiceGrpc.getListMethod) == null) {
      synchronized (CartServiceGrpc.class) {
        if ((getListMethod = CartServiceGrpc.getListMethod) == null) {
          CartServiceGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CartListRequest, com.common.grpc.CartView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CartListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CartView.getDefaultInstance()))
              .setSchemaDescriptor(new CartServiceMethodDescriptorSupplier("List"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CartApplyCodeRequest,
      com.common.grpc.CartView> getApplyCodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApplyCode",
      requestType = com.common.grpc.CartApplyCodeRequest.class,
      responseType = com.common.grpc.CartView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CartApplyCodeRequest,
      com.common.grpc.CartView> getApplyCodeMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CartApplyCodeRequest, com.common.grpc.CartView> getApplyCodeMethod;
    if ((getApplyCodeMethod = CartServiceGrpc.getApplyCodeMethod) == null) {
      synchronized (CartServiceGrpc.class) {
        if ((getApplyCodeMethod = CartServiceGrpc.getApplyCodeMethod) == null) {
          CartServiceGrpc.getApplyCodeMethod = getApplyCodeMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CartApplyCodeRequest, com.common.grpc.CartView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ApplyCode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CartApplyCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CartView.getDefaultInstance()))
              .setSchemaDescriptor(new CartServiceMethodDescriptorSupplier("ApplyCode"))
              .build();
        }
      }
    }
    return getApplyCodeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CartMergeRequest,
      com.google.protobuf.Empty> getMergeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Merge",
      requestType = com.common.grpc.CartMergeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CartMergeRequest,
      com.google.protobuf.Empty> getMergeMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CartMergeRequest, com.google.protobuf.Empty> getMergeMethod;
    if ((getMergeMethod = CartServiceGrpc.getMergeMethod) == null) {
      synchronized (CartServiceGrpc.class) {
        if ((getMergeMethod = CartServiceGrpc.getMergeMethod) == null) {
          CartServiceGrpc.getMergeMethod = getMergeMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CartMergeRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Merge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CartMergeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CartServiceMethodDescriptorSupplier("Merge"))
              .build();
        }
      }
    }
    return getMergeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CartServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CartServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CartServiceStub>() {
        @java.lang.Override
        public CartServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CartServiceStub(channel, callOptions);
        }
      };
    return CartServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static CartServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CartServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CartServiceBlockingV2Stub>() {
        @java.lang.Override
        public CartServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CartServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return CartServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CartServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CartServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CartServiceBlockingStub>() {
        @java.lang.Override
        public CartServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CartServiceBlockingStub(channel, callOptions);
        }
      };
    return CartServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CartServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CartServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CartServiceFutureStub>() {
        @java.lang.Override
        public CartServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CartServiceFutureStub(channel, callOptions);
        }
      };
    return CartServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getOrCreate(com.common.grpc.CartGetOrCreateRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CartView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOrCreateMethod(), responseObserver);
    }

    /**
     */
    default void addItem(com.common.grpc.CartAddItemRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddItemMethod(), responseObserver);
    }

    /**
     */
    default void updateQty(com.common.grpc.CartUpdateQtyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateQtyMethod(), responseObserver);
    }

    /**
     */
    default void removeItem(com.common.grpc.CartRemoveItemRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveItemMethod(), responseObserver);
    }

    /**
     */
    default void clear(com.common.grpc.CartClearRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getClearMethod(), responseObserver);
    }

    /**
     */
    default void list(com.common.grpc.CartListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CartView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     */
    default void applyCode(com.common.grpc.CartApplyCodeRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CartView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getApplyCodeMethod(), responseObserver);
    }

    /**
     */
    default void merge(com.common.grpc.CartMergeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getMergeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CartService.
   */
  public static abstract class CartServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CartServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CartService.
   */
  public static final class CartServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CartServiceStub> {
    private CartServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CartServiceStub(channel, callOptions);
    }

    /**
     */
    public void getOrCreate(com.common.grpc.CartGetOrCreateRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CartView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addItem(com.common.grpc.CartAddItemRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddItemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateQty(com.common.grpc.CartUpdateQtyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateQtyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeItem(com.common.grpc.CartRemoveItemRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveItemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void clear(com.common.grpc.CartClearRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getClearMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void list(com.common.grpc.CartListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CartView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void applyCode(com.common.grpc.CartApplyCodeRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CartView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApplyCodeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void merge(com.common.grpc.CartMergeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMergeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CartService.
   */
  public static final class CartServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CartServiceBlockingV2Stub> {
    private CartServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CartServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.common.grpc.CartView getOrCreate(com.common.grpc.CartGetOrCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty addItem(com.common.grpc.CartAddItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddItemMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty updateQty(com.common.grpc.CartUpdateQtyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateQtyMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty removeItem(com.common.grpc.CartRemoveItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveItemMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty clear(com.common.grpc.CartClearRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getClearMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.CartView list(com.common.grpc.CartListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.CartView applyCode(com.common.grpc.CartApplyCodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApplyCodeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty merge(com.common.grpc.CartMergeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMergeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CartService.
   */
  public static final class CartServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CartServiceBlockingStub> {
    private CartServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CartServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.common.grpc.CartView getOrCreate(com.common.grpc.CartGetOrCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty addItem(com.common.grpc.CartAddItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddItemMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty updateQty(com.common.grpc.CartUpdateQtyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateQtyMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty removeItem(com.common.grpc.CartRemoveItemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveItemMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty clear(com.common.grpc.CartClearRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getClearMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.CartView list(com.common.grpc.CartListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.CartView applyCode(com.common.grpc.CartApplyCodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApplyCodeMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty merge(com.common.grpc.CartMergeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMergeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CartService.
   */
  public static final class CartServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CartServiceFutureStub> {
    private CartServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CartServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.CartView> getOrCreate(
        com.common.grpc.CartGetOrCreateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> addItem(
        com.common.grpc.CartAddItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddItemMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> updateQty(
        com.common.grpc.CartUpdateQtyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateQtyMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> removeItem(
        com.common.grpc.CartRemoveItemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveItemMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> clear(
        com.common.grpc.CartClearRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getClearMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.CartView> list(
        com.common.grpc.CartListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.CartView> applyCode(
        com.common.grpc.CartApplyCodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApplyCodeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> merge(
        com.common.grpc.CartMergeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMergeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_OR_CREATE = 0;
  private static final int METHODID_ADD_ITEM = 1;
  private static final int METHODID_UPDATE_QTY = 2;
  private static final int METHODID_REMOVE_ITEM = 3;
  private static final int METHODID_CLEAR = 4;
  private static final int METHODID_LIST = 5;
  private static final int METHODID_APPLY_CODE = 6;
  private static final int METHODID_MERGE = 7;

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
        case METHODID_GET_OR_CREATE:
          serviceImpl.getOrCreate((com.common.grpc.CartGetOrCreateRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.CartView>) responseObserver);
          break;
        case METHODID_ADD_ITEM:
          serviceImpl.addItem((com.common.grpc.CartAddItemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_QTY:
          serviceImpl.updateQty((com.common.grpc.CartUpdateQtyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REMOVE_ITEM:
          serviceImpl.removeItem((com.common.grpc.CartRemoveItemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CLEAR:
          serviceImpl.clear((com.common.grpc.CartClearRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list((com.common.grpc.CartListRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.CartView>) responseObserver);
          break;
        case METHODID_APPLY_CODE:
          serviceImpl.applyCode((com.common.grpc.CartApplyCodeRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.CartView>) responseObserver);
          break;
        case METHODID_MERGE:
          serviceImpl.merge((com.common.grpc.CartMergeRequest) request,
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
          getGetOrCreateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CartGetOrCreateRequest,
              com.common.grpc.CartView>(
                service, METHODID_GET_OR_CREATE)))
        .addMethod(
          getAddItemMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CartAddItemRequest,
              com.google.protobuf.Empty>(
                service, METHODID_ADD_ITEM)))
        .addMethod(
          getUpdateQtyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CartUpdateQtyRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UPDATE_QTY)))
        .addMethod(
          getRemoveItemMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CartRemoveItemRequest,
              com.google.protobuf.Empty>(
                service, METHODID_REMOVE_ITEM)))
        .addMethod(
          getClearMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CartClearRequest,
              com.google.protobuf.Empty>(
                service, METHODID_CLEAR)))
        .addMethod(
          getListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CartListRequest,
              com.common.grpc.CartView>(
                service, METHODID_LIST)))
        .addMethod(
          getApplyCodeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CartApplyCodeRequest,
              com.common.grpc.CartView>(
                service, METHODID_APPLY_CODE)))
        .addMethod(
          getMergeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CartMergeRequest,
              com.google.protobuf.Empty>(
                service, METHODID_MERGE)))
        .build();
  }

  private static abstract class CartServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CartServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.CartProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CartService");
    }
  }

  private static final class CartServiceFileDescriptorSupplier
      extends CartServiceBaseDescriptorSupplier {
    CartServiceFileDescriptorSupplier() {}
  }

  private static final class CartServiceMethodDescriptorSupplier
      extends CartServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CartServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CartServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CartServiceFileDescriptorSupplier())
              .addMethod(getGetOrCreateMethod())
              .addMethod(getAddItemMethod())
              .addMethod(getUpdateQtyMethod())
              .addMethod(getRemoveItemMethod())
              .addMethod(getClearMethod())
              .addMethod(getListMethod())
              .addMethod(getApplyCodeMethod())
              .addMethod(getMergeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
