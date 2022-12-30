package tech.altier.Logger;

import tech.altier.Thread.ThreadColor;

class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.print(
                LogManager.getColor(Thread.currentThread().getName()) +
                Thread.currentThread().getName() +
                "\t" +
                message
        );
    }

    @Override
    public void logln(String message) {
        System.out.println(
                LogManager.getColor(Thread.currentThread().getName()) +
                "T(" +
                Thread.currentThread().getName() +
                ")\tM(" +
                LogManager.getMethodName() +
                ")\t" +
                message
        );
    }

    @Override
    public void error(String message) {
        System.out.println(
                ThreadColor.ANSI_RED +
                Thread.currentThread().getName() +
                "\t" +
                message
        );
    }
}
