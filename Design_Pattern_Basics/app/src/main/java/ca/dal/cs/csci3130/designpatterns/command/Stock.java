package ca.dal.cs.csci3130.designpatterns.command;

public class Stock {
    private String name = "MSFT";
    private int quantity = 10;

    public Stock() {
    }

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void buy() {
        System.out.println("Stock bought:" + name + ", Quantity:" + quantity);
    }

    public void sell() {
        System.out.println("Stock sold:" + name + ", Quantity:" + quantity);
    }
}
