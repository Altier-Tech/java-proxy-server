package tech.altier.JProxy.core;

import java.net.Socket;

public class RequestHandler implements Runnable {
    private final Socket clientSocket;

    public RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

    }
}
