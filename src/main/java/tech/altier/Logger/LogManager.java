package tech.altier.Logger;

public class LogManager {
    private static Logger logger;

    public LogManager(LoggerType type) {
        switch (type) {
            case CONSOLE:
                logger = new ConsoleLogger();
                break;
            case FILE:
                logger = new FileLogger();
                break;
            case BOTH:
                logger = new DualLogger();
                break;
        }
    }

    public LogManager() {
        this(LoggerType.CONSOLE);
    }
}
