package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Test;

public class ShapeCollectorTestSuite {
    @Test
    public void testAddCircle() {
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Circle(5));

        Assert.assertEquals("Circle", shapeCollector.showFigures().get(0).getShapeName());
    }

    @Test
    public void testAddSquare() {
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Square(4));

        Assert.assertEquals("Square", shapeCollector.showFigures().get(0).getShapeName());
        Assert.assertTrue(shapeCollector.showFigures().get(0).getField() == 16);
    }

    @Test
    public void testAddTriangle() {
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Triangle(10, 6));

        Assert.assertEquals("Triangle", shapeCollector.showFigures().get(0).getShapeName());
        Assert.assertTrue(shapeCollector.showFigures().get(0).getField() == 30);
    }

    @Test
    public void removeFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle(3);
        shapeCollector.addFigure(circle);

        boolean result = shapeCollector.removeFigure(circle);

        Assert.assertTrue(result);
    }

    @Test
    public void testGetFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();

        Circle circle = new Circle(3);
        Square square = new Square(2);
        Triangle triangle = new Triangle(20, 2);

        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);
        shapeCollector.addFigure(triangle);

        Assert.assertEquals("Triangle", shapeCollector.getFigure(2).getShapeName());
        Assert.assertTrue(shapeCollector.getFigure(2).getField() == 20);
    }
}
