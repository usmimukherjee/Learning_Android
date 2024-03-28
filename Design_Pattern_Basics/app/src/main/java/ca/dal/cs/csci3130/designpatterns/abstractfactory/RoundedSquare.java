package ca.dal.cs.csci3130.designpatterns.abstractfactory;

public class RoundedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("This is a rounded square!");
    }
}
