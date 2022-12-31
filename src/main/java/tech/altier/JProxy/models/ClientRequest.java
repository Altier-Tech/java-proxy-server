package tech.altier.JProxy.models;

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

    public static ClientRequest parseRequest(String request, BufferedReader clientInput) {
        String[] requestParts = request.split(" ");
        String method = requestParts[0];
        String url = requestParts[1];
        String version = requestParts[2];

        String body = clientInput.readLine()

        return new ClientRequest(

        );
    }

}
