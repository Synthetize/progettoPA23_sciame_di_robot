package it.unicam.cs.followme.list.Controller;

import it.unicam.cs.followme.list.Configuration.Environment;
import it.unicam.cs.followme.list.Interfaces.ConfigurationParserInterface;
import it.unicam.cs.followme.list.Configuration.Program;
import it.unicam.cs.followme.list.Interfaces.ProgramParserInterface;
import it.unicam.cs.followme.list.Handlers.ParserHandler;
import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Model.Coordinates;
import it.unicam.cs.followme.list.Model.ProgramCommand;
import it.unicam.cs.followme.list.ProgramExecution.ExecuteProgram;
import it.unicam.cs.followme.utilities.FollowMeParser;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller<R extends RobotInterface, S extends ShapeInterface> {
    ArrayList<ExecuteProgram<R, S>> programList;



    ConfigurationParserInterface<R,S> configParser;
    ProgramParserInterface programParser;
    EnvironmentInterface<R,S> environment;



    public Controller(ConfigurationParserInterface<R,S> configurationParserInterface, ProgramParserInterface programParserInterface) {
        this.configParser = configurationParserInterface;
        this.programParser = programParserInterface;
        this.programList = new ArrayList<>();
    }


    public static Controller<RobotInterface, ShapeInterface> getController(){
        ParserHandler handler = new ParserHandler();
        FollowMeParser parser = new FollowMeParser(handler);
        return new Controller<>(new Environment<>(parser),new Program(parser,handler));
    }

    public void initializeEnvironment(HashMap<R, Coordinates> robotCoordinatesHashMap, String env_confPath) {
        environment = configParser.generateEnvironment(env_confPath, robotCoordinatesHashMap);
    }

    public void initializeProgram(String robotProgramPath) {;
        initializeExecution(programParser.parseProgram(robotProgramPath));
    }



    private void initializeExecution(ArrayList<ProgramCommand> program) {
        System.out.println(environment.getRobot());
        environment.getRobot().keySet().forEach(key -> {
            programList.add(new ExecuteProgram<>(key, new ArrayList<>(program)));
        });
    }


    public void executeProgram(int numberOfExecutions) {
        for (int i = 0; i < numberOfExecutions; i++) {
            programList.forEach(program -> {
                program.execute(environment);
            });
        }
    }

}
