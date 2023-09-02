package it.unicam.cs.followme.list.Model;

import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Handlers.ParserHandler;

import java.util.ArrayList;

public class Robot implements RobotInterface {

    public static int robotCount = 0;
    private int robotId;
    private ArrayList<String> labels;


    public Robot() {
        robotId = robotCount;
        labels = new ArrayList<>();
    }


    @Override
    public int getRobotId() {
        return this.robotId;
    }

    @Override
    public ArrayList<String> getCurrentLabels() {
        return labels;
    }
    @Override
    public void addLabel(String label) {
        this.labels.add(label);
    }



}
