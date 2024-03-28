package ca.dal.cs.csci3130.designpatterns.cab.visitor;

public class Customer implements ICustomer {
    String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void accept(Vehicle vehicle) {
        this.accept(vehicle);
        vehicle.transport(this);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
