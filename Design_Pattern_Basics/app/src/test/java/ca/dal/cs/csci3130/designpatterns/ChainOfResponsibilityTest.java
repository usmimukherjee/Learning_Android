package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.chainOfResponsibility.AbstractLogger;
import ca.dal.cs.csci3130.designpatterns.chainOfResponsibility.ChainOfLoggers;

public class ChainOfResponsibilityTest {
    @Test
    public void testCOR() {
        ChainOfLoggers chainProvider = new ChainOfLoggers();
        AbstractLogger loggerChain = chainProvider.getChainOfLoggers();
        /*Error (3)-->Debug (2)-->Info(1)*/

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information!");

        //loggerChain.logMessage(AbstractLogger.DEBUG, "This is debug level information");
        //loggerChain.logMessage(AbstractLogger.ERROR, "This is an error message!");
    }
}
