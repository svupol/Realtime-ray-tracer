package main.tracer.scene;

import main.tracer.scene.models.*;
import main.utils.mathUtils.Vector;

import java.util.ArrayList;

public class Scene {
    private ArrayList<Model> models = new ArrayList<>();
    private ArrayList<Illuminant> illuminants = new ArrayList<>();

    public final float ambientLight = 0.1f;

    public Scene() {
        // models
        Material skyblue = new Material(148, 206, 219);
        Material red = new Material(255,151,82);
        Material light_green = new Material(204,255,102);
        Material light_purple = new Material(196,136,215);

        Panel floor = new Panel(new Vector(0, -200, 0), new Vector(0, 1, 0));
        Sphere sphere_1 = new Sphere(new Vector(0, -200, 600), 150);
        Sphere sphere_2 = new Sphere(new Vector(500, 0, 600), 150);

        models.add(new Model(floor, skyblue));
        models.add(new Model(sphere_1, light_purple));
        models.add(new Model(sphere_2, light_green));

        // light
        Illuminant illuminant1 = new Illuminant(new Vector(-250, 200, 400), 0.9f);

        illuminants.add(illuminant1);
    }

    public ArrayList<Model> getModels() {
        return models;
    }

    public ArrayList<Illuminant> getIlluminants() {
        return illuminants;
    }
}
