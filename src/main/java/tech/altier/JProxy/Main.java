package tech.altier.JProxy;

import tech.altier.AppProperties.PropertiesHandler;
import tech.altier.Logger.LogManager;
import tech.altier.Logger.LoggerType;
import tech.altier.Thread.ThreadColor;

import java.io.IOException;

public class Main {
    public static LogManager logger;
    public static PropertiesHandler applicationProperties;

    public static void main(String[] args) {
        // Init
        logger = new LogManager(LoggerType.CONSOLE);
        loadApplicationProperties();

        // Start the proxy server
        logger.logln("Starting proxy server...");

        // Exit
//        storeApplicationProperties();
    }

    private static void storeApplicationProperties() {
        applicationProperties.storeProperties();
    }

    private static void loadApplicationProperties() {
        try {
            applicationProperties = new PropertiesHandler("application").loadProperties();
        } catch (IOException e) {
            logger.log("Error loading application properties: " + e.getMessage());
            // Create a new properties file
        }
    }
}
