package tech.altier.Logger;

import tech.altier.Thread.ThreadColor;

import java.util.stream.Collectors;

public class LogManager {
    private static Logger logger = null;
    private static final String[] colors = {
            ThreadColor.ANSI_CYAN,
            ThreadColor.ANSI_PURPLE,
            ThreadColor.ANSI_BLUE,
            ThreadColor.ANSI_GREEN,
            ThreadColor.ANSI_YELLOW,
            ThreadColor.ANSI_LIGHT_YELLOW,
    };

    public LogManager(LoggerType type) {
        switch (type) {
            case CONSOLE -> logger = new ConsoleLogger();
            case FILE -> logger = new FileLogger();
            case BOTH -> logger = new DualLogger();
        }
    }

    public LogManager() {
        this(LoggerType.CONSOLE);
    }

    public void log(String message) {
        logger.log(message);
    }

    public void logln(String message) {
        logger.logln(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    static String getColor(String threadName) {
        return colors[(
                        threadName.hashCode() +
                                Thread.currentThread().getStackTrace()[4]
                                .getMethodName()
                                .hashCode()
                ) % colors.length];
    }

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }
}
