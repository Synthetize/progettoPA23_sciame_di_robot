package it.unicam.cs.followme.list.Interfaces;

import it.unicam.cs.followme.list.Model.ProgramCommand;

import java.util.ArrayList;
import java.util.Collection;

public interface ProgramParserInterface {
    ArrayList<ProgramCommand> parseProgram(String path);
}
