package it.unicam.cs.followme.list.Model.Shapes;

import it.unicam.cs.followme.list.Model.Coordinates;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.utilities.ShapeData;

public class CircleShape implements ShapeInterface {
    private final String label;
    private final Coordinates coordinates;
    private final double radius;

    public CircleShape(String label, double[] args) {
        this.label = label;
        this.coordinates = new Coordinates(args[0], args[1]);
        this.radius = args[2];
    }
    public CircleShape(ShapeData shapeData) {
        this(shapeData.label(), shapeData.args());
    }

    public String getLabel() {
        return this.label;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public double getRadius() {
        return radius;
    }

    public String toString() {
        return "Circle " + this.label + " with radius " + this.radius + " at coordinates " + this.coordinates;
    }
    @Override
    public boolean isTheRobotInsideTheShape(Coordinates robotCoordinates) {
        double distance = Math.sqrt(Math.pow(robotCoordinates.getX() - this.coordinates.getX(), 2) + Math.pow(robotCoordinates.getY() - this.coordinates.getY(), 2));
        return distance <= this.radius;
    }

}
