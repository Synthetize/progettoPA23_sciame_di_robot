package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Model.Robot;

import java.io.StringReader;

public class ExecuteBasicCommands {
    Robot robot;
    public ExecuteBasicCommands() {
    }

    public void move(double x, double y, double speed) {
        System.out.println("MOVE");

    }

    public void moveRandom(double x1, double x2, double y1, double y2) {
        System.out.println("RANDOM");
    }
    public void signal(String label) {
        System.out.println("SIGNAL");
    }
    public void unsignal(String label) {
        System.out.println("UNSGINA");
    }
    public void follow(String label, double dist, double speed) {
        System.out.println("FOLLOW");
    }
}
