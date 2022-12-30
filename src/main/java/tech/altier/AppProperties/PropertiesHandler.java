package tech.altier.AppProperties;

import tech.altier.Thread.ThreadColor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
    private String propertyName;

    public PropertiesHandler(String propertyName) {
        this.propertyName = propertyName;
    }

    private static Properties loadProperties() throws IOException {
        log("Loading  properties: " + propertyName);
        Properties configuration = new Properties();
        InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream("application.properties");
        configuration.load(inputStream);
        assert inputStream != null;
        inputStream.close();
        return configuration;
    }

    private static void log(String message) {
        System.out.println(
                ThreadColor.ANSI_CYAN +
                        Thread.currentThread().getName() +
                        "\tPropertiesHandler: \t" +
                        message
        );
    }
}