package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;

public interface ExecuteLoopsCommand<R extends RobotInterface, S extends ShapeInterface> {
    boolean conditionState(EnvironmentInterface<R, S> env, R robot);

    void setJmp(int jmp);

    int getJmp();

    ExecuteLoopsCommand<R, S> makeCopy();
}
