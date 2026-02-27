package org.example;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.example.handler.HomeHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App  {
    public static void main( String[] args ) throws IOException {
        HttpHandler homeHandler = new HomeHandler();

        int port = System.getenv("PORT") == null ? 8080 : Integer.parseInt(System.getenv("PORT"));
        InetSocketAddress address = new InetSocketAddress(port);

        HttpServer server = HttpServer.create(address, 0);

        server.createContext("/", homeHandler);
        server.start();
    }
}
