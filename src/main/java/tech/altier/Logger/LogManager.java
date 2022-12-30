package tech.altier.Logger;

import tech.altier.Thread.ThreadColor;

public class LogManager {
    private static final Logger logger;
    private static String[] colors = {
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

    public static String getColor() {

    }
}
