package it.unicam.cs.followme.list.Handlers;

import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Model.ProgramCommand;
import it.unicam.cs.followme.list.ProgramExecution.ExecuteDoneCommand;
import it.unicam.cs.followme.list.ProgramExecution.ExecuteRepeatCommand;
import it.unicam.cs.followme.list.ProgramExecution.ExecuteUntilCommand;
import it.unicam.cs.followme.utilities.FollowMeParserHandler;

import java.util.ArrayList;
import java.util.Stack;

public class ParserHandler<R extends RobotInterface, S extends ShapeInterface> implements FollowMeParserHandler {
    private ArrayList<ProgramCommand<R,S>> program;
    private Stack<Integer> loopIndexStack;

    @Override
    public void parsingStarted() {
        program = new ArrayList<>();
        loopIndexStack = new Stack<>();

    }

    @Override
    public void parsingDone() {

    }

    @Override
    public void moveCommand(double[] args) {
        program.add(new ProgramCommand<>("MOVE", args));

    }

    @Override
    public void moveRandomCommand(double[] args) {

        program.add(new ProgramCommand<>("MOVE RANDOM", args));
    }

    @Override
    public void signalCommand(String label) {
        program.add(new ProgramCommand<>("SIGNAL", label));

    }

    @Override
    public void unsignalCommand(String label) {
        program.add(new ProgramCommand<>("UNSIGNAL", label));

    }

    @Override
    public void followCommand(String label, double[] args) {
        program.add(new ProgramCommand<>("FOLLOW", label, args));
    }

    @Override
    public void stopCommand() {

    }

    @Override
    public void continueCommand(int s) {
        ExecuteRepeatCommand<R,S> continueCommand = new ExecuteRepeatCommand<>(s);
        program.add(new ProgramCommand<>("CONTINUE", continueCommand));
        continueCommand.setIndexToJump(program.size()-1);

    }

    @Override
    public void repeatCommandStart(int numberOfRepetitions) {
        program.add(new ProgramCommand<>("REPEAT", new ExecuteRepeatCommand<>(numberOfRepetitions)));
        loopIndexStack.push(program.size()-1);
    }

    @Override
    public void untilCommandStart(String label) {
        program.add(new ProgramCommand<>("UNTIL", new ExecuteUntilCommand<>(label)));
        loopIndexStack.push(program.size()-1);
    }

    @Override
    public void doForeverStart() {
        program.add(new ProgramCommand<>("REPEAT", new ExecuteRepeatCommand<>(-1)));
        loopIndexStack.push(program.size()-1);
    }

    @Override
    public void doneCommand() {
        ExecuteDoneCommand<R, S> doneCommand = new ExecuteDoneCommand<>();
        program.add(new ProgramCommand<>("DONE", doneCommand));
        doneCommand.setIndexToJump(loopIndexStack.pop());
        program.get(doneCommand.getIndexToJump()).getLoop().setIndexToJump(program.size());
    }

    public ArrayList<ProgramCommand<R,S>> getProgram() {
        return program;
    }
}
