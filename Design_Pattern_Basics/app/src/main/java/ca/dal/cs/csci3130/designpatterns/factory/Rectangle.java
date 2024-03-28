package ca.dal.cs.csci3130.designpatterns.factory;

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("This is a rectangle!");
    }
}
