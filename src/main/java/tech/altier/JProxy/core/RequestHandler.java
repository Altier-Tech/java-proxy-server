package tech.altier.JProxy.core;

import tech.altier.JProxy.Main;
import tech.altier.JProxy.models.ClientRequest;
import tech.altier.JProxy.models.HttpMethod;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class RequestHandler implements Runnable {
    private final Socket clientSocket;

    public RequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        Main.logger.logln("Handler started for request from " + clientSocket.getInetAddress().getHostAddress());
        Main.logger.logln(
                clientSocket.getInetAddress().toString() + " : " +
                clientSocket.getPort()
        );

        try {
            BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream clientOut = new DataOutputStream(clientSocket.getOutputStream());

            // TODO : Handle request
            ClientRequest requestFromClient = ClientRequest.parseRequest(clientIn);

            // If the request is GET
            if (requestFromClient.getMethod() == HttpMethod.GET) {
                Main.logger.error(requestFromClient.getBody());
            }

            // TODO : Send response
            String response = "HTTP/1.1 200 OK\r\n\r\n"; // TODO remove

            clientOut.writeBytes(response);
            clientOut.flush();

            clientOut.close();
            clientIn.close();

            Main.logger.logln("Response sent");
        } catch (Exception e) {
            Main.logger.logln(e.getMessage());
        }

    }
}
