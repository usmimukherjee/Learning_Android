package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.bridge.BlueCircle;
import ca.dal.cs.csci3130.designpatterns.bridge.Circle;
import ca.dal.cs.csci3130.designpatterns.bridge.DrawAPI;
import ca.dal.cs.csci3130.designpatterns.bridge.RedCircle;
import ca.dal.cs.csci3130.designpatterns.bridge.Shape;

public class BridgePatternTest {

    @Test
    public void testRedCircleDraw() {
        Shape shape1=new Circle(10,0,0, new RedCircle());
        shape1.draw();
    }

    @Test
    public  void testBlueCircle(){
        Shape shape2=new Circle(20,5,5, new BlueCircle());
        shape2.draw();
    }


}
