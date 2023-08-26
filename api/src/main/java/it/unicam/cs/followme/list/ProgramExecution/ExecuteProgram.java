package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Model.ProgramCommand;

import java.util.ArrayList;


public class ExecuteProgram<R extends RobotInterface,S extends ShapeInterface> {
    private int commandIndex;
    private R robot;
    private ExecuteBasicCommands basicCommand;
    private ExecuteLoopsCommands loopCommand;

    private ArrayList<ProgramCommand> programList;

    public ExecuteProgram(R robot, ArrayList<ProgramCommand> programList) {
        this.commandIndex = 0;
        this.robot = robot;
        basicCommand = new ExecuteBasicCommands();
        this.programList = programList;
        //loopCommand = new ExecuteLoopsCommands();
    }

    public void execute(EnvironmentInterface<R,S> env) {
        if (commandIndex >= programList.size())
            stopExecution();
        else if (!findLoop())
            executeBasicComand();
        else
            executeLoop();

    }

    private boolean findLoop() {
        String command = programList.get(commandIndex).getCommand();
        switch (command) {
            case "REPEAT", "UNTIL", "DO FOREVER", "DONE" -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    private void executeBasicComand() {
        ProgramCommand command = programList.get(commandIndex);
       // System.out.println("Executing command " + commandIndex);
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
//        String command = programList.get(commandIndex).getCommand();
//        switch (command) {
//            case "REPEAT" -> {
//                loopCommand.repeat(commandIndex);}
//            case "UNTIL" -> {
//
//            }
//            case "DO FOREVER" -> {
//                loopCommand.forever(commandIndex);}
//            case "DONE" -> {
//                commandIndex++;
//                execute();
//            }
//        }
    }

    private void stopExecution() {
        System.out.println("Execution stopped");

    }


}
