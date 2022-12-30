package tech.altier.JProxy.core;

import tech.altier.JProxy.Main;

public class ProxyServer {
    private static ProxyServer instance;
    private static int DEFAULT_PORT = 8080;
    private int port;

    private ProxyServer(int port) {
        this.port = port;
    }

    private ProxyServer() {
        this(8080);
    }

    public static ProxyServer getInstance() {
        if (instance == null) instance = new ProxyServer();
        return instance;
    }

    public void start() {
        Main.logger.logln("Starting proxy server...");
    }

    public void stop() {
        Main.logger.logln("Stopping proxy server...");
    }
}
