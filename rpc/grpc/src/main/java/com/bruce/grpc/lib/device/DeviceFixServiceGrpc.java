package com.bruce.grpc.lib.device;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The device service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.1)",
    comments = "Source: device.proto")
public final class DeviceFixServiceGrpc {

  private DeviceFixServiceGrpc() {}

  public static final String SERVICE_NAME = "device.DeviceFixService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.deviceFix,
      com.bruce.grpc.lib.device.booleanReply> getInsertDeviceFixMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "insertDeviceFix",
      requestType = com.bruce.grpc.lib.device.deviceFix.class,
      responseType = com.bruce.grpc.lib.device.booleanReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.deviceFix,
      com.bruce.grpc.lib.device.booleanReply> getInsertDeviceFixMethod() {
    io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.deviceFix, com.bruce.grpc.lib.device.booleanReply> getInsertDeviceFixMethod;
    if ((getInsertDeviceFixMethod = DeviceFixServiceGrpc.getInsertDeviceFixMethod) == null) {
      synchronized (DeviceFixServiceGrpc.class) {
        if ((getInsertDeviceFixMethod = DeviceFixServiceGrpc.getInsertDeviceFixMethod) == null) {
          DeviceFixServiceGrpc.getInsertDeviceFixMethod = getInsertDeviceFixMethod = 
              io.grpc.MethodDescriptor.<com.bruce.grpc.lib.device.deviceFix, com.bruce.grpc.lib.device.booleanReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "device.DeviceFixService", "insertDeviceFix"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bruce.grpc.lib.device.deviceFix.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bruce.grpc.lib.device.booleanReply.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceFixServiceMethodDescriptorSupplier("insertDeviceFix"))
                  .build();
          }
        }
     }
     return getInsertDeviceFixMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.deviceFix,
      com.bruce.grpc.lib.device.booleanReply> getUpdateDeviceFixMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateDeviceFix",
      requestType = com.bruce.grpc.lib.device.deviceFix.class,
      responseType = com.bruce.grpc.lib.device.booleanReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.deviceFix,
      com.bruce.grpc.lib.device.booleanReply> getUpdateDeviceFixMethod() {
    io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.deviceFix, com.bruce.grpc.lib.device.booleanReply> getUpdateDeviceFixMethod;
    if ((getUpdateDeviceFixMethod = DeviceFixServiceGrpc.getUpdateDeviceFixMethod) == null) {
      synchronized (DeviceFixServiceGrpc.class) {
        if ((getUpdateDeviceFixMethod = DeviceFixServiceGrpc.getUpdateDeviceFixMethod) == null) {
          DeviceFixServiceGrpc.getUpdateDeviceFixMethod = getUpdateDeviceFixMethod = 
              io.grpc.MethodDescriptor.<com.bruce.grpc.lib.device.deviceFix, com.bruce.grpc.lib.device.booleanReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "device.DeviceFixService", "updateDeviceFix"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bruce.grpc.lib.device.deviceFix.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bruce.grpc.lib.device.booleanReply.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceFixServiceMethodDescriptorSupplier("updateDeviceFix"))
                  .build();
          }
        }
     }
     return getUpdateDeviceFixMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.conditionsRequest,
      com.bruce.grpc.lib.device.deviceFix> getSearchDeviceFixMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchDeviceFix",
      requestType = com.bruce.grpc.lib.device.conditionsRequest.class,
      responseType = com.bruce.grpc.lib.device.deviceFix.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.conditionsRequest,
      com.bruce.grpc.lib.device.deviceFix> getSearchDeviceFixMethod() {
    io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.conditionsRequest, com.bruce.grpc.lib.device.deviceFix> getSearchDeviceFixMethod;
    if ((getSearchDeviceFixMethod = DeviceFixServiceGrpc.getSearchDeviceFixMethod) == null) {
      synchronized (DeviceFixServiceGrpc.class) {
        if ((getSearchDeviceFixMethod = DeviceFixServiceGrpc.getSearchDeviceFixMethod) == null) {
          DeviceFixServiceGrpc.getSearchDeviceFixMethod = getSearchDeviceFixMethod = 
              io.grpc.MethodDescriptor.<com.bruce.grpc.lib.device.conditionsRequest, com.bruce.grpc.lib.device.deviceFix>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "device.DeviceFixService", "searchDeviceFix"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bruce.grpc.lib.device.conditionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bruce.grpc.lib.device.deviceFix.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceFixServiceMethodDescriptorSupplier("searchDeviceFix"))
                  .build();
          }
        }
     }
     return getSearchDeviceFixMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.conditionsRequest,
      com.bruce.grpc.lib.device.booleanReply> getDeleteDeviceFixMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteDeviceFix",
      requestType = com.bruce.grpc.lib.device.conditionsRequest.class,
      responseType = com.bruce.grpc.lib.device.booleanReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.conditionsRequest,
      com.bruce.grpc.lib.device.booleanReply> getDeleteDeviceFixMethod() {
    io.grpc.MethodDescriptor<com.bruce.grpc.lib.device.conditionsRequest, com.bruce.grpc.lib.device.booleanReply> getDeleteDeviceFixMethod;
    if ((getDeleteDeviceFixMethod = DeviceFixServiceGrpc.getDeleteDeviceFixMethod) == null) {
      synchronized (DeviceFixServiceGrpc.class) {
        if ((getDeleteDeviceFixMethod = DeviceFixServiceGrpc.getDeleteDeviceFixMethod) == null) {
          DeviceFixServiceGrpc.getDeleteDeviceFixMethod = getDeleteDeviceFixMethod = 
              io.grpc.MethodDescriptor.<com.bruce.grpc.lib.device.conditionsRequest, com.bruce.grpc.lib.device.booleanReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "device.DeviceFixService", "deleteDeviceFix"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bruce.grpc.lib.device.conditionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.bruce.grpc.lib.device.booleanReply.getDefaultInstance()))
                  .setSchemaDescriptor(new DeviceFixServiceMethodDescriptorSupplier("deleteDeviceFix"))
                  .build();
          }
        }
     }
     return getDeleteDeviceFixMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DeviceFixServiceStub newStub(io.grpc.Channel channel) {
    return new DeviceFixServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DeviceFixServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DeviceFixServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DeviceFixServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DeviceFixServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The device service definition.
   * </pre>
   */
  public static abstract class DeviceFixServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public void insertDeviceFix(com.bruce.grpc.lib.device.deviceFix request,
        io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.booleanReply> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertDeviceFixMethod(), responseObserver);
    }

    /**
     */
    public void updateDeviceFix(com.bruce.grpc.lib.device.deviceFix request,
        io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.booleanReply> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateDeviceFixMethod(), responseObserver);
    }

    /**
     */
    public void searchDeviceFix(com.bruce.grpc.lib.device.conditionsRequest request,
        io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.deviceFix> responseObserver) {
      asyncUnimplementedUnaryCall(getSearchDeviceFixMethod(), responseObserver);
    }

    /**
     */
    public void deleteDeviceFix(com.bruce.grpc.lib.device.conditionsRequest request,
        io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.booleanReply> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteDeviceFixMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInsertDeviceFixMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.bruce.grpc.lib.device.deviceFix,
                com.bruce.grpc.lib.device.booleanReply>(
                  this, METHODID_INSERT_DEVICE_FIX)))
          .addMethod(
            getUpdateDeviceFixMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.bruce.grpc.lib.device.deviceFix,
                com.bruce.grpc.lib.device.booleanReply>(
                  this, METHODID_UPDATE_DEVICE_FIX)))
          .addMethod(
            getSearchDeviceFixMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.bruce.grpc.lib.device.conditionsRequest,
                com.bruce.grpc.lib.device.deviceFix>(
                  this, METHODID_SEARCH_DEVICE_FIX)))
          .addMethod(
            getDeleteDeviceFixMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.bruce.grpc.lib.device.conditionsRequest,
                com.bruce.grpc.lib.device.booleanReply>(
                  this, METHODID_DELETE_DEVICE_FIX)))
          .build();
    }
  }

  /**
   * <pre>
   * The device service definition.
   * </pre>
   */
  public static final class DeviceFixServiceStub extends io.grpc.stub.AbstractStub<DeviceFixServiceStub> {
    private DeviceFixServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeviceFixServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceFixServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeviceFixServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public void insertDeviceFix(com.bruce.grpc.lib.device.deviceFix request,
        io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.booleanReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertDeviceFixMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateDeviceFix(com.bruce.grpc.lib.device.deviceFix request,
        io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.booleanReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateDeviceFixMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchDeviceFix(com.bruce.grpc.lib.device.conditionsRequest request,
        io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.deviceFix> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSearchDeviceFixMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteDeviceFix(com.bruce.grpc.lib.device.conditionsRequest request,
        io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.booleanReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteDeviceFixMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The device service definition.
   * </pre>
   */
  public static final class DeviceFixServiceBlockingStub extends io.grpc.stub.AbstractStub<DeviceFixServiceBlockingStub> {
    private DeviceFixServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeviceFixServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceFixServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeviceFixServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public com.bruce.grpc.lib.device.booleanReply insertDeviceFix(com.bruce.grpc.lib.device.deviceFix request) {
      return blockingUnaryCall(
          getChannel(), getInsertDeviceFixMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.bruce.grpc.lib.device.booleanReply updateDeviceFix(com.bruce.grpc.lib.device.deviceFix request) {
      return blockingUnaryCall(
          getChannel(), getUpdateDeviceFixMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.bruce.grpc.lib.device.deviceFix searchDeviceFix(com.bruce.grpc.lib.device.conditionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getSearchDeviceFixMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.bruce.grpc.lib.device.booleanReply deleteDeviceFix(com.bruce.grpc.lib.device.conditionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteDeviceFixMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The device service definition.
   * </pre>
   */
  public static final class DeviceFixServiceFutureStub extends io.grpc.stub.AbstractStub<DeviceFixServiceFutureStub> {
    private DeviceFixServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DeviceFixServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DeviceFixServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DeviceFixServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a message
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.bruce.grpc.lib.device.booleanReply> insertDeviceFix(
        com.bruce.grpc.lib.device.deviceFix request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertDeviceFixMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.bruce.grpc.lib.device.booleanReply> updateDeviceFix(
        com.bruce.grpc.lib.device.deviceFix request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateDeviceFixMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.bruce.grpc.lib.device.deviceFix> searchDeviceFix(
        com.bruce.grpc.lib.device.conditionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSearchDeviceFixMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.bruce.grpc.lib.device.booleanReply> deleteDeviceFix(
        com.bruce.grpc.lib.device.conditionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteDeviceFixMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INSERT_DEVICE_FIX = 0;
  private static final int METHODID_UPDATE_DEVICE_FIX = 1;
  private static final int METHODID_SEARCH_DEVICE_FIX = 2;
  private static final int METHODID_DELETE_DEVICE_FIX = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DeviceFixServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DeviceFixServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INSERT_DEVICE_FIX:
          serviceImpl.insertDeviceFix((com.bruce.grpc.lib.device.deviceFix) request,
              (io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.booleanReply>) responseObserver);
          break;
        case METHODID_UPDATE_DEVICE_FIX:
          serviceImpl.updateDeviceFix((com.bruce.grpc.lib.device.deviceFix) request,
              (io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.booleanReply>) responseObserver);
          break;
        case METHODID_SEARCH_DEVICE_FIX:
          serviceImpl.searchDeviceFix((com.bruce.grpc.lib.device.conditionsRequest) request,
              (io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.deviceFix>) responseObserver);
          break;
        case METHODID_DELETE_DEVICE_FIX:
          serviceImpl.deleteDeviceFix((com.bruce.grpc.lib.device.conditionsRequest) request,
              (io.grpc.stub.StreamObserver<com.bruce.grpc.lib.device.booleanReply>) responseObserver);
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

  private static abstract class DeviceFixServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DeviceFixServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.bruce.grpc.lib.device.DeviceFixProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DeviceFixService");
    }
  }

  private static final class DeviceFixServiceFileDescriptorSupplier
      extends DeviceFixServiceBaseDescriptorSupplier {
    DeviceFixServiceFileDescriptorSupplier() {}
  }

  private static final class DeviceFixServiceMethodDescriptorSupplier
      extends DeviceFixServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DeviceFixServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DeviceFixServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DeviceFixServiceFileDescriptorSupplier())
              .addMethod(getInsertDeviceFixMethod())
              .addMethod(getUpdateDeviceFixMethod())
              .addMethod(getSearchDeviceFixMethod())
              .addMethod(getDeleteDeviceFixMethod())
              .build();
        }
      }
    }
    return result;
  }
}
