package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: business/category.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CategoryServiceGrpc {

  private CategoryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "onlineshopping.v1.CategoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CategoryCreateRequest,
      com.google.protobuf.Empty> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = com.common.grpc.CategoryCreateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CategoryCreateRequest,
      com.google.protobuf.Empty> getCreateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CategoryCreateRequest, com.google.protobuf.Empty> getCreateMethod;
    if ((getCreateMethod = CategoryServiceGrpc.getCreateMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getCreateMethod = CategoryServiceGrpc.getCreateMethod) == null) {
          CategoryServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CategoryCreateRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CategoryCreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CategoryUpdateRequest,
      com.google.protobuf.Empty> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.common.grpc.CategoryUpdateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CategoryUpdateRequest,
      com.google.protobuf.Empty> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CategoryUpdateRequest, com.google.protobuf.Empty> getUpdateMethod;
    if ((getUpdateMethod = CategoryServiceGrpc.getUpdateMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getUpdateMethod = CategoryServiceGrpc.getUpdateMethod) == null) {
          CategoryServiceGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CategoryUpdateRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CategoryUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("Update"))
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
    if ((getSoftDeleteMethod = CategoryServiceGrpc.getSoftDeleteMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getSoftDeleteMethod = CategoryServiceGrpc.getSoftDeleteMethod) == null) {
          CategoryServiceGrpc.getSoftDeleteMethod = getSoftDeleteMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SoftDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("SoftDelete"))
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
    if ((getRestoreMethod = CategoryServiceGrpc.getRestoreMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getRestoreMethod = CategoryServiceGrpc.getRestoreMethod) == null) {
          CategoryServiceGrpc.getRestoreMethod = getRestoreMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Restore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("Restore"))
              .build();
        }
      }
    }
    return getRestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CategoryReparentRequest,
      com.google.protobuf.Empty> getReparentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Reparent",
      requestType = com.common.grpc.CategoryReparentRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CategoryReparentRequest,
      com.google.protobuf.Empty> getReparentMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CategoryReparentRequest, com.google.protobuf.Empty> getReparentMethod;
    if ((getReparentMethod = CategoryServiceGrpc.getReparentMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getReparentMethod = CategoryServiceGrpc.getReparentMethod) == null) {
          CategoryServiceGrpc.getReparentMethod = getReparentMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CategoryReparentRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Reparent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CategoryReparentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("Reparent"))
              .build();
        }
      }
    }
    return getReparentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.IdRequest,
      com.common.grpc.CategoryView> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = com.common.grpc.IdRequest.class,
      responseType = com.common.grpc.CategoryView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.IdRequest,
      com.common.grpc.CategoryView> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.IdRequest, com.common.grpc.CategoryView> getGetByIdMethod;
    if ((getGetByIdMethod = CategoryServiceGrpc.getGetByIdMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getGetByIdMethod = CategoryServiceGrpc.getGetByIdMethod) == null) {
          CategoryServiceGrpc.getGetByIdMethod = getGetByIdMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.common.grpc.CategoryView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CategoryView.getDefaultInstance()))
              .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("GetById"))
              .build();
        }
      }
    }
    return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.SlugRequest,
      com.common.grpc.CategoryView> getGetBySlugMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBySlug",
      requestType = com.common.grpc.SlugRequest.class,
      responseType = com.common.grpc.CategoryView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.SlugRequest,
      com.common.grpc.CategoryView> getGetBySlugMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.SlugRequest, com.common.grpc.CategoryView> getGetBySlugMethod;
    if ((getGetBySlugMethod = CategoryServiceGrpc.getGetBySlugMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getGetBySlugMethod = CategoryServiceGrpc.getGetBySlugMethod) == null) {
          CategoryServiceGrpc.getGetBySlugMethod = getGetBySlugMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.SlugRequest, com.common.grpc.CategoryView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBySlug"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.SlugRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CategoryView.getDefaultInstance()))
              .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("GetBySlug"))
              .build();
        }
      }
    }
    return getGetBySlugMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CategoryListRequest,
      com.common.grpc.PageCategory> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.common.grpc.CategoryListRequest.class,
      responseType = com.common.grpc.PageCategory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CategoryListRequest,
      com.common.grpc.PageCategory> getListMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CategoryListRequest, com.common.grpc.PageCategory> getListMethod;
    if ((getListMethod = CategoryServiceGrpc.getListMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getListMethod = CategoryServiceGrpc.getListMethod) == null) {
          CategoryServiceGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CategoryListRequest, com.common.grpc.PageCategory>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CategoryListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageCategory.getDefaultInstance()))
              .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("List"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.common.grpc.CategoryTreeNode> getTreeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Tree",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.common.grpc.CategoryTreeNode.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.common.grpc.CategoryTreeNode> getTreeMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.common.grpc.CategoryTreeNode> getTreeMethod;
    if ((getTreeMethod = CategoryServiceGrpc.getTreeMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getTreeMethod = CategoryServiceGrpc.getTreeMethod) == null) {
          CategoryServiceGrpc.getTreeMethod = getTreeMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.common.grpc.CategoryTreeNode>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Tree"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CategoryTreeNode.getDefaultInstance()))
              .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("Tree"))
              .build();
        }
      }
    }
    return getTreeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.CategoryChildrenRequest,
      com.common.grpc.PageCategory> getChildrenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Children",
      requestType = com.common.grpc.CategoryChildrenRequest.class,
      responseType = com.common.grpc.PageCategory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.CategoryChildrenRequest,
      com.common.grpc.PageCategory> getChildrenMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.CategoryChildrenRequest, com.common.grpc.PageCategory> getChildrenMethod;
    if ((getChildrenMethod = CategoryServiceGrpc.getChildrenMethod) == null) {
      synchronized (CategoryServiceGrpc.class) {
        if ((getChildrenMethod = CategoryServiceGrpc.getChildrenMethod) == null) {
          CategoryServiceGrpc.getChildrenMethod = getChildrenMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.CategoryChildrenRequest, com.common.grpc.PageCategory>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Children"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.CategoryChildrenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageCategory.getDefaultInstance()))
              .setSchemaDescriptor(new CategoryServiceMethodDescriptorSupplier("Children"))
              .build();
        }
      }
    }
    return getChildrenMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CategoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CategoryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CategoryServiceStub>() {
        @java.lang.Override
        public CategoryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CategoryServiceStub(channel, callOptions);
        }
      };
    return CategoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static CategoryServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CategoryServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CategoryServiceBlockingV2Stub>() {
        @java.lang.Override
        public CategoryServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CategoryServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return CategoryServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CategoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CategoryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CategoryServiceBlockingStub>() {
        @java.lang.Override
        public CategoryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CategoryServiceBlockingStub(channel, callOptions);
        }
      };
    return CategoryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CategoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CategoryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CategoryServiceFutureStub>() {
        @java.lang.Override
        public CategoryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CategoryServiceFutureStub(channel, callOptions);
        }
      };
    return CategoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void create(com.common.grpc.CategoryCreateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     */
    default void update(com.common.grpc.CategoryUpdateRequest request,
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
    default void reparent(com.common.grpc.CategoryReparentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReparentMethod(), responseObserver);
    }

    /**
     */
    default void getById(com.common.grpc.IdRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CategoryView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    default void getBySlug(com.common.grpc.SlugRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CategoryView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBySlugMethod(), responseObserver);
    }

    /**
     */
    default void list(com.common.grpc.CategoryListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageCategory> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     * <pre>
     * full tree
     * </pre>
     */
    default void tree(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.common.grpc.CategoryTreeNode> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTreeMethod(), responseObserver);
    }

    /**
     * <pre>
     * 1 cấp con
     * </pre>
     */
    default void children(com.common.grpc.CategoryChildrenRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageCategory> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getChildrenMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CategoryService.
   */
  public static abstract class CategoryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CategoryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CategoryService.
   */
  public static final class CategoryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CategoryServiceStub> {
    private CategoryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CategoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void create(com.common.grpc.CategoryCreateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.common.grpc.CategoryUpdateRequest request,
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
    public void reparent(com.common.grpc.CategoryReparentRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReparentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getById(com.common.grpc.IdRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CategoryView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBySlug(com.common.grpc.SlugRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.CategoryView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBySlugMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void list(com.common.grpc.CategoryListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageCategory> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * full tree
     * </pre>
     */
    public void tree(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.common.grpc.CategoryTreeNode> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTreeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 1 cấp con
     * </pre>
     */
    public void children(com.common.grpc.CategoryChildrenRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageCategory> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getChildrenMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CategoryService.
   */
  public static final class CategoryServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CategoryServiceBlockingV2Stub> {
    private CategoryServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CategoryServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty create(com.common.grpc.CategoryCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty update(com.common.grpc.CategoryUpdateRequest request) {
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
    public com.google.protobuf.Empty reparent(com.common.grpc.CategoryReparentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReparentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.CategoryView getById(com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.CategoryView getBySlug(com.common.grpc.SlugRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBySlugMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageCategory list(com.common.grpc.CategoryListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * full tree
     * </pre>
     */
    public com.common.grpc.CategoryTreeNode tree(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTreeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 1 cấp con
     * </pre>
     */
    public com.common.grpc.PageCategory children(com.common.grpc.CategoryChildrenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChildrenMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CategoryService.
   */
  public static final class CategoryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CategoryServiceBlockingStub> {
    private CategoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CategoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty create(com.common.grpc.CategoryCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty update(com.common.grpc.CategoryUpdateRequest request) {
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
    public com.google.protobuf.Empty reparent(com.common.grpc.CategoryReparentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReparentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.CategoryView getById(com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.CategoryView getBySlug(com.common.grpc.SlugRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBySlugMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageCategory list(com.common.grpc.CategoryListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * full tree
     * </pre>
     */
    public com.common.grpc.CategoryTreeNode tree(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTreeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 1 cấp con
     * </pre>
     */
    public com.common.grpc.PageCategory children(com.common.grpc.CategoryChildrenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getChildrenMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CategoryService.
   */
  public static final class CategoryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CategoryServiceFutureStub> {
    private CategoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CategoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CategoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> create(
        com.common.grpc.CategoryCreateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> update(
        com.common.grpc.CategoryUpdateRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> reparent(
        com.common.grpc.CategoryReparentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReparentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.CategoryView> getById(
        com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.CategoryView> getBySlug(
        com.common.grpc.SlugRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBySlugMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.PageCategory> list(
        com.common.grpc.CategoryListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * full tree
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.CategoryTreeNode> tree(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTreeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 1 cấp con
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.PageCategory> children(
        com.common.grpc.CategoryChildrenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getChildrenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_UPDATE = 1;
  private static final int METHODID_SOFT_DELETE = 2;
  private static final int METHODID_RESTORE = 3;
  private static final int METHODID_REPARENT = 4;
  private static final int METHODID_GET_BY_ID = 5;
  private static final int METHODID_GET_BY_SLUG = 6;
  private static final int METHODID_LIST = 7;
  private static final int METHODID_TREE = 8;
  private static final int METHODID_CHILDREN = 9;

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
          serviceImpl.create((com.common.grpc.CategoryCreateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.common.grpc.CategoryUpdateRequest) request,
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
        case METHODID_REPARENT:
          serviceImpl.reparent((com.common.grpc.CategoryReparentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.common.grpc.IdRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.CategoryView>) responseObserver);
          break;
        case METHODID_GET_BY_SLUG:
          serviceImpl.getBySlug((com.common.grpc.SlugRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.CategoryView>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list((com.common.grpc.CategoryListRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.PageCategory>) responseObserver);
          break;
        case METHODID_TREE:
          serviceImpl.tree((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.CategoryTreeNode>) responseObserver);
          break;
        case METHODID_CHILDREN:
          serviceImpl.children((com.common.grpc.CategoryChildrenRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.PageCategory>) responseObserver);
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
              com.common.grpc.CategoryCreateRequest,
              com.google.protobuf.Empty>(
                service, METHODID_CREATE)))
        .addMethod(
          getUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CategoryUpdateRequest,
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
          getReparentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CategoryReparentRequest,
              com.google.protobuf.Empty>(
                service, METHODID_REPARENT)))
        .addMethod(
          getGetByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.IdRequest,
              com.common.grpc.CategoryView>(
                service, METHODID_GET_BY_ID)))
        .addMethod(
          getGetBySlugMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.SlugRequest,
              com.common.grpc.CategoryView>(
                service, METHODID_GET_BY_SLUG)))
        .addMethod(
          getListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CategoryListRequest,
              com.common.grpc.PageCategory>(
                service, METHODID_LIST)))
        .addMethod(
          getTreeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              com.common.grpc.CategoryTreeNode>(
                service, METHODID_TREE)))
        .addMethod(
          getChildrenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.CategoryChildrenRequest,
              com.common.grpc.PageCategory>(
                service, METHODID_CHILDREN)))
        .build();
  }

  private static abstract class CategoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CategoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.CategoryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CategoryService");
    }
  }

  private static final class CategoryServiceFileDescriptorSupplier
      extends CategoryServiceBaseDescriptorSupplier {
    CategoryServiceFileDescriptorSupplier() {}
  }

  private static final class CategoryServiceMethodDescriptorSupplier
      extends CategoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CategoryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CategoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CategoryServiceFileDescriptorSupplier())
              .addMethod(getCreateMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getSoftDeleteMethod())
              .addMethod(getRestoreMethod())
              .addMethod(getReparentMethod())
              .addMethod(getGetByIdMethod())
              .addMethod(getGetBySlugMethod())
              .addMethod(getListMethod())
              .addMethod(getTreeMethod())
              .addMethod(getChildrenMethod())
              .build();
        }
      }
    }
    return result;
  }
}
