package ca.dal.cs.csci3130.designpatterns.abstractfactory;

public class ShapeFactory extends AbstractShapeFactory {

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equals(ShapeConstants.RECTANGLE)) {
            return new Rectangle();
        } else if (shapeType.equals(ShapeConstants.SQUARE)) {
            return new Square();
        }
        return null;
    }
}
