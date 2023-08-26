package it.unicam.cs.followme.list.Interfaces;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Model.Coordinates;
import it.unicam.cs.followme.list.Model.Robot;

import java.util.HashMap;

public interface ConfigurationParserInterface<R extends RobotInterface, S extends ShapeInterface> {
    EnvironmentInterface<R,S> generateEnvironment(String env_confPath, HashMap<R, Coordinates> robotCoordinatesHashMap);
}
