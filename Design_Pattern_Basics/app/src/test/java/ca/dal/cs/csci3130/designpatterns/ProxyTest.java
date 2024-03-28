package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.proxy.Image;
import ca.dal.cs.csci3130.designpatterns.proxy.ProxyImage;
import ca.dal.cs.csci3130.designpatterns.proxy.RealImage;

public class ProxyTest {

    @Test
    public  void testProxy(){
        Image proxyImage=new ProxyImage("abc.png");
        proxyImage.display();

        System.out.println();

        Image realImage=new RealImage("abc.png");
        realImage.display();
    }
}
