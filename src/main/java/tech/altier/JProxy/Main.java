package tech.altier.JProxy;

import tech.altier.AppProperties.PropertiesHandler;
import tech.altier.JProxy.core.ProxyServer;
import tech.altier.Logger.LogManager;
import tech.altier.Logger.LoggerType;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static LogManager logger;
    public static PropertiesHandler applicationProperties;
    public static ProxyServer server;

    public static void main(String[] args) {
        // Init
        logger = new LogManager(LoggerType.CONSOLE);
        loadApplicationProperties();

        // Start the proxy server
        server = ProxyServer.getInstance();
        server.start();
        listenForStopCommand();

        // Exit
        storeApplicationProperties();
    }

    private static void listenForStopCommand() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            input = scanner.nextLine();
        }
        server.stop();
    }

    private static void storeApplicationProperties() {
        applicationProperties.storeProperties();
    }

    private static void loadApplicationProperties() {
        try {
            applicationProperties = new PropertiesHandler("application").loadProperties();
        } catch (IOException e) {
            logger.logln("Error loading application properties: " + e.getMessage());
            // Create a new properties file
        }
    }
}
