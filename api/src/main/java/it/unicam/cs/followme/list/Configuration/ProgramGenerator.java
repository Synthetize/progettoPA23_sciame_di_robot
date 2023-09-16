package it.unicam.cs.followme.list.Configuration;

import it.unicam.cs.followme.list.Handlers.ParserHandler;
import it.unicam.cs.followme.list.Interfaces.ProgramGeneratorInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Model.ProgramCommand;
import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.followme.utilities.FollowMeParserException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProgramGenerator<R extends RobotInterface,S extends ShapeInterface> implements ProgramGeneratorInterface<R,S> {
    FollowMeParser parser;
    ParserHandler<R,S> handler;

    public ProgramGenerator(FollowMeParser parser, ParserHandler<R,S> handler) {
        this.parser = parser;
        this.handler = handler;
    }
    @Override
    public ArrayList<ProgramCommand<R,S>> parseProgram(String path) {
        try {
            File progFile = new File(path);
            parser.parseRobotProgram(progFile);
            return handler.getProgram();
        } catch (FollowMeParserException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
