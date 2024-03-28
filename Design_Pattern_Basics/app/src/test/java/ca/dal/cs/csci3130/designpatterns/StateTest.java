package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.state.Context;
import ca.dal.cs.csci3130.designpatterns.state.StartState;
import ca.dal.cs.csci3130.designpatterns.state.State;
import ca.dal.cs.csci3130.designpatterns.state.StopState;

public class StateTest {

    @Test
    public void testStatePattern(){
        Context context=new Context();

        StartState start=new StartState();
        start.doAction(context);

        System.out.println("Context is in "+ context.getState().toString() +" state");

        StopState stop=new StopState();
        stop.doAction(context);

        System.out.println("Context is in "+context.getState().toString()+" state");

    }
}
