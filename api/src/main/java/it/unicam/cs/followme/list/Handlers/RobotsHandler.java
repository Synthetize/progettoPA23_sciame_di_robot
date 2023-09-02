package it.unicam.cs.followme.list.Handlers;

import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Model.Coordinates;
import it.unicam.cs.followme.list.Model.Robot;

import java.util.HashMap;

public class RobotsHandler  {

    public RobotsHandler() {
    }

    static public HashMap<RobotInterface, Coordinates> addRobotAtChosenPosition() {
        int numberOfRobots = 1; //add controller
        HashMap<RobotInterface, Coordinates> robotPositions = new HashMap<>();
        for (int i = 0; i < numberOfRobots; i++) {
            //add coordinates input
            //Robot.robotCount++;
            robotPositions.put(new Robot(), new Coordinates(0,0));

        }
        return robotPositions;
    }

}
