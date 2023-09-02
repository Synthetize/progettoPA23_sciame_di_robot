package it.unicam.cs.followme.list.Model;

import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.ProgramExecution.ExecuteLoopsCommand;
import it.unicam.cs.followme.list.ProgramExecution.ExecuteRepeatCommand;
import it.unicam.cs.followme.utilities.RobotCommand;

public class ProgramCommand<R extends RobotInterface, S extends ShapeInterface> {
    private String command;
    private double[] args;
    private String label;

    private ExecuteLoopsCommand<R,S> loop;

    

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

    public ProgramCommand(String comm, ExecuteLoopsCommand<R,S> loop) {
        this.command = comm;
        this.loop = loop;
    }

    @Override
    public String toString() {
        return this.command;
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

    public int getNumberOfRepetitions() {
        return this.repeat;
    }

    public ExecuteLoopsCommand<R, S> getLoop(){
        return this.loop;
    }
}
