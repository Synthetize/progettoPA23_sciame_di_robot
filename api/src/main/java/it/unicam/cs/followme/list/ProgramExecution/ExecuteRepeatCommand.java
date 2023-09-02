package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;

public class ExecuteRepeatCommand<R extends RobotInterface, S extends ShapeInterface> implements ExecuteLoopsCommand<R, S> {

    private final int numberOfRepetitions;
    private int jmp;
    private int repetitionsDone;

    public ExecuteRepeatCommand(int numberOfRepetitions) {
        this.numberOfRepetitions = numberOfRepetitions;
        this.repetitionsDone = 0;
    }

    @Override
    public boolean conditionState(EnvironmentInterface<R, S> env, R robot) {
        //do forever case
        if (numberOfRepetitions < 0)
            return false;
        //reset the counter in case of more repeat commands
        if (repetitionsDone >= numberOfRepetitions) {
            repetitionsDone = 0;
            return true;
        }
        repetitionsDone++;
        return false;
    }

    @Override
    public void setJmp(int jmp) {
        this.jmp = jmp;
    }

    public ExecuteLoopsCommand<R, S> makeCopy() {
        ExecuteLoopsCommand<R, S> copied = new ExecuteRepeatCommand<>(this.numberOfRepetitions);
        copied.setJmp(this.getJmp());
        return copied;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExecuteRepeatCommand<?, ?> that = (ExecuteRepeatCommand<?, ?>) o;
        return numberOfRepetitions == that.numberOfRepetitions && jmp == that.jmp && repetitionsDone == that.repetitionsDone;
    }

    @Override
    public int getJmp() {
        return jmp;
    }
}
