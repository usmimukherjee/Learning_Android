package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.composite.Employee;

public class CompositeTest {

    @Test
    public void testComposite() {
        Employee ceo = new Employee("Jane", "CEO", 500000);

        Employee headSales = new Employee("Rob", "Head Sales", 450000);
        ceo.add(headSales);

        Employee salesExecutive1 = new Employee("Pamela", "Sales", 100000);
        Employee salesExecutive2 = new Employee("Roy", "Sales", 100000);
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        ceo.show();
        ceo.getSubordinates().get(0).show();
        ceo.getSubordinates().get(0).getSubordinates().get(0).show();
        ceo.getSubordinates().get(0).getSubordinates().get(1).show();
    }
}
