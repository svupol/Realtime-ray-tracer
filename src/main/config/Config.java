package main.config;

import main.utils.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String CONFIG_PATH = "./src/main/config/rrt.properties";
    private static final Logger LOG = new Logger(Config.class.getName());

    // Display width
    public static int window_width;
    // Display height
    public static int window_height;
    // field of view of camera
    public static int fov_horizontal;
    // Set maximum recursion limit for the ray tracing function
    public static int max_recursion;

    private Config() {}

    public static void initConfig() {
        File file = new File(CONFIG_PATH);

        if (file.exists() && !file.isDirectory()) {
            loadConfig();
        } else {
            createConfig();
            initConfig();
        }
    }

    private static void loadConfig() {
        FileInputStream fis;
        Properties properties = new Properties();

        try {
            fis = new FileInputStream(CONFIG_PATH);
            properties.load(fis);

            window_width = Integer.valueOf(properties.getProperty("window_width"));
            window_height = Integer.valueOf(properties.getProperty("window_height"));
            max_recursion = Integer.valueOf(properties.getProperty("max_recursion"));
            fov_horizontal = Integer.valueOf(properties.getProperty("fov_horizontal"));

            LOG.printMessage(CONFIG_PATH + " loaded successfully!");
        } catch (IOException e) {
            LOG.printError(e.getMessage());
            System.exit(1);
        }
    }

    private static void createConfig() {
        FileOutputStream fos;
        Properties properties = new Properties();

        try {
            fos = new FileOutputStream(CONFIG_PATH);

            properties.setProperty("window_width", "1280");
            properties.setProperty("window_height", "720");
            properties.setProperty("max_recursion", "2");
            properties.setProperty("fov_horizontal", "90");

            properties.store(fos, CONFIG_PATH);
            fos.close();

            LOG.printMessage(CONFIG_PATH + " created successfully!");
        } catch (IOException e) {
            LOG.printError(e.getMessage());
            System.exit(1);
        }
    }
}
