package ca.dal.cs.csci3130.designpatterns.state.vending;

public class VendingStockState implements VendingMachineState {
    @Override
    public void doAction(Environment environment) {
        System.out.println("Stock state: collect the chips!");
        environment.setState(this);
    }

    public String toString() {
        return "STOCK";
    }
}
