package tech.altier.JProxy.models;

public class ClientRequest {
    HttpMethod method;
    String endpoint;
    String version;

    public ClientRequest(HttpMethod method, String endpoint, String version) {
        this.method = method;
        this.endpoint = endpoint;
        this.version = version;
    }

    
}
