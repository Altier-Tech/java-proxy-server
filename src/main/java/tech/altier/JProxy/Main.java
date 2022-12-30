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
//        loadApplicationProperties();
        logger = new LogManager(LoggerType.CONSOLE);

        // Start the proxy server

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
            log("Error loading application properties: " + e.getMessage());
            // Create a new properties file
        }
    }

    private static void log(String message) {
        System.out.println(
                ThreadColor.ANSI_CYAN +
                Thread.currentThread().getName() +
                "\tMainClass: \t" +
                message
        );
    }
}
