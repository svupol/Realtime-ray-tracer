package main.tracer.scene;

import main.utils.mathUtils.Vector;

public class Illuminant {
    private Vector position;
    private float intensity;

    public Illuminant(Vector position, float intensity) {
        this.position = position;
        this.intensity = intensity;
    }

    public Vector getPosition() {
        return position;
    }

    public float getIntensity() {
        return intensity;
    }
}
