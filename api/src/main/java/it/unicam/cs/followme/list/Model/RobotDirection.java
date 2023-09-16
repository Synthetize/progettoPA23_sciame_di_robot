package it.unicam.cs.followme.list.Model;

import it.unicam.cs.followme.list.Interfaces.RobotDirectionInterface;

public class RobotDirection implements RobotDirectionInterface {
    private double xValue;
    private double yValue;
    private double speed;
    public RobotDirection(double xValue, double yValue, double speed){
        double direction = Math.sqrt(Math.pow(xValue,2)+Math.pow(yValue,2));
        this.speed = speed;
        this.xValue = (xValue/direction)*speed;
        this.yValue = (yValue/direction)*speed;
    }

    public double getSpeed() {
        return speed;
    }

    public Coordinates getCoordinates(){
        return new Coordinates(this.xValue,this.yValue);
    }

}