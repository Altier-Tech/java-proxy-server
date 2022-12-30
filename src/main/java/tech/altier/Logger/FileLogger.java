package tech.altier.Logger;

class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("FileLogger: " + message);
    }

    @Override
    public void logln(String message) {
        System.out.println("FileLogger: " + message);
    }

    @Override
    public void error(String message) {
        System.out.println("FileLogger: " + message);
    }
}
}
