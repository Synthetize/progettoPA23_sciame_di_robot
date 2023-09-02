package it.unicam.cs.followme.list.Interfaces;

import it.unicam.cs.followme.list.Model.ProgramCommand;

import java.util.ArrayList;
import java.util.Collection;

public interface ProgramParserInterface<R extends RobotInterface, S extends ShapeInterface> {
    ArrayList<ProgramCommand<R,S>> parseProgram(String path);
}
