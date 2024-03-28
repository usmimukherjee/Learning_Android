package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.command.Broker;
import ca.dal.cs.csci3130.designpatterns.command.BuyStock;
import ca.dal.cs.csci3130.designpatterns.command.SellStock;
import ca.dal.cs.csci3130.designpatterns.command.Stock;

public class CommandTest {

    @Test
    public void testCommandPattern() {
        Stock stock = new Stock();
        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);
        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);

        broker.placeOrders();

        Stock secondStock = new Stock("IBM", 15);
        BuyStock buyStock2 = new BuyStock(secondStock);
        SellStock sellStock2 = new SellStock(secondStock);
        Broker secondBroker = new Broker();
        secondBroker.takeOrder(buyStock2);
        secondBroker.takeOrder(sellStock2);

        secondBroker.placeOrders();


    }

}
