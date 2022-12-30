package tech.altier.Logger;

class FileLogger implements Logger {
    @Override
    public void log(String message) {
        write("FileLogger: " + message);
    }

    @Override
    public void logln(String message) {
        write("FileLogger: " + message + "/n");
    }

    @Override
    public void error(String message) {
        write("FileLogger: " + message);
    }

    private void write(String message) {
        // Write to file
    }
}
