package tech.altier.JProxy.models;

import tech.altier.JProxy.Main;

import java.io.BufferedReader;

public class ClientRequest {
    HttpMethod method;
    String endpoint;
    String version;

    String body;

    public ClientRequest(HttpMethod method, String endpoint, String version, String body) {
        this.method = method;
        this.endpoint = endpoint;
        this.version = version;
        this.body = body;
    }

    public static ClientRequest parseRequest(BufferedReader clientInput) {
        try {
            while(true) {
                String line = clientIn.readLine();
                if (line.isBlank() || line.isEmpty()) break;
                Main.logger.logln(line);
            }
        } catch (Exception ignored) {}

        return new ClientRequest(

        );
    }

}
