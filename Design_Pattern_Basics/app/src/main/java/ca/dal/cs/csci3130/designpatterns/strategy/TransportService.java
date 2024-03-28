package ca.dal.cs.csci3130.designpatterns.strategy;

public class TransportService {
    private Strategy strategy;

    public TransportService(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        this.strategy.drive();
    }
}
