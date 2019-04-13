package main.tracer.scene;

import main.utils.mathUtils.Primitive;

public class Model {
    private Primitive primitive;
    private Material material;

    public Model(Primitive primitive, Material material) {
        this.primitive = primitive;
        this.material = material;
    }

    public Model(Material material) {
        this.material = material;
    }

    public Model(Primitive primitive) {
        this.primitive = primitive;
    }

    public Primitive getPrimitive() {
        return primitive;
    }

    public void setPrimitive(Primitive primitive) {
        this.primitive = primitive;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
