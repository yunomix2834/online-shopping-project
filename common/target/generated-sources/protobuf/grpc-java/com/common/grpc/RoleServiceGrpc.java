package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: user-role-address.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RoleServiceGrpc {

  private RoleServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "core.v1.RoleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CreateRoleRequest,
      com.common.grpc.CreateRoleResponse> getCreateRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRole",
      requestType = com.common.grpc.CreateRoleRequest.class,
      responseType = com.common.grpc.CreateRoleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CreateRoleRequest,
      com.common.grpc.CreateRoleResponse> getCreateRoleMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CreateRoleRequest, com.common.grpc.CreateRoleResponse> getCreateRoleMethod;
    if ((getCreateRoleMethod = RoleServiceGrpc.getCreateRoleMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getCreateRoleMethod = RoleServiceGrpc.getCreateRoleMethod) == null) {
          RoleServiceGrpc.getCreateRoleMethod = getCreateRoleMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CreateRoleRequest, com.common.grpc.CreateRoleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CreateRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CreateRoleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("CreateRole"))
              .build();
        }
      }
    }
    return getCreateRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.DeleteRoleRequest,
      com.common.grpc.DeleteRoleResponse> getDeleteRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRole",
      requestType = com.common.grpc.DeleteRoleRequest.class,
      responseType = com.common.grpc.DeleteRoleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.DeleteRoleRequest,
      com.common.grpc.DeleteRoleResponse> getDeleteRoleMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.DeleteRoleRequest, com.common.grpc.DeleteRoleResponse> getDeleteRoleMethod;
    if ((getDeleteRoleMethod = RoleServiceGrpc.getDeleteRoleMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getDeleteRoleMethod = RoleServiceGrpc.getDeleteRoleMethod) == null) {
          RoleServiceGrpc.getDeleteRoleMethod = getDeleteRoleMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.DeleteRoleRequest, com.common.grpc.DeleteRoleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DeleteRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.DeleteRoleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("DeleteRole"))
              .build();
        }
      }
    }
    return getDeleteRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest,
      com.common.grpc.AssignRoleResponse> getAssignRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AssignRole",
      requestType = com.common.grpc.AssignRoleRequest.class,
      responseType = com.common.grpc.AssignRoleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest,
      com.common.grpc.AssignRoleResponse> getAssignRoleMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest, com.common.grpc.AssignRoleResponse> getAssignRoleMethod;
    if ((getAssignRoleMethod = RoleServiceGrpc.getAssignRoleMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getAssignRoleMethod = RoleServiceGrpc.getAssignRoleMethod) == null) {
          RoleServiceGrpc.getAssignRoleMethod = getAssignRoleMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.AssignRoleRequest, com.common.grpc.AssignRoleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AssignRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.AssignRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.AssignRoleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("AssignRole"))
              .build();
        }
      }
    }
    return getAssignRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.RemoveRoleRequest,
      com.common.grpc.RemoveRoleResponse> getRemoveRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveRole",
      requestType = com.common.grpc.RemoveRoleRequest.class,
      responseType = com.common.grpc.RemoveRoleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.RemoveRoleRequest,
      com.common.grpc.RemoveRoleResponse> getRemoveRoleMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.RemoveRoleRequest, com.common.grpc.RemoveRoleResponse> getRemoveRoleMethod;
    if ((getRemoveRoleMethod = RoleServiceGrpc.getRemoveRoleMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRemoveRoleMethod = RoleServiceGrpc.getRemoveRoleMethod) == null) {
          RoleServiceGrpc.getRemoveRoleMethod = getRemoveRoleMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.RemoveRoleRequest, com.common.grpc.RemoveRoleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.RemoveRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.RemoveRoleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("RemoveRole"))
              .build();
        }
      }
    }
    return getRemoveRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.ListUserRolesRequest,
      com.common.grpc.ListUserRolesResponse> getListUserRolesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserRoles",
      requestType = com.common.grpc.ListUserRolesRequest.class,
      responseType = com.common.grpc.ListUserRolesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.ListUserRolesRequest,
      com.common.grpc.ListUserRolesResponse> getListUserRolesMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.ListUserRolesRequest, com.common.grpc.ListUserRolesResponse> getListUserRolesMethod;
    if ((getListUserRolesMethod = RoleServiceGrpc.getListUserRolesMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getListUserRolesMethod = RoleServiceGrpc.getListUserRolesMethod) == null) {
          RoleServiceGrpc.getListUserRolesMethod = getListUserRolesMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.ListUserRolesRequest, com.common.grpc.ListUserRolesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUserRoles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ListUserRolesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ListUserRolesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("ListUserRoles"))
              .build();
        }
      }
    }
    return getListUserRolesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.ListUsersByRoleRequest,
      com.common.grpc.ListUsersByRoleResponse> getListUsersByRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUsersByRole",
      requestType = com.common.grpc.ListUsersByRoleRequest.class,
      responseType = com.common.grpc.ListUsersByRoleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.ListUsersByRoleRequest,
      com.common.grpc.ListUsersByRoleResponse> getListUsersByRoleMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.ListUsersByRoleRequest, com.common.grpc.ListUsersByRoleResponse> getListUsersByRoleMethod;
    if ((getListUsersByRoleMethod = RoleServiceGrpc.getListUsersByRoleMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getListUsersByRoleMethod = RoleServiceGrpc.getListUsersByRoleMethod) == null) {
          RoleServiceGrpc.getListUsersByRoleMethod = getListUsersByRoleMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.ListUsersByRoleRequest, com.common.grpc.ListUsersByRoleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUsersByRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ListUsersByRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ListUsersByRoleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("ListUsersByRole"))
              .build();
        }
      }
    }
    return getListUsersByRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.ListAllRolesRequest,
      com.common.grpc.ListAllRolesResponse> getListAllRolesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAllRoles",
      requestType = com.common.grpc.ListAllRolesRequest.class,
      responseType = com.common.grpc.ListAllRolesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.ListAllRolesRequest,
      com.common.grpc.ListAllRolesResponse> getListAllRolesMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.ListAllRolesRequest, com.common.grpc.ListAllRolesResponse> getListAllRolesMethod;
    if ((getListAllRolesMethod = RoleServiceGrpc.getListAllRolesMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getListAllRolesMethod = RoleServiceGrpc.getListAllRolesMethod) == null) {
          RoleServiceGrpc.getListAllRolesMethod = getListAllRolesMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.ListAllRolesRequest, com.common.grpc.ListAllRolesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAllRoles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ListAllRolesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ListAllRolesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("ListAllRoles"))
              .build();
        }
      }
    }
    return getListAllRolesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RoleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoleServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoleServiceStub>() {
        @java.lang.Override
        public RoleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoleServiceStub(channel, callOptions);
        }
      };
    return RoleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static RoleServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoleServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoleServiceBlockingV2Stub>() {
        @java.lang.Override
        public RoleServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoleServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return RoleServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoleServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoleServiceBlockingStub>() {
        @java.lang.Override
        public RoleServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoleServiceBlockingStub(channel, callOptions);
        }
      };
    return RoleServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RoleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoleServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoleServiceFutureStub>() {
        @java.lang.Override
        public RoleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoleServiceFutureStub(channel, callOptions);
        }
      };
    return RoleServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createRole(com.common.grpc.CreateRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CreateRoleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateRoleMethod(), responseObserver);
    }

    /**
     */
    default void deleteRole(com.common.grpc.DeleteRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.DeleteRoleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteRoleMethod(), responseObserver);
    }

    /**
     */
    default void assignRole(com.common.grpc.AssignRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.AssignRoleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAssignRoleMethod(), responseObserver);
    }

    /**
     */
    default void removeRole(com.common.grpc.RemoveRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.RemoveRoleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveRoleMethod(), responseObserver);
    }

    /**
     */
    default void listUserRoles(com.common.grpc.ListUserRolesRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ListUserRolesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUserRolesMethod(), responseObserver);
    }

    /**
     */
    default void listUsersByRole(com.common.grpc.ListUsersByRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ListUsersByRoleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUsersByRoleMethod(), responseObserver);
    }

    /**
     */
    default void listAllRoles(com.common.grpc.ListAllRolesRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ListAllRolesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAllRolesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RoleService.
   */
  public static abstract class RoleServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return RoleServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RoleService.
   */
  public static final class RoleServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RoleServiceStub> {
    private RoleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoleServiceStub(channel, callOptions);
    }

    /**
     */
    public void createRole(com.common.grpc.CreateRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CreateRoleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteRole(com.common.grpc.DeleteRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.DeleteRoleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void assignRole(com.common.grpc.AssignRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.AssignRoleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAssignRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeRole(com.common.grpc.RemoveRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.RemoveRoleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listUserRoles(com.common.grpc.ListUserRolesRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ListUserRolesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserRolesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listUsersByRole(com.common.grpc.ListUsersByRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ListUsersByRoleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUsersByRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listAllRoles(com.common.grpc.ListAllRolesRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ListAllRolesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAllRolesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RoleService.
   */
  public static final class RoleServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<RoleServiceBlockingV2Stub> {
    private RoleServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoleServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoleServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.common.grpc.CreateRoleResponse createRole(com.common.grpc.CreateRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.DeleteRoleResponse deleteRole(com.common.grpc.DeleteRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.AssignRoleResponse assignRole(com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.RemoveRoleResponse removeRole(com.common.grpc.RemoveRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ListUserRolesResponse listUserRoles(com.common.grpc.ListUserRolesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserRolesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ListUsersByRoleResponse listUsersByRole(com.common.grpc.ListUsersByRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsersByRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ListAllRolesResponse listAllRoles(com.common.grpc.ListAllRolesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllRolesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service RoleService.
   */
  public static final class RoleServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RoleServiceBlockingStub> {
    private RoleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.common.grpc.CreateRoleResponse createRole(com.common.grpc.CreateRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.DeleteRoleResponse deleteRole(com.common.grpc.DeleteRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.AssignRoleResponse assignRole(com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.RemoveRoleResponse removeRole(com.common.grpc.RemoveRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ListUserRolesResponse listUserRoles(com.common.grpc.ListUserRolesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserRolesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ListUsersByRoleResponse listUsersByRole(com.common.grpc.ListUsersByRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsersByRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ListAllRolesResponse listAllRoles(com.common.grpc.ListAllRolesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllRolesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service RoleService.
   */
  public static final class RoleServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RoleServiceFutureStub> {
    private RoleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.CreateRoleResponse> createRole(
        com.common.grpc.CreateRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRoleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.DeleteRoleResponse> deleteRole(
        com.common.grpc.DeleteRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRoleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.AssignRoleResponse> assignRole(
        com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAssignRoleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.RemoveRoleResponse> removeRole(
        com.common.grpc.RemoveRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveRoleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.ListUserRolesResponse> listUserRoles(
        com.common.grpc.ListUserRolesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserRolesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.ListUsersByRoleResponse> listUsersByRole(
        com.common.grpc.ListUsersByRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUsersByRoleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.ListAllRolesResponse> listAllRoles(
        com.common.grpc.ListAllRolesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAllRolesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ROLE = 0;
  private static final int METHODID_DELETE_ROLE = 1;
  private static final int METHODID_ASSIGN_ROLE = 2;
  private static final int METHODID_REMOVE_ROLE = 3;
  private static final int METHODID_LIST_USER_ROLES = 4;
  private static final int METHODID_LIST_USERS_BY_ROLE = 5;
  private static final int METHODID_LIST_ALL_ROLES = 6;

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
        case METHODID_CREATE_ROLE:
          serviceImpl.createRole((com.common.grpc.CreateRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.CreateRoleResponse>) responseObserver);
          break;
        case METHODID_DELETE_ROLE:
          serviceImpl.deleteRole((com.common.grpc.DeleteRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.DeleteRoleResponse>) responseObserver);
          break;
        case METHODID_ASSIGN_ROLE:
          serviceImpl.assignRole((com.common.grpc.AssignRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.AssignRoleResponse>) responseObserver);
          break;
        case METHODID_REMOVE_ROLE:
          serviceImpl.removeRole((com.common.grpc.RemoveRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.RemoveRoleResponse>) responseObserver);
          break;
        case METHODID_LIST_USER_ROLES:
          serviceImpl.listUserRoles((com.common.grpc.ListUserRolesRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.ListUserRolesResponse>) responseObserver);
          break;
        case METHODID_LIST_USERS_BY_ROLE:
          serviceImpl.listUsersByRole((com.common.grpc.ListUsersByRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.ListUsersByRoleResponse>) responseObserver);
          break;
        case METHODID_LIST_ALL_ROLES:
          serviceImpl.listAllRoles((com.common.grpc.ListAllRolesRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.ListAllRolesResponse>) responseObserver);
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
          getCreateRoleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CreateRoleRequest,
              com.common.grpc.CreateRoleResponse>(
                service, METHODID_CREATE_ROLE)))
        .addMethod(
          getDeleteRoleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.DeleteRoleRequest,
              com.common.grpc.DeleteRoleResponse>(
                service, METHODID_DELETE_ROLE)))
        .addMethod(
          getAssignRoleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.AssignRoleRequest,
              com.common.grpc.AssignRoleResponse>(
                service, METHODID_ASSIGN_ROLE)))
        .addMethod(
          getRemoveRoleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.RemoveRoleRequest,
              com.common.grpc.RemoveRoleResponse>(
                service, METHODID_REMOVE_ROLE)))
        .addMethod(
          getListUserRolesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.ListUserRolesRequest,
              com.common.grpc.ListUserRolesResponse>(
                service, METHODID_LIST_USER_ROLES)))
        .addMethod(
          getListUsersByRoleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.ListUsersByRoleRequest,
              com.common.grpc.ListUsersByRoleResponse>(
                service, METHODID_LIST_USERS_BY_ROLE)))
        .addMethod(
          getListAllRolesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.ListAllRolesRequest,
              com.common.grpc.ListAllRolesResponse>(
                service, METHODID_LIST_ALL_ROLES)))
        .build();
  }

  private static abstract class RoleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.UserRoleAddressProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RoleService");
    }
  }

  private static final class RoleServiceFileDescriptorSupplier
      extends RoleServiceBaseDescriptorSupplier {
    RoleServiceFileDescriptorSupplier() {}
  }

  private static final class RoleServiceMethodDescriptorSupplier
      extends RoleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RoleServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RoleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RoleServiceFileDescriptorSupplier())
              .addMethod(getCreateRoleMethod())
              .addMethod(getDeleteRoleMethod())
              .addMethod(getAssignRoleMethod())
              .addMethod(getRemoveRoleMethod())
              .addMethod(getListUserRolesMethod())
              .addMethod(getListUsersByRoleMethod())
              .addMethod(getListAllRolesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
