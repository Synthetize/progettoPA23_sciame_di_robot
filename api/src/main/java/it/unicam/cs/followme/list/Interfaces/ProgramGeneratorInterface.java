package it.unicam.cs.followme.list.Interfaces;
import it.unicam.cs.followme.list.Model.ProgramCommand;
import java.util.ArrayList;

/**
 * This interface defines the contract for the program generator, this interface is used to get the list of commands
 * already parsed by the parser.
 * @param <R> The type representing a robot that implements the RobotInterface.
 * @param <S> The type representing a shape that implements the ShapeInterface.
 */
public interface ProgramGeneratorInterface<R extends RobotInterface, S extends ShapeInterface> {

    /**
     * Call the parser and return the Arraylist of programcommand.
     * @param path The path to the program file.
     * @return An ArrayList of ProgramCommand objects representing the program's commands.
     */
    ArrayList<ProgramCommand<R,S>> parseProgram(String path);
}
