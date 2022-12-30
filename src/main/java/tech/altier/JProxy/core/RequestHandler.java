package tech.altier.JProxy.core;

import tech.altier.JProxy.Main;

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
            DataOutputStream clientOut = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String request = clientIn.readLine();
        } catch (Exception e) {
            Main.logger.logln(e.getMessage());
        }
    }
}
