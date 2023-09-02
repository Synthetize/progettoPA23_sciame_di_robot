package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;

import java.awt.*;

public class ExecuteDoneCommand<R extends RobotInterface, S extends ShapeInterface> implements ExecuteLoopsCommand<R, S>{

    int jmp = 0;
    @Override
    public boolean conditionState(EnvironmentInterface env, RobotInterface robot) {
        return false;
    }

    @Override
    public void setJmp(int jmp) {
        this.jmp = jmp;

    }

    @Override
    public int getJmp() {
        return jmp;
    }

    @Override
    public ExecuteLoopsCommand makeCopy() {
        ExecuteLoopsCommand<R, S> copied = new ExecuteDoneCommand<>();
        copied.setJmp(this.getJmp());
        return copied;
    }


}
