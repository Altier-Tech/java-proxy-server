package tech.altier.Logger;

public interface Logger {
    void log(String message);
    void log(String message, String threadName);
    void log(String message, String threadName, String className);

    void logln(String message);
    void logln(String message, String threadName);
    void logln(String message, String threadName, String className);

    void error(String message);
    void error(String message, String threadName);
    void error(String message, String threadName, String className);
}
