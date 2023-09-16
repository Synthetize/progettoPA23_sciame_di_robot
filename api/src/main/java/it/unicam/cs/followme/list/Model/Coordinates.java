package it.unicam.cs.followme.list.Model;
import it.unicam.cs.followme.list.Interfaces.CoordinatesInterface;

public class Coordinates implements CoordinatesInterface {
    double x;
    double y;
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public void setX(double xValue) {
        this.x = xValue;
    }
    public void setY(double yValue) {
        this.y = yValue;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
    public Coordinates updateCoordinates(CoordinatesInterface coordinate) {
        return new Coordinates(this.x + coordinate.getX(), this.y + coordinate.getY());
    }
}
