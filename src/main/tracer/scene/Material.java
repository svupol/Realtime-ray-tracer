package main.tracer.scene;

public class Material {
    private int r, g, b;

    public Material(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getRGB() {
        int rgb = (r << 8) + g;

        return  (rgb << 8) + b;
    }

    public int getRGB(float alpha) {
        int rgb = (getR(alpha) << 8) + getG(alpha);

        return  (rgb << 8) + getB(alpha);
    }

    private int getR(float alpha) {
        return (int) (r * alpha);
    }

    private int getG(float alpha) {
        return (int) (g * alpha);
    }

    private int getB(float alpha) {
        return (int) (b * alpha);
    }
}
