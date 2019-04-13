package main.tracer;

import main.utils.mathUtils.Vector;

public class Camera {
    private Vector position;
    private Vector direction;

    public Camera(Vector position, Vector direction) {
        this.position = position;
        this.direction = direction;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = this.position.add(position);
    }
}
