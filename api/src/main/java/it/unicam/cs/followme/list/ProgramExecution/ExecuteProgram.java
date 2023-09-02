package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Model.ProgramCommand;

import java.util.ArrayList;


public class ExecuteProgram<R extends RobotInterface, S extends ShapeInterface> {
    private int commandIndex;
    private R robot;
    private ExecuteBasicCommands basicCommand;

    private ArrayList<ProgramCommand<R, S>> programList;

    private ArrayList<Integer> startLoopIndex = new ArrayList<>();
    private int repeatCounter;
    private boolean doForever = false;

    private EnvironmentInterface<R, S> env;

    public ExecuteProgram(R robot, ArrayList<ProgramCommand<R, S>> programList, EnvironmentInterface<R, S> env) {
        this.commandIndex = 0;
        this.robot = robot;
        basicCommand = new ExecuteBasicCommands();
        //loopCommand = new ExecuteLoopsCommands(programList);
        this.programList = programList;
        this.env = env;
    }

    public void execute() {
        if (commandIndex >= programList.size())
            stopExecution();
        else if (!findLoop())
            executeBasicComand();
        else
            executeLoop();
    }

    private boolean findLoop() {
        String command = programList.get(commandIndex).getCommand();
        //System.out.println(command + " " + commandIndex);
        switch (command) {
            case "REPEAT", "UNTIL", "DO FOREVER", "DONE" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public void executeBasicComand() {
        ProgramCommand<R, S> command = programList.get(commandIndex);
        switch (command.getCommand()) {
            case "MOVE" -> {
                double[] args = command.getArgs();
                basicCommand.move(args[0], args[1], args[2]);

            }
            case "MOVE RANDOM" -> {
                double[] args = command.getArgs();
                basicCommand.moveRandom(args[0], args[1], args[2], args[3]);

            }
            case "SIGNAL" -> {
                String label = command.getLabel();
                basicCommand.signal(label);

            }
            case "UNSIGNAL" -> {
                String label = command.getLabel();
                basicCommand.unsignal(label);

            }
            case "FOLLOW" -> {
                String label = command.getLabel();
                double[] args = command.getArgs();
                basicCommand.follow(label, args[0], args[1]);

            }
            case "CONTINUE" -> {
            }
            case "STOP" -> {
                stopExecution();
            }
        }
        commandIndex++;

    }

    private void executeLoop() {
        ProgramCommand<R, S> command = programList.get(commandIndex);
        switch (command.getCommand()) {
            case "REPEAT", "DO FOREVER", "UNTIL" -> {
                if (command.getLoop().conditionState(env, robot)) {
                    commandIndex = command.getLoop().getJmp();
                } else {
                    commandIndex++;
                    execute();
                }
            }
            case "DONE" -> {
                commandIndex = command.getLoop().getJmp();
                execute();
            }
        }
    }


    private void stopExecution() {
        System.out.println("Execution stopped");

    }


    public void setProgramList(ArrayList<ProgramCommand<R, S>> repeatList) {
        this.programList = repeatList;
    }
}
