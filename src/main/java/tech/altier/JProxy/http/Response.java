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
        if (statusCode == 200) {
            return "HTTP/1.1 200 OK\r\n\r\n" + body;
        } else {
            return "HTTP/1.1 404 Not Found\r\n\r\n";
        }
    }
}
