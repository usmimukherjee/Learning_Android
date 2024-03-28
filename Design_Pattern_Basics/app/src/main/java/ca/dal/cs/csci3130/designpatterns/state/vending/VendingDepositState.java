package ca.dal.cs.csci3130.designpatterns.state.vending;

public class VendingDepositState implements VendingMachineState {
    @Override
    public void doAction(Environment environment) {
        System.out.println("Deposit state: accepting the coins");
        environment.setState(this);
    }

    public String toString() {
        return "DEPOSIT";
    }
}
