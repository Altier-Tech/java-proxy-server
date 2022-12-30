package tech.altier.JProxy.core;

import com.sun.net.httpserver.Request;
import tech.altier.JProxy.Main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (Exception e) {
                Main.logger.logln("Error while listening: " + e.getMessage());
            }
            assert clientSocket != null;
            handleRequest(clientSocket);
        }
    }

    private void handleRequest(Socket clientSocket) {
        Main.logger.logln("Request received from " + clientSocket.getInetAddress().getHostAddress());
        new Thread(new Request(clientSocket)).start();
    }
}
