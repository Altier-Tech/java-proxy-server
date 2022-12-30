package tech.altier.JProxy.core;

import com.sun.net.httpserver.Request;
import tech.altier.JProxy.Main;

import java.io.IOException;
import java.net.Socket;

public class RequestHandler implements Runnable {
    private final Socket clientSocket;

    public RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            Request request = new Request(clientSocket.getInputStream());
            Response response = new Response(clientSocket.getOutputStream());
            response.send(request);
        } catch (IOException e) {
            Main.logger.logln("Error handling request: " + e.getMessage());
        }
    }
}
