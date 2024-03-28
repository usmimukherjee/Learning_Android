package ca.dal.cs.csci3130.designpatterns.abstractfactory;

public class FactoryProducer {
    public AbstractShapeFactory getFactory(boolean isRounded) {
        if (isRounded) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory();
        }
    }
}
