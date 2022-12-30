package tech.altier.AppProperties;

import tech.altier.Thread.ThreadColor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    static Properties conf;

    static {
        try {
            conf = loadProperties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public static void storeApplicationProperties() {
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
                        "\tPropertiesLoader: \t" +
                        message
        );
    }

    public static String get(String key) {
        return conf.getProperty(key);
    }

    public static void set(String key, String value) {
        log("Setting " + key + " in application properties...");
        conf.setProperty(key, value);
    }
}