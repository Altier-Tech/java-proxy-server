package tech.altier.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }

    @Override
    public void log(String message, String threadName) {
        System.out.println(
                threadName +
                "\t" +
                message
        );
    }

    @Override
    public void log(String message, String threadName, String className) {
        System.out.println(
                threadName +
                "\t" +
                className +
                "\t" +
                message
        );
    }

    @Override
    public void error(String message) {
        System.err.println(message);
    }

    @Override
    public void error(String message, String threadName) {
        System.err.println(
                threadName +
                "\t" +
                message
        );
    }

    @Override
    public void error(String message, String threadName, String className) {
        System.err.println(
                threadName +
                "\t" +
                className +
                "\t" +
                message
        );
    }
}
