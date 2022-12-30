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
            ThreadColor.ANSI_RED,
            ThreadColor.ANSI_BLACK
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

    static String getColor(String threadName) {
        return colors[threadName.hashCode() % colors.length];
    }
}
