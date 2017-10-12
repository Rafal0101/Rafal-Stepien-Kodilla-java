package com.kodilla.patterns.patterns.spring.intro.shape;

import org.junit.Assert;
import org.junit.Test;

public class DrawerTestSuit {
    @Test
    public void testDoDrawingWithCircle() {
        Circle circle = new Circle();
        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();
        Assert.assertEquals(result, "This is a circle");
    }

    @Test
    public void testDoDrawingWithTriangle() {
        Triangle triangle = new Triangle();
        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();
        Assert.assertEquals(result, "This is a triangle");
    }
}
