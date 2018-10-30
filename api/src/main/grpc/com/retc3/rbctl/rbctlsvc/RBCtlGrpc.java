package com.retc3.rbctl.rbctlsvc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.7.0)",
    comments = "Source: rbctl.proto")
public final class RBCtlGrpc {

  private RBCtlGrpc() {}

  public static final String SERVICE_NAME = "rbctl.RBCtl";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.retc3.rbctl.rbctlsvc.Rbctl.Command,
      com.retc3.rbctl.rbctlsvc.Rbctl.ControlResponse> METHOD_CONTROL =
      io.grpc.MethodDescriptor.<com.retc3.rbctl.rbctlsvc.Rbctl.Command, com.retc3.rbctl.rbctlsvc.Rbctl.ControlResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "rbctl.RBCtl", "Control"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.retc3.rbctl.rbctlsvc.Rbctl.Command.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.retc3.rbctl.rbctlsvc.Rbctl.ControlResponse.getDefaultInstance()))
          .setSchemaDescriptor(new RBCtlMethodDescriptorSupplier("Control"))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RBCtlStub newStub(io.grpc.Channel channel) {
    return new RBCtlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RBCtlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RBCtlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RBCtlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RBCtlFutureStub(channel);
  }

  /**
   */
  public static abstract class RBCtlImplBase implements io.grpc.BindableService {

    /**
     */
    public void control(com.retc3.rbctl.rbctlsvc.Rbctl.Command request,
        io.grpc.stub.StreamObserver<com.retc3.rbctl.rbctlsvc.Rbctl.ControlResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CONTROL, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CONTROL,
            asyncUnaryCall(
              new MethodHandlers<
                com.retc3.rbctl.rbctlsvc.Rbctl.Command,
                com.retc3.rbctl.rbctlsvc.Rbctl.ControlResponse>(
                  this, METHODID_CONTROL)))
          .build();
    }
  }

  /**
   */
  public static final class RBCtlStub extends io.grpc.stub.AbstractStub<RBCtlStub> {
    private RBCtlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RBCtlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RBCtlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RBCtlStub(channel, callOptions);
    }

    /**
     */
    public void control(com.retc3.rbctl.rbctlsvc.Rbctl.Command request,
        io.grpc.stub.StreamObserver<com.retc3.rbctl.rbctlsvc.Rbctl.ControlResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CONTROL, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RBCtlBlockingStub extends io.grpc.stub.AbstractStub<RBCtlBlockingStub> {
    private RBCtlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RBCtlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RBCtlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RBCtlBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.retc3.rbctl.rbctlsvc.Rbctl.ControlResponse control(com.retc3.rbctl.rbctlsvc.Rbctl.Command request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CONTROL, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RBCtlFutureStub extends io.grpc.stub.AbstractStub<RBCtlFutureStub> {
    private RBCtlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RBCtlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RBCtlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RBCtlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.retc3.rbctl.rbctlsvc.Rbctl.ControlResponse> control(
        com.retc3.rbctl.rbctlsvc.Rbctl.Command request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CONTROL, getCallOptions()), request);
    }
  }

  private static final int METHODID_CONTROL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RBCtlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RBCtlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CONTROL:
          serviceImpl.control((com.retc3.rbctl.rbctlsvc.Rbctl.Command) request,
              (io.grpc.stub.StreamObserver<com.retc3.rbctl.rbctlsvc.Rbctl.ControlResponse>) responseObserver);
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

  private static abstract class RBCtlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RBCtlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.retc3.rbctl.rbctlsvc.Rbctl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RBCtl");
    }
  }

  private static final class RBCtlFileDescriptorSupplier
      extends RBCtlBaseDescriptorSupplier {
    RBCtlFileDescriptorSupplier() {}
  }

  private static final class RBCtlMethodDescriptorSupplier
      extends RBCtlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RBCtlMethodDescriptorSupplier(String methodName) {
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
      synchronized (RBCtlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RBCtlFileDescriptorSupplier())
              .addMethod(METHOD_CONTROL)
              .build();
        }
      }
    }
    return result;
  }
}
