package it.unicam.cs.followme.list.Model;

import it.unicam.cs.followme.utilities.RobotCommand;

public class ProgramCommand {
    private String command;
    private double[] args;
    private String label;

    int repeat;

    public ProgramCommand(String comm, double[] args) {
        this.command = comm;
        this.args = args;
    }

    public ProgramCommand(String comm, String label) {
        this.command = comm;
        this.label = label;
    }

    public ProgramCommand(String comm, String label, double[] args) {
        this.command = comm;
        this.label = label;
        this.args = args;
    }

    public ProgramCommand(String comm, int n) {
        this.command = comm;
        this.repeat = n;
    }

    @Override
    public String toString() {
        return this.command + " " + this.label + " " + this.args;
    }

    public String getCommand() {
        return this.command;
    }

    public String getLabel() {
        return this.label;
    }

    public double[] getArgs() {
        return this.args;
    }

    public int getRepeat() {
        return this.repeat;
    }
}
