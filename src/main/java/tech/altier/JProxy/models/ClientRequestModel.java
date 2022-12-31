package tech.altier.JProxy.models;

public class ClientRequestModel {
    HttpMethod method;
    String endpoint;
    String version;

    public ClientRequestModel(HttpMethod method, String endpoint, String version) {
        this.method = method;
        this.endpoint = endpoint;
        this.version = version;
    }

    
}
