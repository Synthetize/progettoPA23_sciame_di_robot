package it.unicam.cs.followme.list.Model;

import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Handlers.ParserHandler;

import java.util.ArrayList;

public class Robot implements RobotInterface {

    public static int robotCount = 0;
    private int robotId;


    public Robot() {
        robotId = robotCount;
    }


    @Override
    public int getRobotId() {
        return this.robotId;
    }

    public String toString() {
        return "Robot " + this.robotId;
    }



}
