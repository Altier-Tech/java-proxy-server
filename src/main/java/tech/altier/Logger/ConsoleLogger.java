package tech.altier.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.print(Thread.currentThread().getName() + "\t" + message);
    }

    @Override
    public void logln(String message) {
        System.out.println(Thread.currentThread().getName() + "\t" + message);
    }

    @Override
    public void error(String message) {
        System.out.println(
                
                Thread.currentThread().getName() +
                "\t" +
                message);
    }
}
