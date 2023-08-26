package it.unicam.cs.followme.list.Configuration;

import it.unicam.cs.followme.list.Handlers.ParserHandler;
import it.unicam.cs.followme.list.Interfaces.ProgramParserInterface;
import it.unicam.cs.followme.list.Model.ProgramCommand;
import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.followme.utilities.FollowMeParserException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Program implements ProgramParserInterface {
    FollowMeParser parser;
    ParserHandler handler;

    public Program(FollowMeParser parser, ParserHandler handler) {
        this.parser = parser;
        this.handler = handler;
    }
    @Override
    public ArrayList<ProgramCommand> parseProgram(String path) {
        try {
            File progFile = new File(path);
            parser.parseRobotProgram(progFile);
            return handler.getProgram();
        } catch (FollowMeParserException | IOException e) {
            throw new RuntimeException(e);
        }
    }




}
