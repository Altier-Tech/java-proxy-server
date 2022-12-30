package tech.altier.JProxy.core;

import tech.altier.JProxy.Main;

import java.net.ServerSocket;

public class RequestHandler implements Runnable {
    private final int port;
    private ServerSocket serverSocket;

    public RequestHandler(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        Main.logger.logln("Listening started on port " + port);

    }
}
