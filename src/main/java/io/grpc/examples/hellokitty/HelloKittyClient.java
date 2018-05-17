package io.grpc.examples.hellokitty;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloKittyClient {
  private static final Logger logger = Logger.getLogger(HelloKittyClient.class.getName());

  private final ManagedChannel channel;
  private final HelloKittyGrpc.HelloKittyBlockingStub blockingStub;

  /**
   * Construct client connecting to HelloWorld server at {@code host:port}.
   */
  public HelloKittyClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext(true)
        .build());
  }

  /**
   * Construct client for accessing RouteGuide server using the existing channel.
   */
  HelloKittyClient(ManagedChannel channel) {
    this.channel = channel;
    blockingStub = HelloKittyGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /**
   * Say hello to server.
   */
  public void greet(String name) {
    logger.info("Will try to greet " + name + " ...");
    HelloKittyRequest request = HelloKittyRequest.newBuilder().setName(name).build();
    HelloKittyReply response;
    try {
      response = blockingStub.sayHello(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("Greeting: " + response.getMessage());
  }

  /**
   * Greet server. If provided, the first element of {@code args} is the name to use in the
   * greeting.
   */
  public static void main(String[] args) throws Exception {
    HelloKittyClient client = new HelloKittyClient("localhost", 50052);
    try {
      /* Access a service running on the local machine on port 50051 */
      String user = "kitty";
      if (args.length > 0) {
        user = args[0]; /* Use the arg as the name to greet if provided */
      }
      client.greet(user);
    } finally {
      client.shutdown();
    }
  }
}
