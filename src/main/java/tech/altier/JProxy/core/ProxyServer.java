package tech.altier.JProxy.core;

import tech.altier.JProxy.Main;

public class ProxyServer {
    private static ProxyServer instance;
    private static int DEFAULT_PORT;
    private int port;
    private Thread listener;

    static {
        try {
            DEFAULT_PORT = Integer.parseInt(Main.applicationProperties.get("port"));
        } catch (Exception e) {
            Main.logger.logln("Error loading default port from application properties: " + e.getMessage());
            Main.logger.logln("Using default port 8080");
            DEFAULT_PORT = 8080;
        }
    }

    private ProxyServer(int port) {
        this.port = port;
    }

    private ProxyServer() {
        this(DEFAULT_PORT);
    }

    public static ProxyServer getInstance() {
        if (instance == null) instance = new ProxyServer();
        return instance;
    }

    public void start() {
        Main.logger.logln("Starting proxy server...");
        listener = new RequestHandler(port);
        listener.start();
    }

    public void stop() {
        Main.logger.logln("Stopping proxy server...");
        listener.interrupt();
    }
}
