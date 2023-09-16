package it.unicam.cs.followme.app;

import it.unicam.cs.followme.list.Controller.ModelController;
import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.RobotsHandlerInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Model.Coordinates;
import it.unicam.cs.followme.list.Model.Shapes.CircleShape;
import it.unicam.cs.followme.list.Model.Shapes.RectangleShape;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class simulationAreaView {
    @FXML
    public Pane environmentArea;
    @FXML
    public Button nextStep;
    public TextFlow logArea;
    public TextField repeatNumber;

    private ModelController<RobotInterface, ShapeInterface> ModelController;

    private final Group elementsToShow = new Group();

    private EnvironmentInterface<RobotInterface, ShapeInterface> environment;

    private Coordinates center;


    public simulationAreaView() {
    }

    public void initialize(File env_ConfPath, File program_ConfPath, ArrayList<Coordinates> robotCoordinates) {
        ModelController = ModelController.getController();
        ModelController.initializeEnvironment(RobotsHandlerInterface.addRobotAtChosenPosition(robotCoordinates), env_ConfPath.getAbsolutePath());
        ModelController.initializeProgram(program_ConfPath.getAbsolutePath());
        System.out.println("Environment initialized: " + ModelController.getEnvironment().getRobotsHashMap());


        System.out.println("Width: " + environmentArea.getPrefHeight() + " Height: " + environmentArea.getPrefWidth());
        environment = ModelController.getEnvironment();
        center = new Coordinates(environmentArea.getPrefWidth() / 2, environmentArea.getPrefHeight() / 2);
        environmentArea.getChildren().add(elementsToShow);
        repeatNumber.setText("1");
        addShapeToGroup();
        addRobotsToGroup();
    }

    private void addRobotsToGroup() {
        HashMap<RobotInterface, Coordinates> robots = environment.getRobotsHashMap();
        robots.forEach((robot, coordinates) -> {
            Circle c = new Circle(coordinates.getX() + center.getX(), (coordinates.getY() * -1) + center.getY(), 3);
            c.setFill(Color.RED);
            elementsToShow.getChildren().add(c);
        });
    }

    private void addShapeToGroup() {
        ArrayList<ShapeInterface> shapes = environment.getShapes();
        shapes.forEach(shape -> {
            if (shape instanceof RectangleShape rectangle) {
                addRectangleToGroup(rectangle);
            } else if (shape instanceof CircleShape circle) {
                addCircleToGroup(circle);
            }
        });
    }

    private void addRectangleToGroup(RectangleShape rectangle) {
        double x = rectangle.getCoordinates().getX() + center.getX();
        double y = (rectangle.getCoordinates().getY() * -1) + center.getY();
        double xTopLeftAngle = x - (rectangle.getWidth() / 2);       //top left x
        double yTopLeftAngle = y - (rectangle.getHeight() / 2);      //top left y
        Rectangle r = new Rectangle(xTopLeftAngle, yTopLeftAngle, rectangle.getWidth(), rectangle.getHeight());
        r.setFill(Color.BLUE);

        elementsToShow.getChildren().add(r);
    }

    private void addCircleToGroup(CircleShape circle) {
        double x = circle.getCoordinates().getX() + center.getX();
        double y = (circle.getCoordinates().getY() * -1) + center.getY();
        Circle c = new Circle(x, y, circle.getRadius());
        c.setFill(Color.BLUE);
        elementsToShow.getChildren().add(c);
    }

    public void executeNextStep(ActionEvent actionEvent) {
        ArrayList<String> logs = ModelController.executeProgram(numberOfSteps());
        if (!logs.isEmpty())
            logArea.getChildren().add(new Text(logs + "\n--------------------------------------\n"));
        elementsToShow.getChildren().clear();
        addRobotsToGroup();
        addShapeToGroup();

    }

    public Integer numberOfSteps() {
        if (repeatNumber.getText().matches("[0-9]+")) {
            return Integer.parseInt(repeatNumber.getText());
        }

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setContentText("The input must be a number");
        errorAlert.showAndWait();
        return 0;
    }
}
