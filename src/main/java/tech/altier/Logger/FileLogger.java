package tech.altier.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class FileLogger implements Logger {
    private static final String LOG_FILE = "_log.txt";

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
        Path fileName = Path.of(
            "logs\\" +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) +
                LOG_FILE
        );


        try {
            Files.writeString(fileName, message);
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
