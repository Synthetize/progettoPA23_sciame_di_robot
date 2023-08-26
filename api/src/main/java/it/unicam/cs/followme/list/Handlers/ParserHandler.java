package it.unicam.cs.followme.list.Handlers;

import it.unicam.cs.followme.list.Model.ProgramCommand;
import it.unicam.cs.followme.utilities.FollowMeParserHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ParserHandler implements FollowMeParserHandler {
    ArrayList<ProgramCommand> program;

    @Override
    public void parsingStarted() {
        program = new ArrayList<>();

    }

    @Override
    public void parsingDone() {

    }

    @Override
    public void moveCommand(double[] args) {
        program.add(new ProgramCommand("MOVE", args));

    }

    @Override
    public void moveRandomCommand(double[] args) {
        program.add(new ProgramCommand("MOVE RANDOM", args));
    }

    @Override
    public void signalCommand(String label) {
        program.add(new ProgramCommand("SIGNAL", label));

    }

    @Override
    public void unsignalCommand(String label) {
        program.add(new ProgramCommand("UNSIGNAL", label));

    }

    @Override
    public void followCommand(String label, double[] args) {
        program.add(new ProgramCommand("FOLLOW", label, args));
    }

    @Override
    public void stopCommand() {

    }

    @Override
    public void continueCommand(int s) {

    }

    @Override
    public void repeatCommandStart(int n) {
        program.add(new ProgramCommand("REPEAT", n));
    }

    @Override
    public void untilCommandStart(String label) {

    }

    @Override
    public void doForeverStart() {
        program.add(new ProgramCommand("DO FOREVER",0));

    }

    @Override
    public void doneCommand() {
        program.add(new ProgramCommand("DONE", 0));
    }

    public ArrayList<ProgramCommand> getProgram() {
        return program;
    }
}
