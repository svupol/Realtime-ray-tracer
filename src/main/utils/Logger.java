package main.utils;

public class Logger {
    private String name;

    public Logger(String name) {
        this.name = name;

        printMessage("Logger has started");
    }

    public void printMessage(String message) {
        System.out.println("[" + name + "]: " + message);
    }

    public void printError(String error) {
        System.out.println("[" + name + "]: ERROR " + error);
    }
}
