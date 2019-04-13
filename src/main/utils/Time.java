package main.utils;

import main.Display;

public class Time {
    // milliseconds
    public static final int timeToUpdateFrame = 1_000_000_000 / 30;
    // seconds
    public static final int timeToUpdateData = 1000;

    private static long delta;
    private static long currentNanoTime;
    private static long lastNanoTime;

    private static int fps = 0, updates = 0;
    private static long msTime;

    private Time() {}

    public static void init() {
        msTime = System.currentTimeMillis();
        lastNanoTime = System.nanoTime();
    }

    public static void updateFPS(Display display) {
        fps++;

        if (System.currentTimeMillis() - msTime >= Time.timeToUpdateData) {
            display.getFrame().setTitle(display.getTitle() + " | FPS: " + fps + ", Updates: " + updates);

            msTime += Time.timeToUpdateData;
            updates = 0;
            fps = 0;
        }
    }

    public static void updateDelta() {
        currentNanoTime = System.nanoTime();
        delta += currentNanoTime - lastNanoTime;
        lastNanoTime = currentNanoTime;
    }

    public static void resetDelta() {
        updates++;
        delta = 0;
    }

    public static long getDelta() {
        return delta;
    }
}
