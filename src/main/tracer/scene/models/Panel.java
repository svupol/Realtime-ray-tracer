package main.tracer.scene.models;

import main.tracer.Ray;
import main.utils.mathUtils.Intersection;
import main.utils.mathUtils.Primitive;
import main.utils.mathUtils.Vector;

public class Panel extends Primitive {
    private Vector direction;

    public Panel(Vector center, Vector direction) {
        super(center);

        this.direction = direction.normalize();
    }

    public Intersection intersect(Ray ray) {
        float D = super.polygons[0].length();

        if (ray.getDirection().dotProduct(direction) == 0) return null;

        float t = - (D + ray.getPosition().dotProduct(direction)) / ray.getDirection().dotProduct(direction);
        Vector point = ray.getPosition().add(ray.getDirection().scale(t));

        return new Intersection(point, t, direction);
    }
}
