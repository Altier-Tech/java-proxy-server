package tech.altier.JProxy.models;

import tech.altier.JProxy.Main;
import tech.altier.JProxy.http.GETRequest;
import tech.altier.JSONParse.JacksonOM;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientRequest {
    HttpMethod method;
    String endpoint;
    String version;
    String body;

    private ClientRequest(HttpMethod method, String endpoint, String version, String body) {
        this.method = method;
        this.endpoint = endpoint;
        this.version = version;
        this.body = body;
    }

    public HttpMethod getMethod() {
        return method;
    }
    public void setMethod(HttpMethod method) {
        this.method = method;
    }
    public String getEndpoint() {
        return endpoint;
    }
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public static ClientRequest parseRequest(BufferedReader clientInput) {
        String requestBody = null;
        try {
            int contentLength = 0;
            String line;
            while (!(line = clientInput.readLine()).isBlank()) {
                // Set content length
                if (line.toLowerCase().startsWith("content-length")) {
                    contentLength = Integer.parseInt(line.split(":")[1].trim());
                }
            }

            StringBuilder requestBodyBuilder = new StringBuilder();
            if (contentLength > 0) {
                int read;
                while ((read = clientInput.read()) != -1) {
                    requestBodyBuilder.append((char) read);
                    if (requestBodyBuilder.length() == contentLength) break;
                }
            }

            requestBody = requestBodyBuilder.toString();
        } catch (Exception e) {
            Main.logger.error(e.getMessage());
        }

        return parseBodyAndPopulate(requestBody);
    }

    private static ClientRequest parseBodyAndPopulate(String requestBody) {
        try {
            GETRequest request = JacksonOM.parseGETRequest(requestBody);
        } catch (IOException e) {
            Main.logger.error(e.getMessage());
        }

        return new ClientRequest(
                HttpMethod.GET,
                "www.google.lk",
                "HTTP/1.1",
                requestBody
        );
    }
}
