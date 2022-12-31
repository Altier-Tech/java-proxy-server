package tech.altier.JProxy.models;

import tech.altier.JProxy.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientRequest {
    HttpMethod method;
    String endpoint;
    String version;

    String requestBody;

    private ClientRequest() {
    }

    private ClientRequest(HttpMethod method, String endpoint, String version, String body) {
        this.method = method;
        this.endpoint = endpoint;
        this.version = version;
        this.requestBody = body;
    }

    public static ClientRequest parseRequest(BufferedReader clientInput) {
        int contentLength = 0;
        String requestBody;
        try {
            String line;
            while (!(line = clientInput.readLine()).isBlank()) {
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

        return new ClientRequest(

        );
    }

    public void getClientRequest(Socket client) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));

        StringBuilder requestBuilder = new StringBuilder();
        String line;
        int contentLength = 0;

        while (true) {
            line = br.readLine();
            if (line == null) break;
            requestBuilder.append(line).append("\r\n");
            if (line.toLowerCase().startsWith("content-length")) {
                contentLength = Integer.parseInt(line.split(":")[1].trim());
            }
        }

        StringBuilder requestBodyBuilder = new StringBuilder();
        if (contentLength > 0) {
            int read;
            while ((read = br.read()) != -1) {
                requestBodyBuilder.append((char) read);
                if (requestBodyBuilder.length() == contentLength)
                    break;
            }
            requestBuilder.append("\r\n").append(requestBodyBuilder);
        }

        requestBody = requestBodyBuilder.toString();
    }
}
