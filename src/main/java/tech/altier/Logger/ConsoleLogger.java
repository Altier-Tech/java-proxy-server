package tech.altier.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.print(message);
    }

    @Override
    public void log(String message, String threadName) {
        System.out.print(threadName + "\t" + message);
    }

    @Override
    public void log(String message, String threadName, String className) {
        System.out.print(threadName + "\t" + className + ": \t" + message);
    }

    @Override
    public void logln(String message) {

    }

    @Override
    public void logln(String message, String threadName) {

    }

    @Override
    public void logln(String message, String threadName, String className) {

    }

    @Override
    public void error(String message) {

    }

    @Override
    public void error(String message, String threadName) {

    }

    @Override
    public void error(String message, String threadName, String className) {

    }
}
