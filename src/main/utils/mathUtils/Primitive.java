package main.utils.mathUtils;

import main.tracer.Ray;

public class Primitive {
    public Vector[] polygons;

    public Primitive(Vector position) {
        polygons = new Vector[1];
        polygons[0] = position;
    }

    public Primitive(Vector[] polygons) {
        this.polygons = polygons;
    }

    public Intersection intersect(Ray ray) {
        return null;
    }
}
