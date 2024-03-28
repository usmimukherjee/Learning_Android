package ca.dal.cs.csci3130.designpatterns.factory;

public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType.equals(ShapeConstants.RECTANGLE)) {
            return new Rectangle();
        } else if (shapeType.equals(ShapeConstants.CIRCLE)) {
            return new Circle();
        } else if (shapeType.equals(ShapeConstants.SQUARE)) {
            return new Square();
        }
        return null;
    }
}
