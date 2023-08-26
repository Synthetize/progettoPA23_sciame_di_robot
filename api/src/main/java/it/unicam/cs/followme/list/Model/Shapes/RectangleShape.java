package it.unicam.cs.followme.list.Model.Shapes;

import it.unicam.cs.followme.list.Model.Coordinates;
import it.unicam.cs.followme.list.Interfaces.ShapeInterface;
import it.unicam.cs.followme.utilities.ShapeData;

public class RectangleShape implements ShapeInterface {

        private String label;
        private Coordinates coordinates;
        private double width;
        private double height;

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

}
