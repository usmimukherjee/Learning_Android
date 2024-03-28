package ca.dal.cs.csci3130.designpatterns.abstractfactory;

public class RoundedShapeFactory extends AbstractShapeFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equals(ShapeConstants.RECTANGLE)) {
            return new RoundedRectangle();
        } else if (shapeType.equals(ShapeConstants.SQUARE)) {
            return new RoundedSquare();
        }
        return null;
    }
}
