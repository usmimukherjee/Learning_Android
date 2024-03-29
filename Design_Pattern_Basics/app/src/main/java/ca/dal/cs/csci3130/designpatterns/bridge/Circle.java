package ca.dal.cs.csci3130.designpatterns.bridge;

public class Circle extends Shape {
    int radius, x, y;

    public Circle(int radius, int x, int y, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        this.drawAPI.drawCircle(this.radius, this.x, this.y);
    }
}
