package tech.altier.JProxy.models;

import tech.altier.JProxy.Main;
import tech.altier.JSONParse.JacksonOM;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientRequest {
    HttpMethod method;
    String endpoint;
    String version;
    String body;

    public ClientRequest() {}

    public ClientRequest(HttpMethod method, String endpoint, String version, String body) {
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

    public static ClientRequest parseRequest(BufferedReader clientInput) throws IOException {
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

    private static ClientRequest parseBodyAndPopulate(String requestBody) throws IOException {
        return JacksonOM.parseClientRequest(requestBody);
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "method=" + method +
                ", endpoint='" + endpoint + '\'' +
                ", version='" + version + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
