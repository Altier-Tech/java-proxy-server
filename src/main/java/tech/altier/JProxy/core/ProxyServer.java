package tech.altier.JProxy.core;

public class ProxyServer {
    private static ProxyServer instance;
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
        System.out.println("Starting proxy server...");
    }

    public void stop() {
        System.out.println("Stopping proxy server...");
    }
}
