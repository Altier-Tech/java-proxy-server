package tech.altier.JProxy.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GETRequest {
    private String endPoint;

    public GETRequest(String endPoint) {
        this.endPoint = endPoint;
    }

    public HttpResponse<String> send() throws IOException, InterruptedException {
        var uri = URI.create(endPoint);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest
                .newBuilder()
                .uri(uri)
                .header("accept", "application/json")
                .GET()
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
