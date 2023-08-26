package it.unicam.cs.followme.list.Model.Shapes;

import it.unicam.cs.followme.list.Model.Coordinates;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.utilities.ShapeData;

public class CircleShape implements ShapeInterface {
    private String label;
    private Coordinates coordinates;
    private double radius;

    public CircleShape(String label, double[] args) {
        this.label = label;
        this.coordinates = new Coordinates(args[0], args[1]);
        this.radius = args[2];
    }
    public CircleShape(ShapeData shapeData) {
        this(shapeData.label(), shapeData.args());
    }

    public double calculateArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public String getLabel() {
        return this.label;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public String toString() {
        return "Circle " + this.label + " with radius " + this.radius + " at coordinates " + this.coordinates;
    }

}
