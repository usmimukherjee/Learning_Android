package ca.dal.cs.csci3130.designpatterns.state;

public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("INTERNAL: stop state!");
        context.setState(this);
    }

    public String toString() {
        return "STOP";
    }
}
