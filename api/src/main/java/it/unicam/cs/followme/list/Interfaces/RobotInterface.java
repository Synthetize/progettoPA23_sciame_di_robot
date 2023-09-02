package it.unicam.cs.followme.list.Interfaces;

import it.unicam.cs.followme.list.LinkedList;
import it.unicam.cs.followme.list.Model.ProgramCommand;

import java.util.ArrayList;

public interface RobotInterface {
    int getRobotId();
    ArrayList<String> getCurrentLabels();
    void addLabel(String label);
}