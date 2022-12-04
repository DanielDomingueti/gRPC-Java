package org.example;

import generated.HelloRequest;
import generated.HelloResponse;
import generated.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class Main {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse response = stub.hello(HelloRequest.newBuilder()
                .setName("Daniel")
                .setAge(17)
                .build());

        System.out.println(response.getGreeting());

        channel.shutdown();
    }
}