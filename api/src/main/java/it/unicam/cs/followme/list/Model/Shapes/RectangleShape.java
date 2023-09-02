package it.unicam.cs.followme.list.Model.Shapes;

import it.unicam.cs.followme.list.Model.Coordinates;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.utilities.ShapeData;

public class RectangleShape implements ShapeInterface {

        private final String label;
        private final Coordinates coordinates;
        private final double width;
        private final double height;

        public RectangleShape(String label, double[] args) {
            this.label = label;
            this.coordinates = new Coordinates(args[0], args[1]);
            this.width = args[2];
            this.height = args[3];
        }

        public RectangleShape(ShapeData shapeData) {
            this(shapeData.label(), shapeData.args());
        }

        public double calculateArea() {
            return this.width * this.height;
        }
        public String getLabel() {
            return this.label;
        }
        public Coordinates getCoordinates() {
            return this.coordinates;
        }
        public String toString() {
            return "Rectangle " + this.label + " with width " + this.width + " and height " + this.height + " at coordinates " + this.coordinates;
        }

        //check if the robot is inside the shape by checking if the robot's coordinates are inside the rectangle coordinates knowing the width and the height and the center
    public boolean isTheRobotInsideTheShape(Coordinates robotCoordinates) {
            double topLeftAngleX = coordinates.getX() - width / 2;
            double topLeftAngleY = coordinates.getY() + height / 2;
//            double topRightAngleX = coordinates.getX() + width / 2;
//            double topRightAngleY = coordinates.getY() + height / 2;
//            double bottomLeftAngleX = coordinates.getX() - width / 2;
//            double bottomLeftAngleY = coordinates.getY() - height / 2;
            double bottomRightAngleX = coordinates.getX() + width / 2;
            double bottomRightAngleY = coordinates.getY() - height / 2;
        return topLeftAngleX <= robotCoordinates.getX() && robotCoordinates.getX() <= bottomRightAngleX && bottomRightAngleY <= robotCoordinates.getY() && robotCoordinates.getY() <= topLeftAngleY;
    }

}
