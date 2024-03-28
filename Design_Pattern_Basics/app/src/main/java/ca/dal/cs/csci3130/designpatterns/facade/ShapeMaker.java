package ca.dal.cs.csci3130.designpatterns.facade;

import ca.dal.cs.csci3130.designpatterns.factory.Circle;
import ca.dal.cs.csci3130.designpatterns.factory.Rectangle;
import ca.dal.cs.csci3130.designpatterns.factory.Shape;
import ca.dal.cs.csci3130.designpatterns.factory.Square;

public class ShapeMaker {
    Shape circle;
    Shape rectangle;
    Shape square;

    public ShapeMaker() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
        this.square = new Square();
    }

    public void drawCircle() {
        this.circle.draw();
    }

    public void drawRectangle() {
        this.rectangle.draw();
    }

    public void drawSquare() {
        this.square.draw();
    }

}
