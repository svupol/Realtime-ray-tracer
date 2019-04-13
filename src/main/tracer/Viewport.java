package main.tracer;

import main.Display;
import main.utils.Logger;

public class Viewport {
    private final Logger LOG = new Logger(Viewport.class.getName());

    private int width, height;
    private float focalLength;
    private float AR;
    private int FOVx;

    public Viewport(Display display, int FOVx) {
        AR = display.getAspectRatio();

        this.width = display.getWidth();
        this.height = display.getHeight();

        this.FOVx = FOVx;
        this.focalLength = computedFocalLength();
    }

    public float computedFocalLength() {
        return width / (float) (2 * Math.tan(Math.toRadians(FOVx / 2.0)));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getFocalLength() {
        return focalLength;
    }
}
