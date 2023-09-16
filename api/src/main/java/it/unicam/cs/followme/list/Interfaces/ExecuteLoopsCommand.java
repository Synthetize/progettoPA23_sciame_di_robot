package it.unicam.cs.followme.list.Interfaces;
/**
 * This interface defines a command for executing loops
 * @param <R> The type representing a robot that implements the RobotInterface.
 * @param <S> The type representing a shape that implements the ShapeInterface.
 */
public interface ExecuteLoopsCommand<R extends RobotInterface, S extends ShapeInterface> {
    /**
     * Checks the condition state to determine if the loop should continue.
     * @param env   The environment in which the loop is executed.
     * @param robot The robot involved in the loop.
     * @return true or false.
     */
    boolean conditionState(EnvironmentInterface<R, S> env, R robot);

    /**
     * Sets the jump value for controlling loop execution.
     * @param index The index of loop start command.
     */
    void setIndexToJump(int index);

    /**
     * Retrieves the current loopIndexStart value
     * @return The current loopIndexStart value.
     */
    int getIndexToJump();

}
