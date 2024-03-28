package com.myapp.tdd_demo;

// This interface defines basic mathematical operations.
// Implementations are expected to provide functionality for addition, subtraction, multiplication, and division.
public interface Operators {

    // Adds two integers.
    int add(int a, int b);

    // Subtracts the second integer from the first.
    int subtract(int a, int b);

    // Multiplies two integers.
    int multiply(int a, int b);

    // Divides the first integer by the second. Assumes non-zero divisor.
    int divide(int a, int b);
}
