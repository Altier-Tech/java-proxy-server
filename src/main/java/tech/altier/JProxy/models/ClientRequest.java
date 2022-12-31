package tech.altier.JProxy.models;

import tech.altier.JProxy.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class ClientRequest {
    HttpMethod method;
    String endpoint;
    String version;

    String requestBody;

    public ClientRequest() {
    }

    public ClientRequest(HttpMethod method, String endpoint, String version, String body) {
        this.method = method;
        this.endpoint = endpoint;
        this.version = version;
        this.body = body;
    }

    public static ClientRequest parseRequest(BufferedReader clientInput) {
        // TODO get request body
        try {
            while(true) {
                String line = clientInput.readLine();
                if (line.isBlank() || line.isEmpty()) break;
                Main.logger.logln(line);
            }
        } catch (Exception ignored) {}

        return new ClientRequest(

        );
    }

    public void getClientRequest(Socket client) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));

        StringBuilder requestBuilder = new StringBuilder();
        String line;
        int contectLegnth = 0;

        while (!(line = br.readLine()).isBlank()) {
            requestBuilder.append(line).append("\r\n");
            if (line.toLowerCase().startsWith("content-length")) {
                contectLegnth = Integer.parseInt(line.split(":")[1].trim());
            }
        }


        StringBuilder requestBodyBuilder = new StringBuilder();
        if (contectLegnth > 0) {
            int read;
            while ((read = br.read()) != -1) {
                requestBodyBuilder.append((char) read);
                if (requestBodyBuilder.length() == contectLegnth)
                    break;
            }
            requestBuilder.append("\r\n").append(requestBodyBuilder);
        }

        requestBody = requestBodyBuilder.toString();
    }
}
