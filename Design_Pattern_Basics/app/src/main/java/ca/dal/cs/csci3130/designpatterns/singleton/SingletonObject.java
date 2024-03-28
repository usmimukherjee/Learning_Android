package ca.dal.cs.csci3130.designpatterns.singleton;

public class SingletonObject {

    private static SingletonObject instance;

    // make the constructor private so that this class cannot be
    // instantiated
    private SingletonObject() {
    }

    // Get the only object available
    public static SingletonObject getInstance() {
        if (instance == null) {
            instance = new SingletonObject();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World!");
    }
}


