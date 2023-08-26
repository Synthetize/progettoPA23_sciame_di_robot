package it.unicam.cs.followme.list.Model;
import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.utilities.FollowMeParser;

import java.util.ArrayList;
import java.util.HashMap;

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
    public HashMap<R, Coordinates> getRobot() {
        return this.robotsArray;
    }

    public Coordinates getCoordinatesOf(R robot) {
        return this.robotsArray.get(robot);
    }


}

