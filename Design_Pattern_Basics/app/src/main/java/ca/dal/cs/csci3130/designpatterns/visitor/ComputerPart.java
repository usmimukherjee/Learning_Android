package ca.dal.cs.csci3130.designpatterns.visitor;

public interface ComputerPart {
    public void accept(ComputerPartVisitor visitor);
}
