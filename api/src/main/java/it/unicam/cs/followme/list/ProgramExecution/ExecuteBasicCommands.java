package it.unicam.cs.followme.list.ProgramExecution;

import it.unicam.cs.followme.list.Interfaces.EnvironmentInterface;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.list.Model.Coordinates;

import java.util.*;

public class ExecuteBasicCommands<R extends RobotInterface, S extends ShapeInterface> {
    R robot;
    EnvironmentInterface<R, S> env;

    public ExecuteBasicCommands(R robot, EnvironmentInterface<R, S> env) {
        this.robot = robot;
        this.env = env;
    }

    public String move(double[] args) {
        double x = args[0];
        double y = args[1];
        double speed = args[2];
        String log = "Robot: @" + robot + " MOVE, From: " + env.getCoordinatesOf(robot).toString();
        robot.setDirection(x, y, speed);
        Coordinates robotCurrentCoordinates = env.getRobotsHashMap().get(robot);
        Coordinates updatedRobotCoordinate = robotCurrentCoordinates.updateCoordinates(robot.getDirection().getCoordinates());
        env.updateRobotPosition(robot, updatedRobotCoordinate);
        return log.concat(" To: " + env.getCoordinatesOf(robot).toString());
    }

    public String moveRandom(double[] args) {

        //randomNumber(x1, x2), randomNumber(y1, y2), speed
        double[] moveArguments = {randomNumber(args[0], args[1]), randomNumber(args[2], args[3]), args[4]};
        return move(moveArguments);
    }

    public String signal(String label) {
        if (!(robot.getCurrentLabels().contains(label))) {
            robot.addLabel(label);
        }
        return "Robot: " + robot + " SIGNAL: " + robot.getCurrentLabels();
    }

    public String unsignal(String label) {
        if (robot.getCurrentLabels().contains(label))
            robot.removeLabel(label);

        return  ("Robot: @"+robot + " UNSIGNAL: " + robot.getCurrentLabels());
    }

    public String follow(String label, double dist, double speed) {
        //CHECK IF THERE ARE OTHER ROBOTS WITH THE SAME LABEL
        ArrayList<Coordinates> signalingRobotCoordinates = checkRobotsWithSameLabelWithinDistance(label, dist);
        Coordinates followDirection = calculateFollowDirection(signalingRobotCoordinates, dist);


        this.robot.setDirection(followDirection.getX(), followDirection.getY(), speed);
        Coordinates robotCurrentCoordinates = env.getCoordinatesOf(robot);
        Coordinates updatedRobotCoordinate = robotCurrentCoordinates.updateCoordinates(robot.getDirection().getCoordinates());
        env.updateRobotPosition(robot, updatedRobotCoordinate);
        System.out.println("Robot: " + robot + "FOLLOW" + robot.getDirection().getCoordinates().toString());
        return "Robot: " + robot + "FOLLOW: Directions" + updatedRobotCoordinate.toString();
    }

    private ArrayList<Coordinates> checkRobotsWithSameLabelWithinDistance(String label, double dist) {
        ArrayList<Coordinates> signalingRobotCoordinates = new ArrayList<>();
        Coordinates thisRobotCoordinates = env.getCoordinatesOf(robot);

        for (Map.Entry<R, Coordinates> entry : env.getRobotsHashMap().entrySet()) {
            if (entry.getKey().getCurrentLabels().contains(label)) {
                if (env.calculateDistanceBetweenTwoRobots(this.robot, entry.getKey()) < dist)
                    signalingRobotCoordinates.add(entry.getValue());
                signalingRobotCoordinates.remove(thisRobotCoordinates);
            }
        }
        return signalingRobotCoordinates;
    }

    private Coordinates calculateFollowDirection(ArrayList<Coordinates> signalingRobotCoordinates, double dist) {
        Coordinates followDirection = new Coordinates(0, 0);
        if (signalingRobotCoordinates.isEmpty()) {
            System.out.println("No robots with the same label");
            followDirection.setX(randomNumber(dist*-1, dist));
            followDirection.setY(randomNumber(dist*-1, dist));

        } else {
            OptionalDouble xTotal = signalingRobotCoordinates.stream()
                    .mapToDouble(Coordinates::getX).average();
            OptionalDouble yTotal = signalingRobotCoordinates.stream()
                    .mapToDouble(Coordinates::getY).average();
            if (xTotal.isPresent() && yTotal.isPresent()) {
                followDirection.setX(xTotal.getAsDouble());
                followDirection.setY(yTotal.getAsDouble());
            }
        }
        return followDirection;
    }

    public void stop() {
        robot.setDirection(0, 0, 0);
    }

    public double randomNumber(double minValue, double maxValue) {
        Random random = new Random();
        return random.nextDouble(maxValue - minValue + 1) + minValue;
    }


}
