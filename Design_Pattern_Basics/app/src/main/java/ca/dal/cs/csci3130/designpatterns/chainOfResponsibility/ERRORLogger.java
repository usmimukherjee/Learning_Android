package ca.dal.cs.csci3130.designpatterns.chainOfResponsibility;

public class ERRORLogger extends AbstractLogger {

    public ERRORLogger(int errorLevel) {
        this.level = errorLevel;
    }

    @Override
    public void writeMessage(String message) {
        System.out.println("ERROR: " + message);
    }
}
