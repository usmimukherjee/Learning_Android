package ca.dal.cs.csci3130.designpatterns.state;

public class Context {
    private State state;

    public Context() {
        this.state = null;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State newState) {
        this.state = newState;
    }
}
