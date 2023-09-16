package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.ExecuteLoopsCommand;
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
        System.out.println("REPEAT" + " " + repetitionsDone);
        //do forever case
        if (numberOfRepetitions < 0)
            return false;
        //reset the counter in case of more repeat commands
        if (repetitionsDone >= numberOfRepetitions) {
            System.out.println("REPEAT DONE");
            repetitionsDone = 0;
            return true;
        }
        repetitionsDone++;
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
