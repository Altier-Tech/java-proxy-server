package tech.altier.AppProperties;

import tech.altier.Thread.ThreadColor;

import java.io.FileOutputStream;
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
        try {
            config.load(inputStream);
        } catch (IOException e) {
            log("Error loading " + propertyName + " properties: " + e.getMessage());
            throw new IOException(e);
        }
        assert inputStream != null;
        inputStream.close();
    }

    public static void storeProperties() {
        log("Saving application properties...");
        try (FileOutputStream outputStream = new FileOutputStream("src\\main\\resources\\application.properties")) {
            conf.store(outputStream, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
