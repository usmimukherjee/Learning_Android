package ca.dal.cs.csci3130.designpatterns;

import org.junit.Test;
import ca.dal.cs.csci3130.designpatterns.abstractfactory.AbstractShapeFactory;
import ca.dal.cs.csci3130.designpatterns.abstractfactory.FactoryProducer;
import ca.dal.cs.csci3130.designpatterns.abstractfactory.Rectangle;
import ca.dal.cs.csci3130.designpatterns.abstractfactory.RoundedRectangle;
import ca.dal.cs.csci3130.designpatterns.abstractfactory.RoundedSquare;
import ca.dal.cs.csci3130.designpatterns.abstractfactory.Shape;
import ca.dal.cs.csci3130.designpatterns.abstractfactory.ShapeConstants;
import ca.dal.cs.csci3130.designpatterns.abstractfactory.Square;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;

public class AbstractFactoryTest {

    @Test
    public void testAbstractFactoryMethod() {
        FactoryProducer producer = new FactoryProducer();
        AbstractShapeFactory factory = producer.getFactory(true);
        Shape roundedRectange = factory.getShape(ShapeConstants.RECTANGLE);
        roundedRectange.draw();
        assertThat(roundedRectange, instanceOf(RoundedRectangle.class));
        assertFalse(roundedRectange instanceof Rectangle);

        AbstractShapeFactory secondFactory = producer.getFactory(false);
        Shape square = secondFactory.getShape(ShapeConstants.SQUARE);
        square.draw();
        assertThat(square, instanceOf(Square.class));
        assertFalse(square instanceof RoundedSquare);
    }
}
