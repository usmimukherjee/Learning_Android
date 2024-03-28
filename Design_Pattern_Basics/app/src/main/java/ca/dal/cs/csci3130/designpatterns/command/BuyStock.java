package ca.dal.cs.csci3130.designpatterns.command;

public class BuyStock implements Order {

    Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        this.stock.buy();
    }
}
