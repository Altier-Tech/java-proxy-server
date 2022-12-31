package tech.altier.JProxy.models;

import tech.altier.JProxy.Main;

import java.io.BufferedReader;

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

    public static ClientRequest parseRequest(BufferedReader clientInput) {
        int contentLength = 0;
        String method = null, endPoint = null, version = null, requestBody = null;
        HttpMethod httpMethod;
        try {
            String line;
            while (!(line = clientInput.readLine()).isBlank()) {
                // Set method, endpoint and version
                if (line.startsWith("GET") || line.startsWith("POST")) {
                    String[] requestParts = line.split(" ");
                    method = requestParts[0];
                    endPoint = requestParts[1];
                    version = requestParts[2];
                }

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

        assert method != null;
        if (method.equalsIgnoreCase("GET")) httpMethod = HttpMethod.GET;
        else if (method.equalsIgnoreCase("POST")) httpMethod = HttpMethod.POST;
        else httpMethod = HttpMethod.UNKNOWN;

        return new ClientRequest(httpMethod, endPoint, version, requestBody);
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
}
