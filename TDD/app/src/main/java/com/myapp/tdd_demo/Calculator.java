package com.myapp.tdd_demo;

// This class represents a basic calculator that performs arithmetic operations using an 'Operators' interface.
public class Calculator {

    // The 'Operators' instance used by the calculator to perform operations.
    public Operators operators;

    // Constructor that initializes the calculator with an 'Operators' implementation.
    public Calculator(Operators operators) {
        this.operators = operators;
    }

    // Adds two numbers using the 'Operators' instance.
    public int addTwoNumbers(int ab, int ba) {
        return operators.add(ab, ba);
    }

    // Subtracts the second number from the first using the 'Operators' instance.
    public int subtractTwoNumbers(int ac, int bc) {
        return operators.subtract(ac, bc);
    }

    // Multiplies two numbers using the 'Operators' instance.
    public int multiplyTwoNumbers(int ad, int bd) {
        return operators.multiply(ad, bd);
    }

    // Divides the first number by the second using the 'Operators' instance.
    // Assumes non-zero divisor.
    public int divideTwoNumbers(int aa, int ba) {
        return operators.divide(aa, ba);
    }
}

