package it.unicam.cs.followme.list.Model;

import it.unicam.cs.followme.list.Interfaces.ProgramCommandInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Interfaces.ExecuteLoopsCommand;

public class ProgramCommand<R extends RobotInterface, S extends ShapeInterface> implements ProgramCommandInterface<R, S> {
    private String command;
    private double[] args;
    private String label;

    private ExecuteLoopsCommand<R,S> loop;


    public ProgramCommand(String comm, double[] args) {
        this.command = comm;
        this.args = args;
    }

    public ProgramCommand(String comm, String label) {
        this.command = comm;
        this.label = label;
    }

    public ProgramCommand(String comm, String label, double[] args) {
        this(comm,label);
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
    @Override
    public String getCommand() {
        return this.command;
    }
    @Override
    public String getLabel() {
        return this.label;
    }
    @Override
    public double[] getArgs() {
        return this.args;
    }
    @Override
    public ExecuteLoopsCommand<R, S> getLoop(){
        return this.loop;
    }
}
