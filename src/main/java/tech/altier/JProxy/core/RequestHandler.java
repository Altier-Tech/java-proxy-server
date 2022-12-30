package tech.altier.JProxy.core;

import tech.altier.JProxy.Main;
import tech.altier.Thread.ThreadColor;

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
        Main.logger.log("Handler started for request from ");
        System.out.println(ThreadColor.ANSI_BLINK + clientSocket.getInetAddress().getHostAddress());
        Main.logger.logln(
                clientSocket.getInetAddress().toString() + " : " +
                clientSocket.getPort()
        );

        try {
            BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream clientOut = new DataOutputStream(clientSocket.getOutputStream());

            String request = clientIn.readLine();

            String[] requestParts = request.split(" ");
            String method = requestParts[0];
            String url = requestParts[1];
            String version = requestParts[2];

            Main.logger.logln("Method: " + method);
            Main.logger.logln("URL: " + url);
            Main.logger.logln("Version: " + version);

            // TODO : Handle request
            String response = "HTTP/1.1 200 OK\r\n\r\n";
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
