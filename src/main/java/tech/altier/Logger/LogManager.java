package tech.altier.Logger;

import tech.altier.Thread.ThreadColor;

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
        int hash = (threadName.hashCode() + getClassName().hashCode() > 0) ?
                (threadName.hashCode() + getClassName().hashCode()) :
                (-1*(threadName.hashCode() + getClassName().hashCode()));
        return colors[hash % colors.length];
    }

    public static String getClassName() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        int count = 0;
        for (StackTraceElement element : elements) {
            if (
                    element.getClassName().equalsIgnoreCase("tech.altier.Logger.LogManager")
                    && (
                            element.getMethodName().equalsIgnoreCase("log")
                            || element.getMethodName().equalsIgnoreCase("logln")
                    )
            ) {
                break;
            }
            count++;
        }

        return elements[count + 1].getClassName();
    }
}
