package main.tracer.scene.models;

import main.tracer.Ray;
import main.utils.mathUtils.Intersection;
import main.utils.mathUtils.Primitive;
import main.utils.mathUtils.Vector;

public class Sphere extends Primitive {
    private int radius;

    public Sphere(Vector center, int radius) {
        super(center);
        this.radius = radius;
    }

    public Intersection intersect(Ray ray) {
        Vector D = ray.getDirection();
        Vector CO = ray.getPosition().sub(super.polygons[0]);

        float a = D.dotProduct(D);
        float b = 2*CO.dotProduct(D);
        float c = CO.dotProduct(CO) - (radius*radius);

        float Discriminant = b*b - 4*a*c;

        if (Discriminant < 0) return null;

        float t1 =  (float) (-b + Math.sqrt(Discriminant)) / (2*a);
        float t2 =  (float) (-b - Math.sqrt(Discriminant)) / (2*a);

        float t;
        if (t1 < t2)
            t = t1;
        else
            t = t2;

        Vector point = D.scale(t).add(ray.getPosition());
        Vector normal = point.sub(super.polygons[0]).normalize();

        return new Intersection(point, t, normal);
    }
}
