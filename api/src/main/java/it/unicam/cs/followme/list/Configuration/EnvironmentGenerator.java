package it.unicam.cs.followme.list.Configuration;
import it.unicam.cs.followme.list.Interfaces.EnvironmentGeneratorInterface;
import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Model.Coordinates;
import it.unicam.cs.followme.list.Model.Shapes.CircleShape;
import it.unicam.cs.followme.list.Model.Shapes.RectangleShape;
import it.unicam.cs.followme.utilities.FollowMeParser;
import it.unicam.cs.followme.utilities.FollowMeParserException;
import it.unicam.cs.followme.utilities.ShapeData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnvironmentGenerator<R extends RobotInterface> implements EnvironmentGeneratorInterface<R,ShapeInterface> {
    private final FollowMeParser parser;

    public EnvironmentGenerator(FollowMeParser parser) {
        this.parser = parser;
    }
    @Override
    public ArrayList<ShapeInterface> parseEnvConfig(String path) {
        try {
            ArrayList<ShapeInterface> shapesList = new ArrayList<>();
            File env_conf = new File(path);
            List<ShapeData> shapes = parser.parseEnvironment(env_conf);
            for (ShapeData shape : shapes) {
                if (shape.shape().equals("RECTANGLE"))
                    shapesList.add(new RectangleShape(shape));
                if (shape.shape().equals("CIRCLE"))
                    shapesList.add(new CircleShape(shape));
            }
            return shapesList;
        } catch (FollowMeParserException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EnvironmentInterface<R, ShapeInterface> generateEnvironment(String env_confPath, HashMap<R, Coordinates> robotCoordinatesHashMap) {
        return new it.unicam.cs.followme.list.Model.Environment<>(parseEnvConfig(env_confPath), robotCoordinatesHashMap);

    }
}