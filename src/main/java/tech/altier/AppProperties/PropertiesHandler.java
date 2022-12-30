package tech.altier.AppProperties;

import tech.altier.Thread.ThreadColor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
    private Properties config;
    private final String propertyName;

    public PropertiesHandler(String propertyName) {
        this.propertyName = propertyName;
    }

    private void loadProperties() throws IOException {
        log("Loading  properties: " + propertyName);
        config = new Properties();
        InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream("application.properties");
        config.load(inputStream);
        assert inputStream != null;
        inputStream.close();
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
