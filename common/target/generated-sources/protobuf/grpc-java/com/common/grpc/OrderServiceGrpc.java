package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: business/order.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrderServiceGrpc {

  private OrderServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "onlineshopping.v1.OrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CreateOrderFromCartRequest,
      com.common.grpc.OrderView> getCreateFromCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFromCart",
      requestType = com.common.grpc.CreateOrderFromCartRequest.class,
      responseType = com.common.grpc.OrderView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CreateOrderFromCartRequest,
      com.common.grpc.OrderView> getCreateFromCartMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CreateOrderFromCartRequest, com.common.grpc.OrderView> getCreateFromCartMethod;
    if ((getCreateFromCartMethod = OrderServiceGrpc.getCreateFromCartMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getCreateFromCartMethod = OrderServiceGrpc.getCreateFromCartMethod) == null) {
          OrderServiceGrpc.getCreateFromCartMethod = getCreateFromCartMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CreateOrderFromCartRequest, com.common.grpc.OrderView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFromCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CreateOrderFromCartRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OrderView.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("CreateFromCart"))
              .build();
        }
      }
    }
    return getCreateFromCartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CreateOrderDirectRequest,
      com.common.grpc.OrderView> getCreateDirectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDirect",
      requestType = com.common.grpc.CreateOrderDirectRequest.class,
      responseType = com.common.grpc.OrderView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CreateOrderDirectRequest,
      com.common.grpc.OrderView> getCreateDirectMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CreateOrderDirectRequest, com.common.grpc.OrderView> getCreateDirectMethod;
    if ((getCreateDirectMethod = OrderServiceGrpc.getCreateDirectMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getCreateDirectMethod = OrderServiceGrpc.getCreateDirectMethod) == null) {
          OrderServiceGrpc.getCreateDirectMethod = getCreateDirectMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CreateOrderDirectRequest, com.common.grpc.OrderView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDirect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CreateOrderDirectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OrderView.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("CreateDirect"))
              .build();
        }
      }
    }
    return getCreateDirectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.OrderIdRequest,
      com.common.grpc.OrderView> getGetDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDetail",
      requestType = com.common.grpc.OrderIdRequest.class,
      responseType = com.common.grpc.OrderView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.OrderIdRequest,
      com.common.grpc.OrderView> getGetDetailMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.OrderIdRequest, com.common.grpc.OrderView> getGetDetailMethod;
    if ((getGetDetailMethod = OrderServiceGrpc.getGetDetailMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getGetDetailMethod = OrderServiceGrpc.getGetDetailMethod) == null) {
          OrderServiceGrpc.getGetDetailMethod = getGetDetailMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.OrderIdRequest, com.common.grpc.OrderView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDetail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OrderIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OrderView.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("GetDetail"))
              .build();
        }
      }
    }
    return getGetDetailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.OrderListRequest,
      com.common.grpc.PageOrder> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.common.grpc.OrderListRequest.class,
      responseType = com.common.grpc.PageOrder.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.OrderListRequest,
      com.common.grpc.PageOrder> getListMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.OrderListRequest, com.common.grpc.PageOrder> getListMethod;
    if ((getListMethod = OrderServiceGrpc.getListMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getListMethod = OrderServiceGrpc.getListMethod) == null) {
          OrderServiceGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.OrderListRequest, com.common.grpc.PageOrder>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OrderListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageOrder.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("List"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.OrderUpdateStatusRequest,
      com.google.protobuf.Empty> getUpdateStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStatus",
      requestType = com.common.grpc.OrderUpdateStatusRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.OrderUpdateStatusRequest,
      com.google.protobuf.Empty> getUpdateStatusMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.OrderUpdateStatusRequest, com.google.protobuf.Empty> getUpdateStatusMethod;
    if ((getUpdateStatusMethod = OrderServiceGrpc.getUpdateStatusMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getUpdateStatusMethod = OrderServiceGrpc.getUpdateStatusMethod) == null) {
          OrderServiceGrpc.getUpdateStatusMethod = getUpdateStatusMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.OrderUpdateStatusRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OrderUpdateStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("UpdateStatus"))
              .build();
        }
      }
    }
    return getUpdateStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.OrderCancelRequest,
      com.google.protobuf.Empty> getCancelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Cancel",
      requestType = com.common.grpc.OrderCancelRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.OrderCancelRequest,
      com.google.protobuf.Empty> getCancelMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.OrderCancelRequest, com.google.protobuf.Empty> getCancelMethod;
    if ((getCancelMethod = OrderServiceGrpc.getCancelMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getCancelMethod = OrderServiceGrpc.getCancelMethod) == null) {
          OrderServiceGrpc.getCancelMethod = getCancelMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.OrderCancelRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Cancel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OrderCancelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("Cancel"))
              .build();
        }
      }
    }
    return getCancelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.OrderPatchChargesRequest,
      com.google.protobuf.Empty> getPatchChargesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PatchCharges",
      requestType = com.common.grpc.OrderPatchChargesRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.OrderPatchChargesRequest,
      com.google.protobuf.Empty> getPatchChargesMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.OrderPatchChargesRequest, com.google.protobuf.Empty> getPatchChargesMethod;
    if ((getPatchChargesMethod = OrderServiceGrpc.getPatchChargesMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getPatchChargesMethod = OrderServiceGrpc.getPatchChargesMethod) == null) {
          OrderServiceGrpc.getPatchChargesMethod = getPatchChargesMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.OrderPatchChargesRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PatchCharges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OrderPatchChargesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("PatchCharges"))
              .build();
        }
      }
    }
    return getPatchChargesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.OrderApplyOrSwapCodeRequest,
      com.google.protobuf.Empty> getApplyOrSwapCodeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApplyOrSwapCode",
      requestType = com.common.grpc.OrderApplyOrSwapCodeRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.OrderApplyOrSwapCodeRequest,
      com.google.protobuf.Empty> getApplyOrSwapCodeMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.OrderApplyOrSwapCodeRequest, com.google.protobuf.Empty> getApplyOrSwapCodeMethod;
    if ((getApplyOrSwapCodeMethod = OrderServiceGrpc.getApplyOrSwapCodeMethod) == null) {
      synchronized (OrderServiceGrpc.class) {
        if ((getApplyOrSwapCodeMethod = OrderServiceGrpc.getApplyOrSwapCodeMethod) == null) {
          OrderServiceGrpc.getApplyOrSwapCodeMethod = getApplyOrSwapCodeMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.OrderApplyOrSwapCodeRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ApplyOrSwapCode"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.OrderApplyOrSwapCodeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new OrderServiceMethodDescriptorSupplier("ApplyOrSwapCode"))
              .build();
        }
      }
    }
    return getApplyOrSwapCodeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceStub>() {
        @java.lang.Override
        public OrderServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceStub(channel, callOptions);
        }
      };
    return OrderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static OrderServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingV2Stub>() {
        @java.lang.Override
        public OrderServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return OrderServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceBlockingStub>() {
        @java.lang.Override
        public OrderServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceBlockingStub(channel, callOptions);
        }
      };
    return OrderServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OrderServiceFutureStub>() {
        @java.lang.Override
        public OrderServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OrderServiceFutureStub(channel, callOptions);
        }
      };
    return OrderServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createFromCart(com.common.grpc.CreateOrderFromCartRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.OrderView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFromCartMethod(), responseObserver);
    }

    /**
     */
    default void createDirect(com.common.grpc.CreateOrderDirectRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.OrderView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateDirectMethod(), responseObserver);
    }

    /**
     */
    default void getDetail(com.common.grpc.OrderIdRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.OrderView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDetailMethod(), responseObserver);
    }

    /**
     */
    default void list(com.common.grpc.OrderListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageOrder> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     */
    default void updateStatus(com.common.grpc.OrderUpdateStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateStatusMethod(), responseObserver);
    }

    /**
     */
    default void cancel(com.common.grpc.OrderCancelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelMethod(), responseObserver);
    }

    /**
     */
    default void patchCharges(com.common.grpc.OrderPatchChargesRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPatchChargesMethod(), responseObserver);
    }

    /**
     */
    default void applyOrSwapCode(com.common.grpc.OrderApplyOrSwapCodeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getApplyOrSwapCodeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OrderService.
   */
  public static abstract class OrderServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OrderServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OrderService.
   */
  public static final class OrderServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OrderServiceStub> {
    private OrderServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceStub(channel, callOptions);
    }

    /**
     */
    public void createFromCart(com.common.grpc.CreateOrderFromCartRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.OrderView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFromCartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createDirect(com.common.grpc.CreateOrderDirectRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.OrderView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDirectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDetail(com.common.grpc.OrderIdRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.OrderView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDetailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void list(com.common.grpc.OrderListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageOrder> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateStatus(com.common.grpc.OrderUpdateStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancel(com.common.grpc.OrderCancelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void patchCharges(com.common.grpc.OrderPatchChargesRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPatchChargesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void applyOrSwapCode(com.common.grpc.OrderApplyOrSwapCodeRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getApplyOrSwapCodeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OrderService.
   */
  public static final class OrderServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OrderServiceBlockingV2Stub> {
    private OrderServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.common.grpc.OrderView createFromCart(com.common.grpc.CreateOrderFromCartRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFromCartMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.OrderView createDirect(com.common.grpc.CreateOrderDirectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDirectMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.OrderView getDetail(com.common.grpc.OrderIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDetailMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageOrder list(com.common.grpc.OrderListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty updateStatus(com.common.grpc.OrderUpdateStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty cancel(com.common.grpc.OrderCancelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty patchCharges(com.common.grpc.OrderPatchChargesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPatchChargesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty applyOrSwapCode(com.common.grpc.OrderApplyOrSwapCodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApplyOrSwapCodeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service OrderService.
   */
  public static final class OrderServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrderServiceBlockingStub> {
    private OrderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.common.grpc.OrderView createFromCart(com.common.grpc.CreateOrderFromCartRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFromCartMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.OrderView createDirect(com.common.grpc.CreateOrderDirectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDirectMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.OrderView getDetail(com.common.grpc.OrderIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDetailMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageOrder list(com.common.grpc.OrderListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty updateStatus(com.common.grpc.OrderUpdateStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty cancel(com.common.grpc.OrderCancelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty patchCharges(com.common.grpc.OrderPatchChargesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPatchChargesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty applyOrSwapCode(com.common.grpc.OrderApplyOrSwapCodeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getApplyOrSwapCodeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OrderService.
   */
  public static final class OrderServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrderServiceFutureStub> {
    private OrderServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.OrderView> createFromCart(
        com.common.grpc.CreateOrderFromCartRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFromCartMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.OrderView> createDirect(
        com.common.grpc.CreateOrderDirectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDirectMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.OrderView> getDetail(
        com.common.grpc.OrderIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDetailMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.PageOrder> list(
        com.common.grpc.OrderListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> updateStatus(
        com.common.grpc.OrderUpdateStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStatusMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> cancel(
        com.common.grpc.OrderCancelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> patchCharges(
        com.common.grpc.OrderPatchChargesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPatchChargesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> applyOrSwapCode(
        com.common.grpc.OrderApplyOrSwapCodeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getApplyOrSwapCodeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FROM_CART = 0;
  private static final int METHODID_CREATE_DIRECT = 1;
  private static final int METHODID_GET_DETAIL = 2;
  private static final int METHODID_LIST = 3;
  private static final int METHODID_UPDATE_STATUS = 4;
  private static final int METHODID_CANCEL = 5;
  private static final int METHODID_PATCH_CHARGES = 6;
  private static final int METHODID_APPLY_OR_SWAP_CODE = 7;

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
        case METHODID_CREATE_FROM_CART:
          serviceImpl.createFromCart((com.common.grpc.CreateOrderFromCartRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.OrderView>) responseObserver);
          break;
        case METHODID_CREATE_DIRECT:
          serviceImpl.createDirect((com.common.grpc.CreateOrderDirectRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.OrderView>) responseObserver);
          break;
        case METHODID_GET_DETAIL:
          serviceImpl.getDetail((com.common.grpc.OrderIdRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.OrderView>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list((com.common.grpc.OrderListRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.PageOrder>) responseObserver);
          break;
        case METHODID_UPDATE_STATUS:
          serviceImpl.updateStatus((com.common.grpc.OrderUpdateStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CANCEL:
          serviceImpl.cancel((com.common.grpc.OrderCancelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_PATCH_CHARGES:
          serviceImpl.patchCharges((com.common.grpc.OrderPatchChargesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_APPLY_OR_SWAP_CODE:
          serviceImpl.applyOrSwapCode((com.common.grpc.OrderApplyOrSwapCodeRequest) request,
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
          getCreateFromCartMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CreateOrderFromCartRequest,
              com.common.grpc.OrderView>(
                service, METHODID_CREATE_FROM_CART)))
        .addMethod(
          getCreateDirectMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CreateOrderDirectRequest,
              com.common.grpc.OrderView>(
                service, METHODID_CREATE_DIRECT)))
        .addMethod(
          getGetDetailMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.OrderIdRequest,
              com.common.grpc.OrderView>(
                service, METHODID_GET_DETAIL)))
        .addMethod(
          getListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.OrderListRequest,
              com.common.grpc.PageOrder>(
                service, METHODID_LIST)))
        .addMethod(
          getUpdateStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.OrderUpdateStatusRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UPDATE_STATUS)))
        .addMethod(
          getCancelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.OrderCancelRequest,
              com.google.protobuf.Empty>(
                service, METHODID_CANCEL)))
        .addMethod(
          getPatchChargesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.OrderPatchChargesRequest,
              com.google.protobuf.Empty>(
                service, METHODID_PATCH_CHARGES)))
        .addMethod(
          getApplyOrSwapCodeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.OrderApplyOrSwapCodeRequest,
              com.google.protobuf.Empty>(
                service, METHODID_APPLY_OR_SWAP_CODE)))
        .build();
  }

  private static abstract class OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.OrderProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderService");
    }
  }

  private static final class OrderServiceFileDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier {
    OrderServiceFileDescriptorSupplier() {}
  }

  private static final class OrderServiceMethodDescriptorSupplier
      extends OrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OrderServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderServiceFileDescriptorSupplier())
              .addMethod(getCreateFromCartMethod())
              .addMethod(getCreateDirectMethod())
              .addMethod(getGetDetailMethod())
              .addMethod(getListMethod())
              .addMethod(getUpdateStatusMethod())
              .addMethod(getCancelMethod())
              .addMethod(getPatchChargesMethod())
              .addMethod(getApplyOrSwapCodeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
