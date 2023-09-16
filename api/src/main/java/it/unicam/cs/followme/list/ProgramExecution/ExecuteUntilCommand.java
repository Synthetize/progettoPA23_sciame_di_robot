package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.ExecuteLoopsCommand;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;

public class ExecuteUntilCommand<R extends RobotInterface,S extends ShapeInterface> implements ExecuteLoopsCommand<R,S> {

    private final String label;
    private int jmp;
    public ExecuteUntilCommand(String label) {
        this.label = label;
    }
    @Override
    public boolean conditionState(EnvironmentInterface<R,S> env, R robot) {
        return env.checkIfRobotIsInsideShapes(robot).contains(label);
    }

    @Override
    public void setIndexToJump(int jmp) {
        this.jmp = jmp;
    }

    @Override
    public int getIndexToJump() {
        return jmp;
    }

}
