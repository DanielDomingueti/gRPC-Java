package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(9090)
                .addService(new HelloServiceImpl())
                .build();

        server.start();
        System.out.println("started");

        server.awaitTermination(); //awaitTermination() to keep the server running in the foreground blocking the prompt.
    }
}