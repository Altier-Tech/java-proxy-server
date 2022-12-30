package tech.altier.ProxyServer;

import tech.altier.AppProperties.PropertiesHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            PropertiesHandler applicationProperties = new PropertiesHandler("application").loadProperties();
        } catch (IOException e) {
            log
        }
    }
}
