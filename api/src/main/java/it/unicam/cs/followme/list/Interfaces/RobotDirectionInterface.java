package it.unicam.cs.followme.list.Interfaces;

import it.unicam.cs.followme.list.Model.Coordinates;

/**
 * This interface defines the contract for specifying the direction of a robot
 */
public interface RobotDirectionInterface {
    /**
     * Gets the speed of the robot's movement.
     * @return The speed of the robot.
     */
    double getSpeed();

    /**
     * Gets the coordinates representing the direction of the robot.
     * @return The coordinates of the robot's direction.
     */
    Coordinates getCoordinates();

}
