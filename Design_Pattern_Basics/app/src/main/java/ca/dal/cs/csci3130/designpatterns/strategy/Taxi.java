package ca.dal.cs.csci3130.designpatterns.strategy;

public class Taxi implements Strategy {
    @Override
    public void drive() {
        System.out.println("Drove by Taxi!");
    }
}
