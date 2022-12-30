package tech.altier.JProxy.core;

import tech.altier.JProxy.Main;

import java.io.IOException;
import java.net.ServerSocket;

public class RequestHandler implements Runnable {
    private final ServerSocket serverSocket;
    private final int port;

    public RequestHandler(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            Main.logger.logln("Error creating server socket: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        Main.logger.logln("Listening started on port " + port);

        while (!Thread.currentThread().isInterrupted()) {
            try {
                serverSocket.accept();
            } catch (Exception e) {
                Main.logger.logln("Error while listening: " + e.getMessage());
            }
        }
    }
}
