package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.cab.visitor.Cab;
import ca.dal.cs.csci3130.designpatterns.cab.visitor.Customer;
import ca.dal.cs.csci3130.designpatterns.cab.visitor.ICustomer;
import ca.dal.cs.csci3130.designpatterns.cab.visitor.Vehicle;

public class CabVisitorTest {

    @Test
    public void testCabVisitor() {
        Customer customer=new Customer("John");
        Vehicle cab=new Cab();
        cab.transport(customer);

        Customer customer2=new Customer("Jane");
        Vehicle cab2=new Cab();
        cab2.transport(customer2);

    }
}
