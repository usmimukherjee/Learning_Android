package ca.dal.cs.csci3130.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Auctioneer {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return this.state;
    }

    public void setState(int newState) {
        this.state = newState;
        this.notifyAllObservers();
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this.state);
        }
    }


}
