package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.facade.ShapeMaker;

public class FacadeTest {

    @Test
    public void testFacadePattern() {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
