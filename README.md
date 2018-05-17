# 程序启动步骤
### 1 启动服务端：
```
运行 io/grpc/examples/helloworld/HelloWorldServer.java 的 main 方法
```
### 2.启动客户端调用服务：
```
运行：io/grpc/examples/helloworld/HelloWorldClient.java 的main 方法
```
---
# grpc
This guide gets you started with gRPC in Java with a simple working example.
- 这是一篇关于google的grpc框架的java版本的入门demo

# 从 [官网] 进入java的学习指导页面
[官网]:https:grpc.io "官网"

```
# 克隆最新版本的栗子
git clone -b v1.11.0 https://github.com/grpc/grpc-java
# 进入项目
cd grpc-java/examples/
```

1.运行一个grpc应用
```
# 编译客户端和服务端
./gradlew installDist
# 运行服务端
./build/install/examples/bin/hello-world-server
# 运行客户端
./build/install/examples/bin/hello-world-client
```
恭喜，您刚刚使用GRPC运行客户端服务器应用程序。


2.更新一个grpc服务
现在让我们看看如何在服务器上为客户端调用一个额外的方法来更新应用程序。
我们的服务是使用protocol buffers GRPC定义；你可以在java GRPC中找到许多关于如何在定义一个.proto。
现在，您需要知道的是，服务器和客户端“存根”都有一个SayHello方法，
它从客户端获取一个HelloRequest参数，并从服务器返回一个HelloReply，这个方法定义如下：
```
// The greeting service definition.
service Greeter {
  // Sends a greeting
  rpc SayHello (HelloRequest) returns (HelloReply) {}
}

// The request message containing the user's name.
message HelloRequest {
  string name = 1;
}

// The response message containing the greetings
message HelloReply {
  string message = 1;
}
```

让我们更新Greeter 这个服务，编辑 src/main/proto/helloworld.proto，新增一个SayHelloAgain方法，
请求和响应参数和SayHello相同
```
// The greeting service definition.
service Greeter {
  // Sends a greeting
  rpc SayHello (HelloRequest) returns (HelloReply) {}
  // Sends another greeting
  rpc SayHelloAgain (HelloRequest) returns (HelloReply) {}
}

// The request message containing the user's name.
message HelloRequest {
  string name = 1;
}

// The response message containing the greetings
message HelloReply {
  string message = 1;
}
```
（不要忘记保存文件哦～）

更新并运行程序
当我们再次编译的时候，会再次产生GreeterGrpc.java文件，包含我们产生的grpc客户端和服务端类文件。
还生成用于填充、序列化和检索请求和响应类型的类。
不过，我们仍需要手动实现新增的方法SayHelloAgain

更新服务端
在 src/main/java/io/grpc/examples/helloworld/HelloWorldServer.java文件中，实现方法如下：
```
private class GreeterImpl extends GreeterGrpc.GreeterImplBase {

  @Override
  public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
    HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }

  @Override
  public void sayHelloAgain(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
    HelloReply reply = HelloReply.newBuilder().setMessage("Hello again " + req.getName()).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }
}
```

更新客户端
在src/main/java/io/grpc/examples/helloworld/HelloWorldClient.java文件中，调用如下：
```
public void greet(String name) {
  logger.info("Will try to greet " + name + " ...");
  HelloRequest request = HelloRequest.newBuilder().setName(name).build();
  HelloReply response;
  try {
    response = blockingStub.sayHello(request);
  } catch (StatusRuntimeException e) {
    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
    return;
  }
  logger.info("Greeting: " + response.getMessage());
  try {
    response = blockingStub.sayHelloAgain(request);
  } catch (StatusRuntimeException e) {
    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
    return;
  }
  logger.info("Greeting: " + response.getMessage());
}
```

好了，正如我们开始运行一样，依次运行一下脚本
```
# 编译客户端和服务端
./gradlew installDist
# 运行服务端
./build/install/examples/bin/hello-world-server
# 运行客户端
./build/install/examples/bin/hello-world-client
```

完美！


### 官方文档
grpc Examples
==============================================

The examples require grpc-java to already be built. You are strongly encouraged
to check out a git release tag, since there will already be a build of grpc
available. Otherwise you must follow [COMPILING](../COMPILING.md).

