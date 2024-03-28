package ca.dal.cs.csci3130.designpatterns.chainOfResponsibility;

public class ChainOfLoggers {
    public AbstractLogger getChainOfLoggers() {
        AbstractLogger errorLogger = new ERRORLogger(AbstractLogger.ERROR);
        AbstractLogger debugLogger = new DEBUGLogger(AbstractLogger.DEBUG);
        AbstractLogger infoLogger = new INFOLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        return errorLogger;
    }
}
