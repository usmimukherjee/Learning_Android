package ca.dal.cs.csci3130.designpatterns.bridge;

public abstract class Shape {
    DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
