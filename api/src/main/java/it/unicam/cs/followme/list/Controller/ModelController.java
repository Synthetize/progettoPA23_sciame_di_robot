package it.unicam.cs.followme.list.Controller;

import it.unicam.cs.followme.list.Configuration.EnvironmentGenerator;
import it.unicam.cs.followme.list.Interfaces.EnvironmentGeneratorInterface;
import it.unicam.cs.followme.list.Configuration.ProgramGenerator;
import it.unicam.cs.followme.list.Interfaces.ProgramGeneratorInterface;
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

public class ModelController<R extends RobotInterface, S extends ShapeInterface> {
    ArrayList<ExecuteProgram<R, S>> programList;
    EnvironmentGeneratorInterface<R, S> configParser;
    ProgramGeneratorInterface<R, S> programParser;
    EnvironmentInterface<R, S> environment;


    public ModelController(EnvironmentGeneratorInterface<R, S> configurationParserInterface, ProgramGeneratorInterface<R, S> programParserInterface) {
        this.configParser = configurationParserInterface;
        this.programParser = programParserInterface;
        this.programList = new ArrayList<>();
    }


    public static ModelController<RobotInterface, ShapeInterface> getController() {
        ParserHandler<RobotInterface, ShapeInterface> handler = new ParserHandler<>();
        FollowMeParser parser = new FollowMeParser(handler);
        return new ModelController<>(new EnvironmentGenerator<>(parser), new ProgramGenerator<>(parser, handler));
    }

    public void initializeEnvironment(HashMap<R, Coordinates> robotCoordinatesHashMap, String env_confPath) {
        environment = configParser.generateEnvironment(env_confPath, robotCoordinatesHashMap);
    }

    public void initializeProgram(String robotProgramPath) {
        initializeExecution(programParser.parseProgram(robotProgramPath));
    }

    private void initializeExecution(ArrayList<ProgramCommand<R, S>> program) {
        System.out.println(environment.getRobotsHashMap());
        environment.getRobotsHashMap().keySet().forEach(key -> {
            programList.add(new ExecuteProgram<>(key, new ArrayList<>(program), environment));
        });
    }


    public ArrayList<String> executeProgram(int numberOfExecutions) {
        ArrayList<String> logs = new ArrayList<>();
        for (int i = 0; i < numberOfExecutions; i++) {
            for (ExecuteProgram<R, S> program : programList) {
                String log = program.execute();
                if (log != null) logs.add(log+"\n");
            }
        }
        return logs;
    }

    public EnvironmentInterface<R, S> getEnvironment() {
        return environment;
    }

}
