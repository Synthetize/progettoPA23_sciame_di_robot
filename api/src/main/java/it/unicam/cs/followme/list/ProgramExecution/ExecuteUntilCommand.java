package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;

public class ExecuteUntilCommand<R extends RobotInterface,S extends ShapeInterface> implements ExecuteLoopsCommand<R,S>{

    private String label;
    private int jmp;
    public ExecuteUntilCommand(String label) {
        this.label = label;
    }
    @Override
    public boolean conditionState(EnvironmentInterface<R,S> env, R robot) {
        if (robot.getCurrentLabels().isEmpty()) return false;
        return  robot.getCurrentLabels().contains(label);
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
    public ExecuteLoopsCommand<R,S> makeCopy() {
        ExecuteLoopsCommand<R, S> copied = new ExecuteUntilCommand<>(this.label);
        copied.setJmp(this.getJmp());
        return copied;
    }
}
