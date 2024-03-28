package ca.dal.cs.csci3130.designpatterns.state.vending;

public class Environment {
    private VendingMachineState state;

    public Environment() {
        this.state = null;
    }

    public VendingMachineState getState() {
        return this.state;
    }

    public void setState(VendingMachineState newState) {
        this.state = newState;
    }

}