You may want to read through the
[Quick Start Guide](https://grpc.io/docs/quickstart/java.html)
before trying out the examples.

To build the examples, run in this directory:

```
$ ./gradlew installDist
```

This creates the scripts `hello-world-server`, `hello-world-client`, 
`hello-world-tls-server`, `hello-world-tls-client`,
`route-guide-server`, and `route-guide-client` in the
`build/install/examples/bin/` directory that run the examples. Each
example requires the server to be running before starting the client.

For example, to try the hello world example first run:

```
$ ./build/install/examples/bin/hello-world-server
```

And in a different terminal window run:

```
$ ./build/install/examples/bin/hello-world-client
```

### Hello World with TLS 

Running the hello world with TLS is the same as the normal hello world, but takes additional args:

**hello-world-tls-server**:

```text
USAGE: HelloWorldServerTls host port certChainFilePath privateKeyFilePath [clientCertChainFilePath]
  Note: You only need to supply clientCertChainFilePath if you want to enable Mutual TLS.
```

**hello-world-tls-client**:

```text
USAGE: HelloWorldClientTls host port [trustCertCollectionFilePath] [clientCertChainFilePath] [clientPrivateKeyFilePath]
  Note: clientCertChainFilePath and clientPrivateKeyFilePath are only needed if mutual auth is desired. And if you specify clientCertChainFilePath you must also specify clientPrivateKeyFilePath
```

#### Generating self-signed certificates for use with grpc

You can use the following script to generate self-signed certificates for grpc-java including the hello world with TLS examples:

```bash
# Changes these CN's to match your hosts in your environment if needed.
SERVER_CN=localhost
CLIENT_CN=localhost # Used when doing mutual TLS

echo Generate CA key:
openssl genrsa -passout pass:1111 -des3 -out ca.key 4096
echo Generate CA certificate:
# Generates ca.crt which is the trustCertCollectionFile
openssl req -passin pass:1111 -new -x509 -days 365 -key ca.key -out ca.crt -subj "/CN=${SERVER_CN}"
echo Generate server key:
openssl genrsa -passout pass:1111 -des3 -out server.key 4096
echo Generate server signing request:
openssl req -passin pass:1111 -new -key server.key -out server.csr -subj "/CN=${SERVER_CN}"
echo Self-signed server certificate:
# Generates server.crt which is the certChainFile for the server
openssl x509 -req -passin pass:1111 -days 365 -in server.csr -CA ca.crt -CAkey ca.key -set_serial 01 -out server.crt 
echo Remove passphrase from server key:
openssl rsa -passin pass:1111 -in server.key -out server.key
echo Generate client key
openssl genrsa -passout pass:1111 -des3 -out client.key 4096
echo Generate client signing request:
openssl req -passin pass:1111 -new -key client.key -out client.csr -subj "/CN=${CLIENT_CN}"
echo Self-signed client certificate:
# Generates client.crt which is the clientCertChainFile for the client (need for mutual TLS only)
openssl x509 -passin pass:1111 -req -days 365 -in client.csr -CA ca.crt -CAkey ca.key -set_serial 01 -out client.crt
echo Remove passphrase from client key:
openssl rsa -passin pass:1111 -in client.key -out client.key
echo Converting the private keys to X.509:
# Generates client.pem which is the clientPrivateKeyFile for the Client (needed for mutual TLS only)
openssl pkcs8 -topk8 -nocrypt -in client.key -out client.pem
# Generates server.pem which is the privateKeyFile for the Server
openssl pkcs8 -topk8 -nocrypt -in server.key -out server.pem
```

#### Hello world example with TLS (no mutual auth):

```bash
# Server
./build/install/examples/bin/hello-world-server-tls mate 50440 ~/Downloads/sslcert/server.crt ~/Downloads/sslcert/server.pem
# Client
./build/install/examples/bin/hello-world-client-tls mate 50440 ~/Downloads/sslcert/ca.crt
```

#### Hello world example with TLS with mutual auth:

```bash
# Server
./build/install/examples/bin/hello-world-server-tls mate 54440 ~/Downloads/sslcert/server.crt ~/Downloads/sslcert/server.pem ~/Downloads/sslcert/client.crt
# Client
./build/install/examples/bin/hello-world-client-tls mate 54440 ~/Downloads/sslcert/ca.crt ~/Downloads/sslcert/client.crt ~/Downloads/sslcert/client.pem
```

That's it!

Please refer to gRPC Java's [README](../README.md) and
[tutorial](https://grpc.io/docs/tutorials/basic/java.html) for more
information.

## Maven

If you prefer to use Maven:
```
$ mvn verify
$ # Run the server
$ mvn exec:java -Dexec.mainClass=io.grpc.examples.helloworld.HelloWorldServer
$ # In another terminal run the client
$ mvn exec:java -Dexec.mainClass=io.grpc.examples.helloworld.HelloWorldClient
```

## Bazel

If you prefer to use Bazel:
```
(With Bazel v0.8.0 or above.)
$ bazel build :hello-world-server :hello-world-client
$ # Run the server:
$ bazel-bin/hello-world-server
$ # In another terminal run the client
$ bazel-bin/hello-world-client
```

Unit test examples
==============================================

Examples for unit testing gRPC clients and servers are located in [examples/src/test](src/test).

In general, we DO NOT allow overriding the client stub.
We encourage users to leverage `InProcessTransport` as demonstrated in the examples to
write unit tests. `InProcessTransport` is light-weight and runs the server
and client in the same process without any socket/TCP connection.

For testing a gRPC client, create the client with a real stub
using an
[InProcessChannel](../core/src/main/java/io/grpc/inprocess/InProcessChannelBuilder.java),
and test it against an
[InProcessServer](../core/src/main/java/io/grpc/inprocess/InProcessServerBuilder.java)
with a mock/fake service implementation.

For testing a gRPC server, create the server as an InProcessServer,
and test it against a real client stub with an InProcessChannel.

The gRPC-java library also provides a JUnit rule,
[GrpcServerRule](../testing/src/main/java/io/grpc/testing/GrpcServerRule.java), to do the starting
up and shutting down boilerplate for you.
