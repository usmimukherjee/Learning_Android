package ca.dal.cs.csci3130.designpatterns.strategy.arithmetic;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int number1, int number2) {
        return this.strategy.doOperation(number1, number2);
    }
}
