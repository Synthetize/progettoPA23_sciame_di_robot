package it.unicam.cs.followme.list.Interfaces;

public interface CoordinatesInterface {
/**
     * Gets the x coordinate.
     * @return The x coordinate.
     */
    double getX();

    /**
     * Gets the y coordinate.
     * @return The y coordinate.
     */
    double getY();

    /**
     * Updates the coordinates
     * @param coordinate The coordinates to be added.
     * @return A new Coordinates object with the new values.
     */
    CoordinatesInterface updateCoordinates(CoordinatesInterface coordinate);

    void setX(double xValue);
    void setY(double yValue);
}
