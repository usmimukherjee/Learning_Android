package ca.dal.cs.csci3130.designpatterns.strategy;

public class CityBus implements Strategy {
    @Override
    public void drive() {
        System.out.println("Drove by Bus!");
    }
}
