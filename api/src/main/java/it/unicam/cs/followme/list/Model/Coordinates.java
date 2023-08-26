package it.unicam.cs.followme.list.Model;

public class Coordinates {
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

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
