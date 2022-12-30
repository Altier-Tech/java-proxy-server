package tech.altier.Logger;

class FileLogger implements Logger {
    private static final String LOG_FILE = "log.txt";

    @Override
    public void log(String message) {
        write(
                Thread.currentThread().getName() +
                "\t" +
                message
        );
    }

    @Override
    public void logln(String message) {
        write(
                Thread.currentThread().getName() +
                "\t" +
                message +
                "\n"
        );
    }

    @Override
    public void error(String message) {
        write(
                Thread.currentThread().getName() +
                "Error: " +
                "\t" +
                message
        );
    }

    private void write(String message) {
        
    }
}
