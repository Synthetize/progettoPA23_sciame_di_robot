package it.unicam.cs.followme.list.Interfaces;
import it.unicam.cs.followme.list.Model.Coordinates;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This interface defines the contract for an environment that contains robots and shapes.
 *
 * @param <R> The type representing a robot that implements the RobotInterface.
 * @param <S> The type representing a shape that implements the ShapeInterface.
 */
public interface EnvironmentInterface<R extends RobotInterface, S extends ShapeInterface> {
    /**
     * Returns a list of shapes present in the environment.
     * @return An ArrayList of shapes.
     */
    ArrayList<S> getShapes();

    /**
     * Gets the coordinates of a specific robot in the environment.
     * @param robot The robot for which coordinates are requested.
     * @return The coordinates of the specified robot.
     */
    Coordinates getCoordinatesOf(R robot);

    /**
     * Updates the position of a robot in the environment.
     * @param robot                The robot whose position needs to be updated.
     * @param updatedRobotCoordinate The updated coordinates for the robot.
     */
    void updateRobotPosition(R robot, Coordinates updatedRobotCoordinate);

    /**
     * Returns a mapping of robots to their coordinates in the environment.
     * @return A HashMap containing robot-coordinate pairs.
     */
    HashMap<R, Coordinates> getRobotsHashMap();

    /**
     * Calculates the distance between two robots in the environment.
     * @param robot1 The first robot.
     * @param robot2 The second robot.
     * @return The distance between the two robots.
     */
    double calculateDistanceBetweenTwoRobots(R robot1, R robot2);

    List<String> checkIfRobotIsInsideShapes(R robot);
}
