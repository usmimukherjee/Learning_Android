package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;

import ca.dal.cs.csci3130.designpatterns.factory.Circle;
import ca.dal.cs.csci3130.designpatterns.factory.Rectangle;
import ca.dal.cs.csci3130.designpatterns.factory.Shape;
import ca.dal.cs.csci3130.designpatterns.factory.ShapeConstants;
import ca.dal.cs.csci3130.designpatterns.factory.ShapeFactory;
import ca.dal.cs.csci3130.designpatterns.factory.Square;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FactoryTest {

    @Test
    public void testFactoryMethod() {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.getShape(ShapeConstants.CIRCLE);
        assertThat(circle, instanceOf(Circle.class));
        assertFalse(circle instanceof Rectangle);

        Shape rectangle=factory.getShape(ShapeConstants.RECTANGLE);
        assertThat(rectangle, instanceOf(Rectangle.class));
        assertTrue(rectangle instanceof Rectangle);

        Shape square=factory.getShape(ShapeConstants.SQUARE);
        assertThat(square, instanceOf(Square.class));
        assertFalse(square instanceof Rectangle);
    }
}
