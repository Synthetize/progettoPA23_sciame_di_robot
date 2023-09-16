package it.unicam.cs.followme.list.Interfaces;

import it.unicam.cs.followme.list.Model.Coordinates;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * This interface defines the contract for a configuration parser that generates
 * an environment based on configuration data.
 * @param <R> The type representing a robot that implements the RobotInterface.
 * @param <S> The type representing a shape that implements the ShapeInterface.
 */
public interface EnvironmentGeneratorInterface<R extends RobotInterface, S extends ShapeInterface> {
    /**
     * Parses the environment configuration file and returns a list of shapes.
     * @param path The path to the environment configuration file.
     * @return An ArrayList of ShapeInterface objects representing the shapes in the environment.
     */
    ArrayList<ShapeInterface> parseEnvConfig(String path);

    /**
     * Generates an environment based on configuration data.
     * @param env_confPath             The path to the environment configuration file.
     * @param robotCoordinatesHashMap A HashMap containing robot-coordinate pairs.
     * @return The generated environment.
     */
    EnvironmentInterface<R,S> generateEnvironment(String env_confPath, HashMap<R, Coordinates> robotCoordinatesHashMap);
}
