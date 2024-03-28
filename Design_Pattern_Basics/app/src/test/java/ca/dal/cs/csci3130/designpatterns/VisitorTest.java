package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.visitor.Computer;
import ca.dal.cs.csci3130.designpatterns.visitor.ComputerPartDisplayVisitor;
import ca.dal.cs.csci3130.designpatterns.visitor.ComputerPartVisitor;

public class VisitorTest {

    @Test
    public void testVisitorPattern(){
        Computer computer=new Computer();
        ComputerPartVisitor visitor=new ComputerPartDisplayVisitor();
        computer.accept(visitor);
    }
}
