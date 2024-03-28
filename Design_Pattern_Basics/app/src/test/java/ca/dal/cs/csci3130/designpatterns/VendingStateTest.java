package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;
import ca.dal.cs.csci3130.designpatterns.state.vending.Environment;
import ca.dal.cs.csci3130.designpatterns.state.vending.VendingDepositState;
import ca.dal.cs.csci3130.designpatterns.state.vending.VendingStockState;

public class VendingStateTest {

    @Test
    public void testVendingStatePattern() {
        Environment environment=new Environment();
        VendingDepositState depositState=new VendingDepositState();
        depositState.doAction(environment);

        System.out.println(environment.getState().toString() +": Deposit your coins!");

        VendingStockState stockState=new VendingStockState();
        stockState.doAction(environment);

        System.out.println(environment.getState().toString() +": Collect your chips!");
    }
}
