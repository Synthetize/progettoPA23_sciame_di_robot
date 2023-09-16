package it.unicam.cs.followme.list.Interfaces;

public interface ProgramCommandInterface<R extends RobotInterface,S extends ShapeInterface> {
    String getCommand();

    String getLabel();

    double[] getArgs();

    ExecuteLoopsCommand getLoop();
}
