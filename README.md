# grpc
This guide gets you started with gRPC in Java with a simple working example.
- 这是一篇关于google的grpc框架的java版本的入门demo

# 1.从 官网[offical_website] 进入java的官方学习指导页面
[offical_website]:https:grpc.io "官网"

```
# 克隆最新版本的栗子
git clone -b v1.11.0 https://github.com/grpc/grpc-java
# 进入项目
cd grpc-java
```

3.运行一个grpc应用
```
# 编译客户端和服务端
./gradlew installDist
# 运行服务端
./build/install/examples/bin/hello-world-server
# 运行客户端
./build/install/examples/bin/hello-world-client
```
恭喜，您刚刚使用GRPC运行客户端服务器应用程序。


4.更新一个grpc服务
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
