package tech.altier.ProxyServer;

import tech.altier.AppProperties.PropertiesHandler;

import java.io.IOException;

public class Main {
    public static PropertiesHandler applicationProperties;

    public static void main(String[] args) {
        try {
            applicationProperties = new PropertiesHandler("application").loadProperties();
        } catch (IOException e) {
            log("Error loading application properties: " + e.getMessage());
            // Create a new properties file
        }
    }
}
