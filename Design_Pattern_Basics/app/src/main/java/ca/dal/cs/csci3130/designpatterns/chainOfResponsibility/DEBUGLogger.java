package ca.dal.cs.csci3130.designpatterns.chainOfResponsibility;

public class DEBUGLogger extends AbstractLogger {

    public DEBUGLogger(int debugLevel) {
        this.level = debugLevel;
    }

    @Override
    public void writeMessage(String message) {
        System.out.println("DEBUG: " + message);
    }
}
