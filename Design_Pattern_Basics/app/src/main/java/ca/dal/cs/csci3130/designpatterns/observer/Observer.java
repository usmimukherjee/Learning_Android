package ca.dal.cs.csci3130.designpatterns.observer;

public abstract class Observer {
    public Auctioneer auctioneer;

    public abstract void update(int state);
}
