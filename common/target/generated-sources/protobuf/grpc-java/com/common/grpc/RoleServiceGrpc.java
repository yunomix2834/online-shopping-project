package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: role.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RoleServiceGrpc {

  private RoleServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "core.v1.RoleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CreateRoleRequest,
      com.google.protobuf.Empty> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = com.common.grpc.CreateRoleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CreateRoleRequest,
      com.google.protobuf.Empty> getCreateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CreateRoleRequest, com.google.protobuf.Empty> getCreateMethod;
    if ((getCreateMethod = RoleServiceGrpc.getCreateMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getCreateMethod = RoleServiceGrpc.getCreateMethod) == null) {
          RoleServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CreateRoleRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CreateRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.RoleName,
      com.google.protobuf.Empty> getSoftDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SoftDelete",
      requestType = com.common.grpc.RoleName.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.RoleName,
      com.google.protobuf.Empty> getSoftDeleteMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.RoleName, com.google.protobuf.Empty> getSoftDeleteMethod;
    if ((getSoftDeleteMethod = RoleServiceGrpc.getSoftDeleteMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getSoftDeleteMethod = RoleServiceGrpc.getSoftDeleteMethod) == null) {
          RoleServiceGrpc.getSoftDeleteMethod = getSoftDeleteMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.RoleName, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SoftDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.RoleName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("SoftDelete"))
              .build();
        }
      }
    }
    return getSoftDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.RoleName,
      com.google.protobuf.Empty> getRestoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Restore",
      requestType = com.common.grpc.RoleName.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.RoleName,
      com.google.protobuf.Empty> getRestoreMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.RoleName, com.google.protobuf.Empty> getRestoreMethod;
    if ((getRestoreMethod = RoleServiceGrpc.getRestoreMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRestoreMethod = RoleServiceGrpc.getRestoreMethod) == null) {
          RoleServiceGrpc.getRestoreMethod = getRestoreMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.RoleName, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Restore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.RoleName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("Restore"))
              .build();
        }
      }
    }
    return getRestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest,
      com.google.protobuf.Empty> getAssignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Assign",
      requestType = com.common.grpc.AssignRoleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest,
      com.google.protobuf.Empty> getAssignMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest, com.google.protobuf.Empty> getAssignMethod;
    if ((getAssignMethod = RoleServiceGrpc.getAssignMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getAssignMethod = RoleServiceGrpc.getAssignMethod) == null) {
          RoleServiceGrpc.getAssignMethod = getAssignMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.AssignRoleRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Assign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.AssignRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("Assign"))
              .build();
        }
      }
    }
    return getAssignMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest,
      com.google.protobuf.Empty> getRemoveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Remove",
      requestType = com.common.grpc.AssignRoleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest,
      com.google.protobuf.Empty> getRemoveMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest, com.google.protobuf.Empty> getRemoveMethod;
    if ((getRemoveMethod = RoleServiceGrpc.getRemoveMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getRemoveMethod = RoleServiceGrpc.getRemoveMethod) == null) {
          RoleServiceGrpc.getRemoveMethod = getRemoveMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.AssignRoleRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Remove"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.AssignRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("Remove"))
              .build();
        }
      }
    }
    return getRemoveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest,
      com.common.grpc.PageRole> getListUserRolesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUserRoles",
      requestType = com.common.grpc.AssignRoleRequest.class,
      responseType = com.common.grpc.PageRole.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest,
      com.common.grpc.PageRole> getListUserRolesMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.AssignRoleRequest, com.common.grpc.PageRole> getListUserRolesMethod;
    if ((getListUserRolesMethod = RoleServiceGrpc.getListUserRolesMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getListUserRolesMethod = RoleServiceGrpc.getListUserRolesMethod) == null) {
          RoleServiceGrpc.getListUserRolesMethod = getListUserRolesMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.AssignRoleRequest, com.common.grpc.PageRole>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUserRoles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.AssignRoleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageRole.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("ListUserRoles"))
              .build();
        }
      }
    }
    return getListUserRolesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.RoleName,
      com.common.grpc.PageUser> getListUsersByRoleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListUsersByRole",
      requestType = com.common.grpc.RoleName.class,
      responseType = com.common.grpc.PageUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.RoleName,
      com.common.grpc.PageUser> getListUsersByRoleMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.RoleName, com.common.grpc.PageUser> getListUsersByRoleMethod;
    if ((getListUsersByRoleMethod = RoleServiceGrpc.getListUsersByRoleMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getListUsersByRoleMethod = RoleServiceGrpc.getListUsersByRoleMethod) == null) {
          RoleServiceGrpc.getListUsersByRoleMethod = getListUsersByRoleMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.RoleName, com.common.grpc.PageUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListUsersByRole"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.RoleName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageUser.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("ListUsersByRole"))
              .build();
        }
      }
    }
    return getListUsersByRoleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.PageRequest,
      com.common.grpc.PageRole> getListAllMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAll",
      requestType = com.common.grpc.PageRequest.class,
      responseType = com.common.grpc.PageRole.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.PageRequest,
      com.common.grpc.PageRole> getListAllMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.PageRequest, com.common.grpc.PageRole> getListAllMethod;
    if ((getListAllMethod = RoleServiceGrpc.getListAllMethod) == null) {
      synchronized (RoleServiceGrpc.class) {
        if ((getListAllMethod = RoleServiceGrpc.getListAllMethod) == null) {
          RoleServiceGrpc.getListAllMethod = getListAllMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.PageRequest, com.common.grpc.PageRole>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAll"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageRole.getDefaultInstance()))
              .setSchemaDescriptor(new RoleServiceMethodDescriptorSupplier("ListAll"))
              .build();
        }
      }
    }
    return getListAllMethod;
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
    default void create(com.common.grpc.CreateRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     */
    default void softDelete(com.common.grpc.RoleName request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSoftDeleteMethod(), responseObserver);
    }

    /**
     */
    default void restore(com.common.grpc.RoleName request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestoreMethod(), responseObserver);
    }

    /**
     */
    default void assign(com.common.grpc.AssignRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAssignMethod(), responseObserver);
    }

    /**
     */
    default void remove(com.common.grpc.AssignRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveMethod(), responseObserver);
    }

    /**
     * <pre>
     * use user_id, ignore role_name
     * </pre>
     */
    default void listUserRoles(com.common.grpc.AssignRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageRole> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUserRolesMethod(), responseObserver);
    }

    /**
     */
    default void listUsersByRole(com.common.grpc.RoleName request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageUser> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListUsersByRoleMethod(), responseObserver);
    }

    /**
     */
    default void listAll(com.common.grpc.PageRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageRole> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAllMethod(), responseObserver);
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
    public void create(com.common.grpc.CreateRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void softDelete(com.common.grpc.RoleName request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSoftDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void restore(com.common.grpc.RoleName request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void assign(com.common.grpc.AssignRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAssignMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void remove(com.common.grpc.AssignRoleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * use user_id, ignore role_name
     * </pre>
     */
    public void listUserRoles(com.common.grpc.AssignRoleRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageRole> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUserRolesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listUsersByRole(com.common.grpc.RoleName request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageUser> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListUsersByRoleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listAll(com.common.grpc.PageRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageRole> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAllMethod(), getCallOptions()), request, responseObserver);
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
    public com.google.protobuf.Empty create(com.common.grpc.CreateRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty softDelete(com.common.grpc.RoleName request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSoftDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty restore(com.common.grpc.RoleName request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty assign(com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty remove(com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * use user_id, ignore role_name
     * </pre>
     */
    public com.common.grpc.PageRole listUserRoles(com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserRolesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageUser listUsersByRole(com.common.grpc.RoleName request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsersByRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageRole listAll(com.common.grpc.PageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllMethod(), getCallOptions(), request);
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
    public com.google.protobuf.Empty create(com.common.grpc.CreateRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty softDelete(com.common.grpc.RoleName request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSoftDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty restore(com.common.grpc.RoleName request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestoreMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty assign(com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty remove(com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * use user_id, ignore role_name
     * </pre>
     */
    public com.common.grpc.PageRole listUserRoles(com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUserRolesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageUser listUsersByRole(com.common.grpc.RoleName request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListUsersByRoleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageRole listAll(com.common.grpc.PageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> create(
        com.common.grpc.CreateRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> softDelete(
        com.common.grpc.RoleName request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSoftDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> restore(
        com.common.grpc.RoleName request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestoreMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> assign(
        com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAssignMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> remove(
        com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * use user_id, ignore role_name
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.PageRole> listUserRoles(
        com.common.grpc.AssignRoleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUserRolesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.PageUser> listUsersByRole(
        com.common.grpc.RoleName request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListUsersByRoleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.PageRole> listAll(
        com.common.grpc.PageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAllMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_SOFT_DELETE = 1;
  private static final int METHODID_RESTORE = 2;
  private static final int METHODID_ASSIGN = 3;
  private static final int METHODID_REMOVE = 4;
  private static final int METHODID_LIST_USER_ROLES = 5;
  private static final int METHODID_LIST_USERS_BY_ROLE = 6;
  private static final int METHODID_LIST_ALL = 7;

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
          serviceImpl.create((com.common.grpc.CreateRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SOFT_DELETE:
          serviceImpl.softDelete((com.common.grpc.RoleName) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RESTORE:
          serviceImpl.restore((com.common.grpc.RoleName) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ASSIGN:
          serviceImpl.assign((com.common.grpc.AssignRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REMOVE:
          serviceImpl.remove((com.common.grpc.AssignRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_USER_ROLES:
          serviceImpl.listUserRoles((com.common.grpc.AssignRoleRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.PageRole>) responseObserver);
          break;
        case METHODID_LIST_USERS_BY_ROLE:
          serviceImpl.listUsersByRole((com.common.grpc.RoleName) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.PageUser>) responseObserver);
          break;
        case METHODID_LIST_ALL:
          serviceImpl.listAll((com.common.grpc.PageRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.PageRole>) responseObserver);
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
              com.common.grpc.CreateRoleRequest,
              com.google.protobuf.Empty>(
                service, METHODID_CREATE)))
        .addMethod(
          getSoftDeleteMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.RoleName,
              com.google.protobuf.Empty>(
                service, METHODID_SOFT_DELETE)))
        .addMethod(
          getRestoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.RoleName,
              com.google.protobuf.Empty>(
                service, METHODID_RESTORE)))
        .addMethod(
          getAssignMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.AssignRoleRequest,
              com.google.protobuf.Empty>(
                service, METHODID_ASSIGN)))
        .addMethod(
          getRemoveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.AssignRoleRequest,
              com.google.protobuf.Empty>(
                service, METHODID_REMOVE)))
        .addMethod(
          getListUserRolesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.AssignRoleRequest,
              com.common.grpc.PageRole>(
                service, METHODID_LIST_USER_ROLES)))
        .addMethod(
          getListUsersByRoleMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.RoleName,
              com.common.grpc.PageUser>(
                service, METHODID_LIST_USERS_BY_ROLE)))
        .addMethod(
          getListAllMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.PageRequest,
              com.common.grpc.PageRole>(
                service, METHODID_LIST_ALL)))
        .build();
  }

  private static abstract class RoleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.RoleProto.getDescriptor();
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
              .addMethod(getCreateMethod())
              .addMethod(getSoftDeleteMethod())
              .addMethod(getRestoreMethod())
              .addMethod(getAssignMethod())
              .addMethod(getRemoveMethod())
              .addMethod(getListUserRolesMethod())
              .addMethod(getListUsersByRoleMethod())
              .addMethod(getListAllMethod())
              .build();
        }
      }
    }
    return result;
  }
}
