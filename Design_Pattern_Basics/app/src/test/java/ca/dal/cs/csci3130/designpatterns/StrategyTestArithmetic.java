package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.strategy.arithmetic.Add;
import ca.dal.cs.csci3130.designpatterns.strategy.arithmetic.Context;
import ca.dal.cs.csci3130.designpatterns.strategy.arithmetic.Multiply;
import ca.dal.cs.csci3130.designpatterns.strategy.arithmetic.Strategy;
import ca.dal.cs.csci3130.designpatterns.strategy.arithmetic.Subtract;

public class StrategyTestArithmetic {

    @Test
    public void testStrategy() {
        Strategy strategy1 = new Add();
        Context context = new Context(strategy1);
        context.executeStrategy(10, 5);

        Strategy strategy2 = new Subtract();
        context = new Context(strategy2);
        context.executeStrategy(10, 5);

        Strategy strategy3 = new Multiply();
        context = new Context(strategy3);
        context.executeStrategy(10, 5);
    }
}
