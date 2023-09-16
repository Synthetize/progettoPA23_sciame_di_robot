package it.unicam.cs.followme.list.Interfaces;
import it.unicam.cs.followme.list.Model.RobotDirection;
import java.util.ArrayList;

/**
 * This interface defines the contract for creating a new robot
 * to be added to the environment.
 */
public interface RobotInterface {
    /**
     * Returns the current labels associated with the robot.
     * @return The list of current labels.
     */
    ArrayList<String> getCurrentLabels();

    /**
     * Adds a label to the robot.
     * @param label The label to be added.
     */
    void addLabel(String label);

    /**
     * Removes a label from the robot.
     * @param label The label to be removed.
     */
    void removeLabel(String label);

    /**
     * Gets the current direction of the robot.
     * @return The direction of the robot.
     */
    RobotDirection getDirection();

    /**
     * Sets the direction and speed of the robot.
     * @param xValue The X-component of the direction vector.
     * @param yValue The Y-component of the direction vector.
     * @param speed  The speed of the robot.
     */
    void setDirection(double xValue, double yValue, double speed);



}