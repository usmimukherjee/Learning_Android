package ca.dal.cs.csci3130.designpatterns.cab.visitor;

public class Cab implements Vehicle {
    @Override
    public void transport(ICustomer customer) {
        System.out.println(customer.getName() + " is moving from Halifax to Montreal!");
    }
}
