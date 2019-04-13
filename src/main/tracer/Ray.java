package main.tracer;

import main.Display;
import main.utils.mathUtils.Vector;

public class Ray {
    private Vector direction;
    private Vector position;

    public Ray(Vector position, Vector direction) {
        this.position = position;
        this.direction = direction; // не нормализированный вектор
    }

    public static Ray calcRay(int Dx, int Dy, Display display, Viewport viewport, Camera camera) {
        // Изменяем систему координат
        int Cx = Dx - (display.getWidth() / 2);
        int Cy = (display.getHeight() / 2) - Dy;

        // Нормализируем пиксели холста к пикселям окна просмотра
        int Vx = Cx * (viewport.getWidth() / display.getWidth());
        int Vy = Cy * (viewport.getHeight() / display.getHeight());

        Vector dir = new Vector(Vx, Vy, viewport.getFocalLength());

        return new Ray(camera.getPosition(), dir);
    }

    public Vector getDirection() {
        return direction;
    }

    public Vector getPosition() {
        return position;
    }
}
