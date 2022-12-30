package tech.altier.Logger;

class DualLogger implements Logger {
    private final Logger consoleLogger;
    private final Logger fileLogger;

    public DualLogger() {
        consoleLogger = new ConsoleLogger();
        fileLogger = new FileLogger();
    }

    @Override
    public void log(String message) {
        consoleLogger.log(message);
        fileLogger.log(message);
    }

    @Override
    public void logln(String message) {
        consoleLogger.logln(message);
        fileLogger.logln(message);
    }

    @Override
    public void error(String message) {
        consoleLogger.error(message);
        fileLogger.error(message);
    }
}
