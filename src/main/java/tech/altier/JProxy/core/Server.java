package tech.altier.JProxy.core;

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public Server start() {
        return this;
    }
}
