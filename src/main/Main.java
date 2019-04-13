package main;

import main.config.Config;

public class Main {
    public static final String TITLE = "Realtime ray tracing";

    public static Display display;
    public static Engine engine;

    public static void main(String[] args) {
        Config.initConfig();

        display = new Display(Config.window_width, Config.window_height, TITLE);
        display.create();

        engine = new Engine(display);
        engine.start();
    }
}
