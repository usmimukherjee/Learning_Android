package ca.dal.cs.csci3130.designpatterns.command;

public class SellStock implements Order {
    Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.stock.sell();
    }
}
