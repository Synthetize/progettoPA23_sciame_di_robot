package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.ExecuteLoopsCommand;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;

public class ExecuteDoneCommand<R extends RobotInterface, S extends ShapeInterface> implements ExecuteLoopsCommand<R, S> {

    int jmp = 0;
    @Override
    public boolean conditionState(EnvironmentInterface env, RobotInterface robot) {
        return false;
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
