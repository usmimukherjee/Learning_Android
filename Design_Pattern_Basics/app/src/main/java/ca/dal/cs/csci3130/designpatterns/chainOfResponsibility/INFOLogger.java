package ca.dal.cs.csci3130.designpatterns.chainOfResponsibility;

public class INFOLogger extends AbstractLogger {

    public INFOLogger(int infoLevel) {
        this.level = infoLevel;
    }

    @Override
    public void writeMessage(String message) {
        System.out.println("INFO: " + message);
    }
}
