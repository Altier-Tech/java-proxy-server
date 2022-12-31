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

    public static void parseRequest(BufferedReader clientInput) {
        
    }

}
