package io.grpc.examples.routeguide;

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
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.11.0)",
    comments = "Source: route_guide.proto")
public final class RouteGuideGrpc {

  private RouteGuideGrpc() {}

  public static final String SERVICE_NAME = "routeguide.RouteGuide";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetFeatureMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Point,
      io.grpc.examples.routeguide.Feature> METHOD_GET_FEATURE = getGetFeatureMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Point,
      io.grpc.examples.routeguide.Feature> getGetFeatureMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Point,
      io.grpc.examples.routeguide.Feature> getGetFeatureMethod() {
    return getGetFeatureMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Point,
      io.grpc.examples.routeguide.Feature> getGetFeatureMethodHelper() {
    io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Point, io.grpc.examples.routeguide.Feature> getGetFeatureMethod;
    if ((getGetFeatureMethod = RouteGuideGrpc.getGetFeatureMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getGetFeatureMethod = RouteGuideGrpc.getGetFeatureMethod) == null) {
          RouteGuideGrpc.getGetFeatureMethod = getGetFeatureMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.routeguide.Point, io.grpc.examples.routeguide.Feature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "routeguide.RouteGuide", "GetFeature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.routeguide.Point.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.routeguide.Feature.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("GetFeature"))
                  .build();
          }
        }
     }
     return getGetFeatureMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListFeaturesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Rectangle,
      io.grpc.examples.routeguide.Feature> METHOD_LIST_FEATURES = getListFeaturesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Rectangle,
      io.grpc.examples.routeguide.Feature> getListFeaturesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Rectangle,
      io.grpc.examples.routeguide.Feature> getListFeaturesMethod() {
    return getListFeaturesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Rectangle,
      io.grpc.examples.routeguide.Feature> getListFeaturesMethodHelper() {
    io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Rectangle, io.grpc.examples.routeguide.Feature> getListFeaturesMethod;
    if ((getListFeaturesMethod = RouteGuideGrpc.getListFeaturesMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getListFeaturesMethod = RouteGuideGrpc.getListFeaturesMethod) == null) {
          RouteGuideGrpc.getListFeaturesMethod = getListFeaturesMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.routeguide.Rectangle, io.grpc.examples.routeguide.Feature>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "routeguide.RouteGuide", "ListFeatures"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.routeguide.Rectangle.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.routeguide.Feature.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("ListFeatures"))
                  .build();
          }
        }
     }
     return getListFeaturesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRecordRouteMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Point,
      io.grpc.examples.routeguide.RouteSummary> METHOD_RECORD_ROUTE = getRecordRouteMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Point,
      io.grpc.examples.routeguide.RouteSummary> getRecordRouteMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Point,
      io.grpc.examples.routeguide.RouteSummary> getRecordRouteMethod() {
    return getRecordRouteMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Point,
      io.grpc.examples.routeguide.RouteSummary> getRecordRouteMethodHelper() {
    io.grpc.MethodDescriptor<io.grpc.examples.routeguide.Point, io.grpc.examples.routeguide.RouteSummary> getRecordRouteMethod;
    if ((getRecordRouteMethod = RouteGuideGrpc.getRecordRouteMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getRecordRouteMethod = RouteGuideGrpc.getRecordRouteMethod) == null) {
          RouteGuideGrpc.getRecordRouteMethod = getRecordRouteMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.routeguide.Point, io.grpc.examples.routeguide.RouteSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "routeguide.RouteGuide", "RecordRoute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.routeguide.Point.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.routeguide.RouteSummary.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("RecordRoute"))
                  .build();
          }
        }
     }
     return getRecordRouteMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRouteChatMethod()} instead. 
  public static final io.grpc.MethodDescriptor<io.grpc.examples.routeguide.RouteNote,
      io.grpc.examples.routeguide.RouteNote> METHOD_ROUTE_CHAT = getRouteChatMethodHelper();

  private static volatile io.grpc.MethodDescriptor<io.grpc.examples.routeguide.RouteNote,
      io.grpc.examples.routeguide.RouteNote> getRouteChatMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<io.grpc.examples.routeguide.RouteNote,
      io.grpc.examples.routeguide.RouteNote> getRouteChatMethod() {
    return getRouteChatMethodHelper();
  }

  private static io.grpc.MethodDescriptor<io.grpc.examples.routeguide.RouteNote,
      io.grpc.examples.routeguide.RouteNote> getRouteChatMethodHelper() {
    io.grpc.MethodDescriptor<io.grpc.examples.routeguide.RouteNote, io.grpc.examples.routeguide.RouteNote> getRouteChatMethod;
    if ((getRouteChatMethod = RouteGuideGrpc.getRouteChatMethod) == null) {
      synchronized (RouteGuideGrpc.class) {
        if ((getRouteChatMethod = RouteGuideGrpc.getRouteChatMethod) == null) {
          RouteGuideGrpc.getRouteChatMethod = getRouteChatMethod = 
              io.grpc.MethodDescriptor.<io.grpc.examples.routeguide.RouteNote, io.grpc.examples.routeguide.RouteNote>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "routeguide.RouteGuide", "RouteChat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.routeguide.RouteNote.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.examples.routeguide.RouteNote.getDefaultInstance()))
                  .setSchemaDescriptor(new RouteGuideMethodDescriptorSupplier("RouteChat"))
                  .build();
          }
        }
     }
     return getRouteChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RouteGuideStub newStub(io.grpc.Channel channel) {
    return new RouteGuideStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RouteGuideBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RouteGuideBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RouteGuideFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new RouteGuideFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class RouteGuideImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public void getFeature(io.grpc.examples.routeguide.Point request,
        io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.Feature> responseObserver) {
      asyncUnimplementedUnaryCall(getGetFeatureMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Features available within the given Rectangle.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the rectangle may cover a large area and contain a
     * huge number of features.
     * </pre>
     */
    public void listFeatures(io.grpc.examples.routeguide.Rectangle request,
        io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.Feature> responseObserver) {
      asyncUnimplementedUnaryCall(getListFeaturesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * A client-to-server streaming RPC.
     * Accepts a stream of Points on a route being traversed, returning a
     * RouteSummary when traversal is completed.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.Point> recordRoute(
        io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.RouteSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(getRecordRouteMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * A Bidirectional streaming RPC.
     * Accepts a stream of RouteNotes sent while a route is being traversed,
     * while receiving other RouteNotes (e.g. from other users).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.RouteNote> routeChat(
        io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.RouteNote> responseObserver) {
      return asyncUnimplementedStreamingCall(getRouteChatMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFeatureMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                io.grpc.examples.routeguide.Point,
                io.grpc.examples.routeguide.Feature>(
                  this, METHODID_GET_FEATURE)))
          .addMethod(
            getListFeaturesMethodHelper(),
            asyncServerStreamingCall(
              new MethodHandlers<
                io.grpc.examples.routeguide.Rectangle,
                io.grpc.examples.routeguide.Feature>(
                  this, METHODID_LIST_FEATURES)))
          .addMethod(
            getRecordRouteMethodHelper(),
            asyncClientStreamingCall(
              new MethodHandlers<
                io.grpc.examples.routeguide.Point,
                io.grpc.examples.routeguide.RouteSummary>(
                  this, METHODID_RECORD_ROUTE)))
          .addMethod(
            getRouteChatMethodHelper(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.grpc.examples.routeguide.RouteNote,
                io.grpc.examples.routeguide.RouteNote>(
                  this, METHODID_ROUTE_CHAT)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideStub extends io.grpc.stub.AbstractStub<RouteGuideStub> {
    private RouteGuideStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public void getFeature(io.grpc.examples.routeguide.Point request,
        io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.Feature> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetFeatureMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Features available within the given Rectangle.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the rectangle may cover a large area and contain a
     * huge number of features.
     * </pre>
     */
    public void listFeatures(io.grpc.examples.routeguide.Rectangle request,
        io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.Feature> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListFeaturesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * A client-to-server streaming RPC.
     * Accepts a stream of Points on a route being traversed, returning a
     * RouteSummary when traversal is completed.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.Point> recordRoute(
        io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.RouteSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getRecordRouteMethodHelper(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * A Bidirectional streaming RPC.
     * Accepts a stream of RouteNotes sent while a route is being traversed,
     * while receiving other RouteNotes (e.g. from other users).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.RouteNote> routeChat(
        io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.RouteNote> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getRouteChatMethodHelper(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideBlockingStub extends io.grpc.stub.AbstractStub<RouteGuideBlockingStub> {
    private RouteGuideBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public io.grpc.examples.routeguide.Feature getFeature(io.grpc.examples.routeguide.Point request) {
      return blockingUnaryCall(
          getChannel(), getGetFeatureMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * A server-to-client streaming RPC.
     * Obtains the Features available within the given Rectangle.  Results are
     * streamed rather than returned at once (e.g. in a response message with a
     * repeated field), as the rectangle may cover a large area and contain a
     * huge number of features.
     * </pre>
     */
    public java.util.Iterator<io.grpc.examples.routeguide.Feature> listFeatures(
        io.grpc.examples.routeguide.Rectangle request) {
      return blockingServerStreamingCall(
          getChannel(), getListFeaturesMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class RouteGuideFutureStub extends io.grpc.stub.AbstractStub<RouteGuideFutureStub> {
    private RouteGuideFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RouteGuideFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RouteGuideFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new RouteGuideFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * A simple RPC.
     * Obtains the feature at a given position.
     * A feature with an empty name is returned if there's no feature at the given
     * position.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.examples.routeguide.Feature> getFeature(
        io.grpc.examples.routeguide.Point request) {
      return futureUnaryCall(
          getChannel().newCall(getGetFeatureMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FEATURE = 0;
  private static final int METHODID_LIST_FEATURES = 1;
  private static final int METHODID_RECORD_ROUTE = 2;
  private static final int METHODID_ROUTE_CHAT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RouteGuideImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RouteGuideImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FEATURE:
          serviceImpl.getFeature((io.grpc.examples.routeguide.Point) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.Feature>) responseObserver);
          break;
        case METHODID_LIST_FEATURES:
          serviceImpl.listFeatures((io.grpc.examples.routeguide.Rectangle) request,
              (io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.Feature>) responseObserver);
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
        case METHODID_RECORD_ROUTE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recordRoute(
              (io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.RouteSummary>) responseObserver);
        case METHODID_ROUTE_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.routeChat(
              (io.grpc.stub.StreamObserver<io.grpc.examples.routeguide.RouteNote>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RouteGuideBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RouteGuideBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.examples.routeguide.RouteGuideProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RouteGuide");
    }
  }

  private static final class RouteGuideFileDescriptorSupplier
      extends RouteGuideBaseDescriptorSupplier {
    RouteGuideFileDescriptorSupplier() {}
  }

  private static final class RouteGuideMethodDescriptorSupplier
      extends RouteGuideBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RouteGuideMethodDescriptorSupplier(String methodName) {
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
      synchronized (RouteGuideGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RouteGuideFileDescriptorSupplier())
              .addMethod(getGetFeatureMethodHelper())
              .addMethod(getListFeaturesMethodHelper())
              .addMethod(getRecordRouteMethodHelper())
              .addMethod(getRouteChatMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
