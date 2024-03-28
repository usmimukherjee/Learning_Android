package ca.dal.cs.csci3130.designpatterns.state;

public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("INTERNAL: start state!");
        context.setState(this);
    }

    public String toString() {
        return "START";
    }

}
