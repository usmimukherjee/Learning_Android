package ca.dal.cs.csci3130.designpatterns.antipattern;

public class AntiPatternChild extends AntiPatternParent {

    public AntiPatternChild() {
        super();
        System.out.println("Child initialized!");
    }

    public static void main(String[] args) {

        new AntiPatternChild();
    }

}


