package ca.dal.cs.csci3130.designpatterns.strategy.arithmetic;

public class Add implements Strategy {

    @Override
    public int doOperation(int number1, int number2) {
        return number1 + number2;
    }
}
