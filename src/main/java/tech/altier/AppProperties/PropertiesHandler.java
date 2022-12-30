package tech.altier.AppProperties;

import tech.altier.Thread.ThreadColor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class is used to handle properties files.
 * An instance of this class can load all the written properties into a memory and
 * the get / set methods provided can be applied on those properties. Then it can
 * save the properties back to the file for later retrieval.
 * @author Dilshan Karunarathne
 * @version 2.0
 * @since 2020-10-01
 */
public class PropertiesHandler {
    private Properties config;
    private final String propertyName;

    public PropertiesHandler(String propertyName) {
        this.propertyName = propertyName;
    }

    public void loadProperties() throws IOException {
        log("Loading  properties: " + propertyName);
        config = new Properties();
        InputStream inputStream = PropertiesHandler.class
                .getClassLoader()
                .getResourceAsStream(propertyName + ".properties");
        try {
            config.load(inputStream);
        } catch (IOException e) {
            log("Error loading " + propertyName + " properties: " + e.getMessage());
            throw new IOException(e);
        }
        assert inputStream != null;
        inputStream.close();
    }

    public void storeProperties() {
        log("Saving application properties...");
        try (FileOutputStream outputStream = new FileOutputStream
                ("src\\main\\resources\\" + propertyName + ".properties")) {
            config.store(outputStream, null);
        } catch (IOException e) {
            log("Error saving " + propertyName + " properties: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public String get(String key) {
        return config.getProperty(key);
    }

    public void set(String key, String value) {
        log("Setting " + key + " in " + propertyName + " properties...");
        config.setProperty(key, value);
    }

    private static void log(String message) {
        System.out.println(
                ThreadColor.ANSI_YELLOW +
                        Thread.currentThread().getName() +
                        "\tPropertiesHandler: \t" +
                        message
        );
    }
}
