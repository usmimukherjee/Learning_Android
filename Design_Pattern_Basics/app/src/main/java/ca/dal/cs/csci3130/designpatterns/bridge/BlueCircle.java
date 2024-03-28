package ca.dal.cs.csci3130.designpatterns.bridge;

public class BlueCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing blue circle with radius:" + radius + " at (" + x + "," + y + ")");
    }
}
