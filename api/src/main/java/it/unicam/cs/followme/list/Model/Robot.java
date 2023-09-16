package it.unicam.cs.followme.list.Model;
import it.unicam.cs.followme.list.Interfaces.RobotInterface;
import java.util.ArrayList;

public class Robot implements RobotInterface {

    private int robotId;
    private ArrayList<String> labels;

    private RobotDirection direction;


    public Robot() {
        labels = new ArrayList<>();
    }

    @Override
    public ArrayList<String> getCurrentLabels() {
        return labels;
    }
    @Override
    public void addLabel(String label) {
        this.labels.add(label);
    }
    @Override
    public void removeLabel(String label) {this.labels.remove(label);
    }
    @Override
    public RobotDirection getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(double xValue, double yValue, double speed) {
        direction = new RobotDirection(xValue, yValue, speed);
    }

    @Override
    public String toString() {
        return super.toString().split("@")[1];
    }


}
