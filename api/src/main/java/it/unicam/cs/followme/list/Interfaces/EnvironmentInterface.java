package it.unicam.cs.followme.list.Interfaces;

import it.unicam.cs.followme.list.Model.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;

public interface EnvironmentInterface<R extends RobotInterface, S extends ShapeInterface> {


    ArrayList<S> getShapes();

    HashMap<R, Coordinates> getRobot();
}
