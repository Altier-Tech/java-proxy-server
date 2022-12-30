package tech.altier.AppProperties;

import tech.altier.JProxy.Main;
import tech.altier.Thread.ThreadColor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * This class is used to handle properties files.
 * An instance of this class can load all the written properties into a memory and
 * the get / set methods provided can be applied on those properties. Then it can
 * save the properties back to the file for later retrieval.
 * @author Dilshan Karunarathne
 * @version 2.0
 * @since 2020-10-01
 * @see Properties
 */
public class PropertiesHandler {
    private Properties config;
    private final String propertyName;

    /**
     * This constructor is used to create an instance of the PropertiesHandler class
     * for a given properties file.
     * The propertyName String parameter should be the name of the properties file
     * without the file extension.
     * @param propertyName name of the properties file
     */
    public PropertiesHandler(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * This method is used to load the properties from the properties file into the
     * memory. This method should be called before any get / set methods are called.
     * This method can be called, chained with the constructor, or called separately.
     * @return the PropertiesHandler instance with the loaded properties
     * @throws IOException if the properties file is not found or cannot be read
     */
    public PropertiesHandler loadProperties() throws IOException {
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

        return this;
    }

    /**
     * This method is used to save the properties back to the properties file.
     * This method should be called after all the get / set methods are called
     * and at the end of the program.
     * @throws RuntimeException if the properties file is not found or cannot be written
     */
    public void storeProperties() {
        log("Saving " + propertyName + ".properties...");
        try (FileOutputStream outputStream = new FileOutputStream
                ("src\\main\\resources\\" + propertyName + ".properties")) {
            config.store(outputStream, null);
        } catch (IOException e) {
            log("Error saving " + propertyName + ".properties: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to get a property value from the loaded properties.
     * It returns null if the property is not found.
     * @param key the key of the property
     * @return the value of the property
     */
    public String get(String key) {
        return config.getProperty(key);
    }

    /**
     * This method is used to set a property value to the loaded properties.
     * If the key already exists, the value will be overwritten. Otherwise, a new
     * property will be created.
     * @param key the key of the property
     * @param value the value of the property
     */
    public void set(String key, String value) {
        log("Setting " + key + " in " + propertyName + ".properties");
        config.setProperty(key, value);
    }

    private static void log(String message) {
        Main.logger.logln(message);
    }
}
