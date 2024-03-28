package ca.dal.cs.csci3130.designpatterns.factory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("This is a square!");
    }
}
