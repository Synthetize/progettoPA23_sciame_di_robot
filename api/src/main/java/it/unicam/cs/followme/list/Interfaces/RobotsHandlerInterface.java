package it.unicam.cs.followme.list.Interfaces;

import it.unicam.cs.followme.list.Model.Coordinates;
import it.unicam.cs.followme.list.Model.Robot;

import java.util.ArrayList;
import java.util.HashMap;

public interface RobotsHandlerInterface {
    static HashMap<RobotInterface, Coordinates> addRobotAtChosenPosition(ArrayList<Coordinates> robotCoordinates) {
        HashMap<RobotInterface, Coordinates> robotPositions = new HashMap<>();
        for (Coordinates robotCoordinate : robotCoordinates) {
            robotPositions.put(new Robot(), robotCoordinate);
        }
        return robotPositions;
    }
}
