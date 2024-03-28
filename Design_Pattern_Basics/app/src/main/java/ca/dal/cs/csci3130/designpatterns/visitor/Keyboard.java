package ca.dal.cs.csci3130.designpatterns.visitor;

public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}
