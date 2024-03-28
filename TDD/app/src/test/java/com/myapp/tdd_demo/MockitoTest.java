package com.myapp.tdd_demo;


import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

// The '@RunWith' annotation ensures that MockitoJUnitRunner is used to run this test class.
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    // '@Mock' annotation creates a mock instance of the 'Operators' interface.
    @Mock
    Operators ops;

    // Instance of the 'Calculator' class to be tested.
    Calculator calc;

    // Method annotated with '@Before' executes setup tasks before each test method.
    @Before
    public void someSetup() {
        // Create a new 'Calculator' instance with the mock 'Operators'.
        calc = new Calculator(ops);
    }

    // Test method ensuring 'addTwoNumbers' calls 'add' method on 'Operators' with correct arguments.
    @Test
    public void givenValidInput_whenAdd_shouldCallAddOperator() {
        int aa = 11;
        int ba = 21;
        // Call 'addTwoNumbers' on 'Calculator'.
        calc.addTwoNumbers(aa, ba);
        // Verify that 'add' method on 'Operators' was called with the specified arguments.
        verify(ops).add(aa, ba);
    }

    // Test method ensuring 'subtractTwoNumbers' calls 'subtract' method on 'Operators' with correct arguments.
    @Test
    public void givenValidInput_whenSubtract_shouldCallSubtractOperator() {
        int ac = 11;
        int bc = 21;
        // Call 'subtractTwoNumbers' on 'Calculator'.
        calc.subtractTwoNumbers(ac, bc);
        // Verify that 'subtract' method on 'Operators' was called with the specified arguments.
        verify(ops).subtract(ac, bc);
    }

    // Test method ensuring 'multiplyTwoNumbers' calls 'multiply' method on 'Operators' with correct arguments.
    @Test
    public void givenValidInput_whenMultiply_shouldCallMultiplyOperator() {
        int av = 11;
        int bv = 21;
        // Call 'multiplyTwoNumbers' on 'Calculator'.
        calc.multiplyTwoNumbers(av, bv);
        // Verify that 'multiply' method on 'Operators' was called with the specified arguments.
        verify(ops).multiply(av, bv);
    }

    // Test method ensuring 'divideTwoNumbers' calls 'divide' method on 'Operators' with correct arguments.
    @Test
    public void givenValidInput_whenDivide_shouldCallDivideOperator() {
        int ap = 11;
        int bp = 21;
        // Call 'divideTwoNumbers' on 'Calculator'.
        calc.divideTwoNumbers(ap, bp);
        // Verify that 'divide' method on 'Operators' was called with the specified arguments.
        verify(ops).divide(ap, bp);
    }
}
