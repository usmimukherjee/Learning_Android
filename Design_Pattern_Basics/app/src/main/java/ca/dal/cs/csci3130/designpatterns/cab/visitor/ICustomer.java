package ca.dal.cs.csci3130.designpatterns.cab.visitor;

public interface ICustomer {
    public void accept(Vehicle vehicle);
    public String getName();
}
