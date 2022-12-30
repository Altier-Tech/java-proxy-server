package tech.altier.JProxy.core;

import tech.altier.JProxy.Main;

public class RequestHandler implements Runnable {
    private final int port;

    public RequestHandler(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        Main.logger.logln("Listening started on port " + port);

    }
}
