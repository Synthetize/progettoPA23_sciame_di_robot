package it.unicam.cs.followme.list.Interfaces;

import it.unicam.cs.followme.list.Model.Coordinates;

/**
 * This interface defines the contract for creating new shapes
 * to be placed within the environment.
 */
public interface ShapeInterface {
    /**
     * Returns the label associated with this shape.
     *
     * @return The label of the shape.
     */
    String getLabel();
    /**
     * Returns the coordinates of the shape within the environment.
     *
     * @return The coordinates of the shape.
     */
    Coordinates getCoordinates();

    boolean isTheRobotInsideTheShape(Coordinates robotCoordinates);
}
