package tech.altier.AppProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
    public PropertiesHandler(String propertyName) {
    }

    private static Properties loadProperties() throws IOException {
        log("Loading application properties...");
        Properties configuration = new Properties();
        InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream("application.properties");
        configuration.load(inputStream);
        assert inputStream != null;
        inputStream.close();
        return configuration;
    }
}
