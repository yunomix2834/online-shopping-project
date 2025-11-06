package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: user-role-address.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AddressServiceGrpc {

  private AddressServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "core.v1.AddressService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CreateAddressRequest,
      com.common.grpc.CreateAddressResponse> getCreateAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAddress",
      requestType = com.common.grpc.CreateAddressRequest.class,
      responseType = com.common.grpc.CreateAddressResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CreateAddressRequest,
      com.common.grpc.CreateAddressResponse> getCreateAddressMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CreateAddressRequest, com.common.grpc.CreateAddressResponse> getCreateAddressMethod;
    if ((getCreateAddressMethod = AddressServiceGrpc.getCreateAddressMethod) == null) {
      synchronized (AddressServiceGrpc.class) {
        if ((getCreateAddressMethod = AddressServiceGrpc.getCreateAddressMethod) == null) {
          AddressServiceGrpc.getCreateAddressMethod = getCreateAddressMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CreateAddressRequest, com.common.grpc.CreateAddressResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAddress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CreateAddressRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CreateAddressResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AddressServiceMethodDescriptorSupplier("CreateAddress"))
              .build();
        }
      }
    }
    return getCreateAddressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.UpdateAddressRequest,
      com.common.grpc.UpdateAddressResponse> getUpdateAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAddress",
      requestType = com.common.grpc.UpdateAddressRequest.class,
      responseType = com.common.grpc.UpdateAddressResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.UpdateAddressRequest,
      com.common.grpc.UpdateAddressResponse> getUpdateAddressMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.UpdateAddressRequest, com.common.grpc.UpdateAddressResponse> getUpdateAddressMethod;
    if ((getUpdateAddressMethod = AddressServiceGrpc.getUpdateAddressMethod) == null) {
      synchronized (AddressServiceGrpc.class) {
        if ((getUpdateAddressMethod = AddressServiceGrpc.getUpdateAddressMethod) == null) {
          AddressServiceGrpc.getUpdateAddressMethod = getUpdateAddressMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.UpdateAddressRequest, com.common.grpc.UpdateAddressResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAddress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.UpdateAddressRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.UpdateAddressResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AddressServiceMethodDescriptorSupplier("UpdateAddress"))
              .build();
        }
      }
    }
    return getUpdateAddressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.DeleteAddressRequest,
      com.common.grpc.DeleteAddressResponse> getDeleteAddressMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAddress",
      requestType = com.common.grpc.DeleteAddressRequest.class,
      responseType = com.common.grpc.DeleteAddressResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.DeleteAddressRequest,
      com.common.grpc.DeleteAddressResponse> getDeleteAddressMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.DeleteAddressRequest, com.common.grpc.DeleteAddressResponse> getDeleteAddressMethod;
    if ((getDeleteAddressMethod = AddressServiceGrpc.getDeleteAddressMethod) == null) {
      synchronized (AddressServiceGrpc.class) {
        if ((getDeleteAddressMethod = AddressServiceGrpc.getDeleteAddressMethod) == null) {
          AddressServiceGrpc.getDeleteAddressMethod = getDeleteAddressMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.DeleteAddressRequest, com.common.grpc.DeleteAddressResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAddress"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DeleteAddressRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DeleteAddressResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AddressServiceMethodDescriptorSupplier("DeleteAddress"))
              .build();
        }
      }
    }
    return getDeleteAddressMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.SetDefaultRequest,
      com.common.grpc.SetDefaultResponse> getSetDefaultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetDefault",
      requestType = com.common.grpc.SetDefaultRequest.class,
      responseType = com.common.grpc.SetDefaultResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.SetDefaultRequest,
      com.common.grpc.SetDefaultResponse> getSetDefaultMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.SetDefaultRequest, com.common.grpc.SetDefaultResponse> getSetDefaultMethod;
    if ((getSetDefaultMethod = AddressServiceGrpc.getSetDefaultMethod) == null) {
      synchronized (AddressServiceGrpc.class) {
        if ((getSetDefaultMethod = AddressServiceGrpc.getSetDefaultMethod) == null) {
          AddressServiceGrpc.getSetDefaultMethod = getSetDefaultMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.SetDefaultRequest, com.common.grpc.SetDefaultResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetDefault"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.SetDefaultRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.SetDefaultResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AddressServiceMethodDescriptorSupplier("SetDefault"))
              .build();
        }
      }
    }
    return getSetDefaultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.ListAddressesRequest,
      com.common.grpc.ListAddressesResponse> getListAddressesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAddresses",
      requestType = com.common.grpc.ListAddressesRequest.class,
      responseType = com.common.grpc.ListAddressesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.ListAddressesRequest,
      com.common.grpc.ListAddressesResponse> getListAddressesMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.ListAddressesRequest, com.common.grpc.ListAddressesResponse> getListAddressesMethod;
    if ((getListAddressesMethod = AddressServiceGrpc.getListAddressesMethod) == null) {
      synchronized (AddressServiceGrpc.class) {
        if ((getListAddressesMethod = AddressServiceGrpc.getListAddressesMethod) == null) {
          AddressServiceGrpc.getListAddressesMethod = getListAddressesMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.ListAddressesRequest, com.common.grpc.ListAddressesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAddresses"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ListAddressesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ListAddressesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AddressServiceMethodDescriptorSupplier("ListAddresses"))
              .build();
        }
      }
    }
    return getListAddressesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AddressServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddressServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddressServiceStub>() {
        @java.lang.Override
        public AddressServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddressServiceStub(channel, callOptions);
        }
      };
    return AddressServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static AddressServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddressServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddressServiceBlockingV2Stub>() {
        @java.lang.Override
        public AddressServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddressServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return AddressServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AddressServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddressServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddressServiceBlockingStub>() {
        @java.lang.Override
        public AddressServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddressServiceBlockingStub(channel, callOptions);
        }
      };
    return AddressServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AddressServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AddressServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AddressServiceFutureStub>() {
        @java.lang.Override
        public AddressServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AddressServiceFutureStub(channel, callOptions);
        }
      };
    return AddressServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createAddress(com.common.grpc.CreateAddressRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CreateAddressResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAddressMethod(), responseObserver);
    }

    /**
     */
    default void updateAddress(com.common.grpc.UpdateAddressRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.UpdateAddressResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAddressMethod(), responseObserver);
    }

    /**
     */
    default void deleteAddress(com.common.grpc.DeleteAddressRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.DeleteAddressResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAddressMethod(), responseObserver);
    }

    /**
     */
    default void setDefault(com.common.grpc.SetDefaultRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.SetDefaultResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetDefaultMethod(), responseObserver);
    }

    /**
     */
    default void listAddresses(com.common.grpc.ListAddressesRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ListAddressesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAddressesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AddressService.
   */
  public static abstract class AddressServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AddressServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AddressService.
   */
  public static final class AddressServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AddressServiceStub> {
    private AddressServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddressServiceStub(channel, callOptions);
    }

    /**
     */
    public void createAddress(com.common.grpc.CreateAddressRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CreateAddressResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAddressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateAddress(com.common.grpc.UpdateAddressRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.UpdateAddressResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAddressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteAddress(com.common.grpc.DeleteAddressRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.DeleteAddressResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAddressMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void setDefault(com.common.grpc.SetDefaultRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.SetDefaultResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetDefaultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listAddresses(com.common.grpc.ListAddressesRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ListAddressesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAddressesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AddressService.
   */
  public static final class AddressServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AddressServiceBlockingV2Stub> {
    private AddressServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddressServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.common.grpc.CreateAddressResponse createAddress(com.common.grpc.CreateAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAddressMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.UpdateAddressResponse updateAddress(com.common.grpc.UpdateAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAddressMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.DeleteAddressResponse deleteAddress(com.common.grpc.DeleteAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAddressMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.SetDefaultResponse setDefault(com.common.grpc.SetDefaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetDefaultMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ListAddressesResponse listAddresses(com.common.grpc.ListAddressesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAddressesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AddressService.
   */
  public static final class AddressServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AddressServiceBlockingStub> {
    private AddressServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddressServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.common.grpc.CreateAddressResponse createAddress(com.common.grpc.CreateAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAddressMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.UpdateAddressResponse updateAddress(com.common.grpc.UpdateAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAddressMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.DeleteAddressResponse deleteAddress(com.common.grpc.DeleteAddressRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAddressMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.SetDefaultResponse setDefault(com.common.grpc.SetDefaultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetDefaultMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ListAddressesResponse listAddresses(com.common.grpc.ListAddressesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAddressesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AddressService.
   */
  public static final class AddressServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AddressServiceFutureStub> {
    private AddressServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AddressServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AddressServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.CreateAddressResponse> createAddress(
        com.common.grpc.CreateAddressRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAddressMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.UpdateAddressResponse> updateAddress(
        com.common.grpc.UpdateAddressRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAddressMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.DeleteAddressResponse> deleteAddress(
        com.common.grpc.DeleteAddressRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAddressMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.SetDefaultResponse> setDefault(
        com.common.grpc.SetDefaultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetDefaultMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.ListAddressesResponse> listAddresses(
        com.common.grpc.ListAddressesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAddressesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ADDRESS = 0;
  private static final int METHODID_UPDATE_ADDRESS = 1;
  private static final int METHODID_DELETE_ADDRESS = 2;
  private static final int METHODID_SET_DEFAULT = 3;
  private static final int METHODID_LIST_ADDRESSES = 4;

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
        case METHODID_CREATE_ADDRESS:
          serviceImpl.createAddress((com.common.grpc.CreateAddressRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.CreateAddressResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ADDRESS:
          serviceImpl.updateAddress((com.common.grpc.UpdateAddressRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.UpdateAddressResponse>) responseObserver);
          break;
        case METHODID_DELETE_ADDRESS:
          serviceImpl.deleteAddress((com.common.grpc.DeleteAddressRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.DeleteAddressResponse>) responseObserver);
          break;
        case METHODID_SET_DEFAULT:
          serviceImpl.setDefault((com.common.grpc.SetDefaultRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.SetDefaultResponse>) responseObserver);
          break;
        case METHODID_LIST_ADDRESSES:
          serviceImpl.listAddresses((com.common.grpc.ListAddressesRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.ListAddressesResponse>) responseObserver);
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
          getCreateAddressMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CreateAddressRequest,
              com.common.grpc.CreateAddressResponse>(
                service, METHODID_CREATE_ADDRESS)))
        .addMethod(
          getUpdateAddressMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.UpdateAddressRequest,
              com.common.grpc.UpdateAddressResponse>(
                service, METHODID_UPDATE_ADDRESS)))
        .addMethod(
          getDeleteAddressMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.DeleteAddressRequest,
              com.common.grpc.DeleteAddressResponse>(
                service, METHODID_DELETE_ADDRESS)))
        .addMethod(
          getSetDefaultMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.SetDefaultRequest,
              com.common.grpc.SetDefaultResponse>(
                service, METHODID_SET_DEFAULT)))
        .addMethod(
          getListAddressesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.ListAddressesRequest,
              com.common.grpc.ListAddressesResponse>(
                service, METHODID_LIST_ADDRESSES)))
        .build();
  }

  private static abstract class AddressServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AddressServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.UserRoleAddressProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AddressService");
    }
  }

  private static final class AddressServiceFileDescriptorSupplier
      extends AddressServiceBaseDescriptorSupplier {
    AddressServiceFileDescriptorSupplier() {}
  }

  private static final class AddressServiceMethodDescriptorSupplier
      extends AddressServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AddressServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AddressServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AddressServiceFileDescriptorSupplier())
              .addMethod(getCreateAddressMethod())
              .addMethod(getUpdateAddressMethod())
              .addMethod(getDeleteAddressMethod())
              .addMethod(getSetDefaultMethod())
              .addMethod(getListAddressesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
