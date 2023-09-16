package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.ExecuteProgramInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Model.Coordinates;
import it.unicam.cs.followme.list.Model.ProgramCommand;

import java.util.ArrayList;


public class ExecuteProgram<R extends RobotInterface, S extends ShapeInterface> implements ExecuteProgramInterface<R,S> {
    private int commandIndex;
    private final R robot;
    private final ExecuteBasicCommands<R,S> basicCommand;

    private final ArrayList<ProgramCommand<R, S>> programList;

    private final EnvironmentInterface<R, S> env;


    public ExecuteProgram(R robot, ArrayList<ProgramCommand<R, S>> programList, EnvironmentInterface<R, S> env) {
        this.commandIndex = 0;
        this.robot = robot;
        basicCommand = new ExecuteBasicCommands<>(robot, env);
        this.programList = programList;
        this.env = env;
    }
    @Override
    public String execute() {
        //System.out.println(programList.get(commandIndex));
        if (commandIndex >= programList.size())
            return stopExecution();
        else if (!findLoop())
            return executeBasicCommand();
        else
           return executeLoop();
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
    @Override
    public String executeBasicCommand() {
        ProgramCommand<R, S> command = programList.get(commandIndex);
        switch (command.getCommand()) {
            case "MOVE" -> {
                double[] args = command.getArgs();
                commandIndex++;
                return basicCommand.move(args);

            }
            case "MOVE RANDOM" -> {
                double[] args = command.getArgs();
                commandIndex++;
                return basicCommand.moveRandom(args);

            }
            case "SIGNAL" -> {
                String label = command.getLabel();
                commandIndex++;
                return basicCommand.signal(label);

            }
            case "UNSIGNAL" -> {
                String label = command.getLabel();
                commandIndex++;
                return basicCommand.unsignal(label);

            }
            case "FOLLOW" -> {
                String label = command.getLabel();
                double[] args = command.getArgs();
                commandIndex++;
                return basicCommand.follow(label, args[0], args[1]);

            }
            case "CONTINUE" -> {
                if(!command.getLoop().conditionState(env, robot)){
                    Coordinates robotDirections = robot.getDirection().getCoordinates();
                    double robotSpeed = robot.getDirection().getSpeed();
                    double[] args = {robotDirections.getX(), robotDirections.getY(), robotSpeed};
                    commandIndex = command.getLoop().getIndexToJump();
                    return basicCommand.move(args);
                }else{
                    commandIndex++;
                    return execute();
                }
            }
            case "STOP" -> {
                basicCommand.stop();
                return "Stop";
            }
            default -> {
                return "Command not found";
            }
        }
    }
    @Override
    public String executeLoop() {
        ProgramCommand<R, S> command = programList.get(commandIndex);
        switch (command.getCommand()) {
            case "REPEAT", "DO FOREVER", "UNTIL" -> {
                if (command.getLoop().conditionState(env, robot)) {
                    commandIndex = command.getLoop().getIndexToJump();
                } else {
                    commandIndex++;
                }
                return execute();
            }
            case "DONE" -> {
                commandIndex = command.getLoop().getIndexToJump();
                return execute();
            }
        }
        return null;
    }


    private String stopExecution() {
        return "Execution stopped";

    }

}
