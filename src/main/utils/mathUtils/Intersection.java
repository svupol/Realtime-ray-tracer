package main.utils.mathUtils;

public class Intersection {
    private Vector point;
    private Vector normal;
    private float t;

    public Intersection(Vector point, float t, Vector normal) {
        this.normal = normal;
        this.point = point;
        this.t = t;
    }

    public Vector getPoint() {
        return point;
    }

    public float getT() {
        return t;
    }

    public Vector getNormal() {
        return normal;
    }
}
