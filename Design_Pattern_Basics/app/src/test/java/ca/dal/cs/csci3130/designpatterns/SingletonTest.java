package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.singleton.SingletonObject;
import static org.junit.Assert.*;

public class SingletonTest {

    @Test
    public void testSingleton(){
        SingletonObject item1= SingletonObject.getInstance();
        SingletonObject item2= SingletonObject.getInstance();

        assertSame(item1,item2);

        System.out.println(item1);
        System.out.println(item2);
    }
}
