package tech.altier.JProxy.http;

import java.net.http.HttpResponse;

public class Response {
    private final String version;
    private final int statusCode;
    private final String body;

    private Response(String version, int statusCode, String body) {
        this.version = version;
        this.statusCode = statusCode;
        this.body = body;
    }

    public Response(HttpResponse<String> responseFromServer) {
        this(responseFromServer.version().toString(), responseFromServer.statusCode(), responseFromServer.body());
    }

    public String build() {
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(version).append(" ").append(statusCode).append("\r\n\r\n");
        responseBuilder.append(body);
        return responseBuilder.toString();
    }
}
