package main.utils.mathUtils;

public class Vector {
    public float x, y, z;

    public Vector() {
        this.x = 0f;
        this.y = 0f;
        this.z = 0f;
    }

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector set(Vector vector) {
        this.x = vector.x;
        this.y = vector.y;
        this.z = vector.z;

        return this;
    }

    public Vector set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;

        return this;
    }

    public String toString() {
        return this.x + " " + this.y + " " + this.z;
    }

    public Vector add(float x, float y, float z) {
        return new Vector(this.x + x, this.y + y, this.z + z);
    }

    public Vector add(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector sub(float x, float y, float z) {
        return new Vector(this.x - x, this.y - y, this.z - z);
    }

    public Vector sub(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    public Vector scale(float t) {
        return new Vector(x * t, y * t, z * t);
    }

    public float dotProduct(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public float dotProduct(float x, float y, float z) {
        return this.x * x + this.y * y + this.z * z;
    }

    public float length() {
        return (float) Math.sqrt(x*x + y*y + z*z);
    }

    public Vector normalize() {
        float length = this.length();

        return new Vector(x / length, y / length, z / length);
    }
}
