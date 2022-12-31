package tech.altier.JProxy.models;

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


}
