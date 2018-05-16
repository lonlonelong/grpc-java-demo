# grpc
This guide gets you started with gRPC in Java with a simple working example.
- 这是一篇关于google的grpc框架的java版本的入门demo

# 1.从官网![https:grpc.io]进入java的官方学习指导页面

```
1.克隆最新版本的栗子
git clone -b v1.11.0 https://github.com/grpc/grpc-java
2.进入项目
cd grpc-java
```

3.运行一个grpc应用
```
1.编译客户端和服务端
./gradlew installDist
2.运行服务端
./build/install/examples/bin/hello-world-server
3.运行客户端
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
