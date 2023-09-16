package it.unicam.cs.followme.list.Model;
import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.utilities.FollowMeParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Environment<R extends RobotInterface,S extends ShapeInterface> implements EnvironmentInterface<R,S> {
    private ArrayList<S> shapesArray;
    private HashMap<R, Coordinates> robotsArray;
    private FollowMeParser parser;

    public Environment(ArrayList<S> shapes, HashMap<R, Coordinates> robots) {
        this.shapesArray = shapes;
        this.robotsArray = robots;

    }

    @Override
    public ArrayList<S> getShapes() {
        return this.shapesArray;
    }

    @Override
    public Coordinates getCoordinatesOf(R robot) {
        return this.robotsArray.get(robot);
    }

    @Override
    public void updateRobotPosition(R robot, Coordinates updatedRobotCoordinate) {
        this.robotsArray.put(robot, updatedRobotCoordinate);
    }

    @Override
    public HashMap<R, Coordinates> getRobotsHashMap() {
        return robotsArray;
    }

    @Override
    public double calculateDistanceBetweenTwoRobots(R robot1, R robot2){
        Coordinates coordinatesRobot1 = getCoordinatesOf(robot1);
        Coordinates coordinatesRobot2 = getCoordinatesOf(robot2);
        return Math.sqrt(Math.pow(coordinatesRobot2.getX() - coordinatesRobot1.getX(), 2) + Math.pow(coordinatesRobot2.getY() - coordinatesRobot1.getY(), 2));
    };
    @Override
    public List<String> checkIfRobotIsInsideShapes(R robot) {
            return shapesArray.stream()
                    .filter(shape -> shape.isTheRobotInsideTheShape(this.getCoordinatesOf(robot)))
                    .map(ShapeInterface::getLabel).toList();
    }


}

