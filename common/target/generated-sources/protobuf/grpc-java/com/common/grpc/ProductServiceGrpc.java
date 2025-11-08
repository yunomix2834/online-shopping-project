package com.common.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.72.0)",
    comments = "Source: business/product.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductServiceGrpc {

  private ProductServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "onlineshopping.v1.ProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.common.grpc.ProductCreateRequest,
      com.google.protobuf.Empty> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = com.common.grpc.ProductCreateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.ProductCreateRequest,
      com.google.protobuf.Empty> getCreateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.ProductCreateRequest, com.google.protobuf.Empty> getCreateMethod;
    if ((getCreateMethod = ProductServiceGrpc.getCreateMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getCreateMethod = ProductServiceGrpc.getCreateMethod) == null) {
          ProductServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.ProductCreateRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ProductCreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.ProductUpdateRequest,
      com.google.protobuf.Empty> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.common.grpc.ProductUpdateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.ProductUpdateRequest,
      com.google.protobuf.Empty> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.ProductUpdateRequest, com.google.protobuf.Empty> getUpdateMethod;
    if ((getUpdateMethod = ProductServiceGrpc.getUpdateMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getUpdateMethod = ProductServiceGrpc.getUpdateMethod) == null) {
          ProductServiceGrpc.getUpdateMethod = getUpdateMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.ProductUpdateRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ProductUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("Update"))
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
    if ((getSoftDeleteMethod = ProductServiceGrpc.getSoftDeleteMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getSoftDeleteMethod = ProductServiceGrpc.getSoftDeleteMethod) == null) {
          ProductServiceGrpc.getSoftDeleteMethod = getSoftDeleteMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SoftDelete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("SoftDelete"))
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
    if ((getRestoreMethod = ProductServiceGrpc.getRestoreMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getRestoreMethod = ProductServiceGrpc.getRestoreMethod) == null) {
          ProductServiceGrpc.getRestoreMethod = getRestoreMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Restore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("Restore"))
              .build();
        }
      }
    }
    return getRestoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.PublishRequest,
      com.google.protobuf.Empty> getPublishMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Publish",
      requestType = com.common.grpc.PublishRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.PublishRequest,
      com.google.protobuf.Empty> getPublishMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.PublishRequest, com.google.protobuf.Empty> getPublishMethod;
    if ((getPublishMethod = ProductServiceGrpc.getPublishMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getPublishMethod = ProductServiceGrpc.getPublishMethod) == null) {
          ProductServiceGrpc.getPublishMethod = getPublishMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.PublishRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Publish"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PublishRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("Publish"))
              .build();
        }
      }
    }
    return getPublishMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.UnpublishRequest,
      com.google.protobuf.Empty> getUnpublishMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Unpublish",
      requestType = com.common.grpc.UnpublishRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.UnpublishRequest,
      com.google.protobuf.Empty> getUnpublishMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.UnpublishRequest, com.google.protobuf.Empty> getUnpublishMethod;
    if ((getUnpublishMethod = ProductServiceGrpc.getUnpublishMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getUnpublishMethod = ProductServiceGrpc.getUnpublishMethod) == null) {
          ProductServiceGrpc.getUnpublishMethod = getUnpublishMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.UnpublishRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Unpublish"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.UnpublishRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("Unpublish"))
              .build();
        }
      }
    }
    return getUnpublishMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.ArchiveRequest,
      com.google.protobuf.Empty> getArchiveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Archive",
      requestType = com.common.grpc.ArchiveRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.ArchiveRequest,
      com.google.protobuf.Empty> getArchiveMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.ArchiveRequest, com.google.protobuf.Empty> getArchiveMethod;
    if ((getArchiveMethod = ProductServiceGrpc.getArchiveMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getArchiveMethod = ProductServiceGrpc.getArchiveMethod) == null) {
          ProductServiceGrpc.getArchiveMethod = getArchiveMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.ArchiveRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Archive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ArchiveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("Archive"))
              .build();
        }
      }
    }
    return getArchiveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.IdRequest,
      com.common.grpc.ProductView> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = com.common.grpc.IdRequest.class,
      responseType = com.common.grpc.ProductView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.IdRequest,
      com.common.grpc.ProductView> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.IdRequest, com.common.grpc.ProductView> getGetByIdMethod;
    if ((getGetByIdMethod = ProductServiceGrpc.getGetByIdMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getGetByIdMethod = ProductServiceGrpc.getGetByIdMethod) == null) {
          ProductServiceGrpc.getGetByIdMethod = getGetByIdMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.IdRequest, com.common.grpc.ProductView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ProductView.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("GetById"))
              .build();
        }
      }
    }
    return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.SlugRequest,
      com.common.grpc.ProductView> getGetBySlugMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBySlug",
      requestType = com.common.grpc.SlugRequest.class,
      responseType = com.common.grpc.ProductView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.SlugRequest,
      com.common.grpc.ProductView> getGetBySlugMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.SlugRequest, com.common.grpc.ProductView> getGetBySlugMethod;
    if ((getGetBySlugMethod = ProductServiceGrpc.getGetBySlugMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getGetBySlugMethod = ProductServiceGrpc.getGetBySlugMethod) == null) {
          ProductServiceGrpc.getGetBySlugMethod = getGetBySlugMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.SlugRequest, com.common.grpc.ProductView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBySlug"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.SlugRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ProductView.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("GetBySlug"))
              .build();
        }
      }
    }
    return getGetBySlugMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.ProductListRequest,
      com.common.grpc.PageProduct> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "List",
      requestType = com.common.grpc.ProductListRequest.class,
      responseType = com.common.grpc.PageProduct.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.ProductListRequest,
      com.common.grpc.PageProduct> getListMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.ProductListRequest, com.common.grpc.PageProduct> getListMethod;
    if ((getListMethod = ProductServiceGrpc.getListMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getListMethod = ProductServiceGrpc.getListMethod) == null) {
          ProductServiceGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.ProductListRequest, com.common.grpc.PageProduct>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "List"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.ProductListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.PageProduct.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("List"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.AssignCategoryRequest,
      com.google.protobuf.Empty> getAssignCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AssignCategory",
      requestType = com.common.grpc.AssignCategoryRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.AssignCategoryRequest,
      com.google.protobuf.Empty> getAssignCategoryMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.AssignCategoryRequest, com.google.protobuf.Empty> getAssignCategoryMethod;
    if ((getAssignCategoryMethod = ProductServiceGrpc.getAssignCategoryMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getAssignCategoryMethod = ProductServiceGrpc.getAssignCategoryMethod) == null) {
          ProductServiceGrpc.getAssignCategoryMethod = getAssignCategoryMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.AssignCategoryRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AssignCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.AssignCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("AssignCategory"))
              .build();
        }
      }
    }
    return getAssignCategoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.common.grpc.UnassignCategoryRequest,
      com.google.protobuf.Empty> getUnassignCategoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnassignCategory",
      requestType = com.common.grpc.UnassignCategoryRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.common.grpc.UnassignCategoryRequest,
      com.google.protobuf.Empty> getUnassignCategoryMethod() {
    io.grpc.MethodDescriptor<com.common.grpc.UnassignCategoryRequest, com.google.protobuf.Empty> getUnassignCategoryMethod;
    if ((getUnassignCategoryMethod = ProductServiceGrpc.getUnassignCategoryMethod) == null) {
      synchronized (ProductServiceGrpc.class) {
        if ((getUnassignCategoryMethod = ProductServiceGrpc.getUnassignCategoryMethod) == null) {
          ProductServiceGrpc.getUnassignCategoryMethod = getUnassignCategoryMethod =
              io.grpc.MethodDescriptor.<com.common.grpc.UnassignCategoryRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UnassignCategory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.common.grpc.UnassignCategoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new ProductServiceMethodDescriptorSupplier("UnassignCategory"))
              .build();
        }
      }
    }
    return getUnassignCategoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceStub>() {
        @java.lang.Override
        public ProductServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceStub(channel, callOptions);
        }
      };
    return ProductServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static ProductServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingV2Stub>() {
        @java.lang.Override
        public ProductServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return ProductServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceBlockingStub>() {
        @java.lang.Override
        public ProductServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductServiceFutureStub>() {
        @java.lang.Override
        public ProductServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductServiceFutureStub(channel, callOptions);
        }
      };
    return ProductServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void create(com.common.grpc.ProductCreateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     */
    default void update(com.common.grpc.ProductUpdateRequest request,
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
    default void publish(com.common.grpc.PublishRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPublishMethod(), responseObserver);
    }

    /**
     */
    default void unpublish(com.common.grpc.UnpublishRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnpublishMethod(), responseObserver);
    }

    /**
     */
    default void archive(com.common.grpc.ArchiveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getArchiveMethod(), responseObserver);
    }

    /**
     */
    default void getById(com.common.grpc.IdRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ProductView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    default void getBySlug(com.common.grpc.SlugRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ProductView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBySlugMethod(), responseObserver);
    }

    /**
     */
    default void list(com.common.grpc.ProductListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageProduct> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     */
    default void assignCategory(com.common.grpc.AssignCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAssignCategoryMethod(), responseObserver);
    }

    /**
     */
    default void unassignCategory(com.common.grpc.UnassignCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnassignCategoryMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProductService.
   */
  public static abstract class ProductServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ProductServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProductService.
   */
  public static final class ProductServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProductServiceStub> {
    private ProductServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceStub(channel, callOptions);
    }

    /**
     */
    public void create(com.common.grpc.ProductCreateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.common.grpc.ProductUpdateRequest request,
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
    public void publish(com.common.grpc.PublishRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPublishMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unpublish(com.common.grpc.UnpublishRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnpublishMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void archive(com.common.grpc.ArchiveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getArchiveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getById(com.common.grpc.IdRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ProductView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBySlug(com.common.grpc.SlugRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.ProductView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBySlugMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void list(com.common.grpc.ProductListRequest request,
        io.grpc.stub.StreamObserver<com.common.grpc.PageProduct> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void assignCategory(com.common.grpc.AssignCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAssignCategoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unassignCategory(com.common.grpc.UnassignCategoryRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnassignCategoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProductService.
   */
  public static final class ProductServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ProductServiceBlockingV2Stub> {
    private ProductServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty create(com.common.grpc.ProductCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty update(com.common.grpc.ProductUpdateRequest request) {
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
    public com.google.protobuf.Empty publish(com.common.grpc.PublishRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPublishMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty unpublish(com.common.grpc.UnpublishRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnpublishMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty archive(com.common.grpc.ArchiveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getArchiveMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ProductView getById(com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ProductView getBySlug(com.common.grpc.SlugRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBySlugMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageProduct list(com.common.grpc.ProductListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty assignCategory(com.common.grpc.AssignCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty unassignCategory(com.common.grpc.UnassignCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnassignCategoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ProductService.
   */
  public static final class ProductServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProductServiceBlockingStub> {
    private ProductServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty create(com.common.grpc.ProductCreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty update(com.common.grpc.ProductUpdateRequest request) {
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
    public com.google.protobuf.Empty publish(com.common.grpc.PublishRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPublishMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty unpublish(com.common.grpc.UnpublishRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnpublishMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty archive(com.common.grpc.ArchiveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getArchiveMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ProductView getById(com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.ProductView getBySlug(com.common.grpc.SlugRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBySlugMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.common.grpc.PageProduct list(com.common.grpc.ProductListRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty assignCategory(com.common.grpc.AssignCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAssignCategoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty unassignCategory(com.common.grpc.UnassignCategoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnassignCategoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProductService.
   */
  public static final class ProductServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProductServiceFutureStub> {
    private ProductServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> create(
        com.common.grpc.ProductCreateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> update(
        com.common.grpc.ProductUpdateRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> publish(
        com.common.grpc.PublishRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPublishMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> unpublish(
        com.common.grpc.UnpublishRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnpublishMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> archive(
        com.common.grpc.ArchiveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getArchiveMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.ProductView> getById(
        com.common.grpc.IdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.ProductView> getBySlug(
        com.common.grpc.SlugRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBySlugMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.common.grpc.PageProduct> list(
        com.common.grpc.ProductListRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> assignCategory(
        com.common.grpc.AssignCategoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAssignCategoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> unassignCategory(
        com.common.grpc.UnassignCategoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnassignCategoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_UPDATE = 1;
  private static final int METHODID_SOFT_DELETE = 2;
  private static final int METHODID_RESTORE = 3;
  private static final int METHODID_PUBLISH = 4;
  private static final int METHODID_UNPUBLISH = 5;
  private static final int METHODID_ARCHIVE = 6;
  private static final int METHODID_GET_BY_ID = 7;
  private static final int METHODID_GET_BY_SLUG = 8;
  private static final int METHODID_LIST = 9;
  private static final int METHODID_ASSIGN_CATEGORY = 10;
  private static final int METHODID_UNASSIGN_CATEGORY = 11;

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
          serviceImpl.create((com.common.grpc.ProductCreateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.common.grpc.ProductUpdateRequest) request,
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
        case METHODID_PUBLISH:
          serviceImpl.publish((com.common.grpc.PublishRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UNPUBLISH:
          serviceImpl.unpublish((com.common.grpc.UnpublishRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ARCHIVE:
          serviceImpl.archive((com.common.grpc.ArchiveRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.common.grpc.IdRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.ProductView>) responseObserver);
          break;
        case METHODID_GET_BY_SLUG:
          serviceImpl.getBySlug((com.common.grpc.SlugRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.ProductView>) responseObserver);
          break;
        case METHODID_LIST:
          serviceImpl.list((com.common.grpc.ProductListRequest) request,
              (io.grpc.stub.StreamObserver<com.common.grpc.PageProduct>) responseObserver);
          break;
        case METHODID_ASSIGN_CATEGORY:
          serviceImpl.assignCategory((com.common.grpc.AssignCategoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UNASSIGN_CATEGORY:
          serviceImpl.unassignCategory((com.common.grpc.UnassignCategoryRequest) request,
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
          getCreateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.ProductCreateRequest,
              com.google.protobuf.Empty>(
                service, METHODID_CREATE)))
        .addMethod(
          getUpdateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.ProductUpdateRequest,
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
          getPublishMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.PublishRequest,
              com.google.protobuf.Empty>(
                service, METHODID_PUBLISH)))
        .addMethod(
          getUnpublishMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.UnpublishRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UNPUBLISH)))
        .addMethod(
          getArchiveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.ArchiveRequest,
              com.google.protobuf.Empty>(
                service, METHODID_ARCHIVE)))
        .addMethod(
          getGetByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.IdRequest,
              com.common.grpc.ProductView>(
                service, METHODID_GET_BY_ID)))
        .addMethod(
          getGetBySlugMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.SlugRequest,
              com.common.grpc.ProductView>(
                service, METHODID_GET_BY_SLUG)))
        .addMethod(
          getListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.ProductListRequest,
              com.common.grpc.PageProduct>(
                service, METHODID_LIST)))
        .addMethod(
          getAssignCategoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.AssignCategoryRequest,
              com.google.protobuf.Empty>(
                service, METHODID_ASSIGN_CATEGORY)))
        .addMethod(
          getUnassignCategoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.common.grpc.UnassignCategoryRequest,
              com.google.protobuf.Empty>(
                service, METHODID_UNASSIGN_CATEGORY)))
        .build();
  }

  private static abstract class ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.common.grpc.ProductProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductService");
    }
  }

  private static final class ProductServiceFileDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier {
    ProductServiceFileDescriptorSupplier() {}
  }

  private static final class ProductServiceMethodDescriptorSupplier
      extends ProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProductServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductServiceFileDescriptorSupplier())
              .addMethod(getCreateMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getSoftDeleteMethod())
              .addMethod(getRestoreMethod())
              .addMethod(getPublishMethod())
              .addMethod(getUnpublishMethod())
              .addMethod(getArchiveMethod())
              .addMethod(getGetByIdMethod())
              .addMethod(getGetBySlugMethod())
              .addMethod(getListMethod())
              .addMethod(getAssignCategoryMethod())
              .addMethod(getUnassignCategoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
