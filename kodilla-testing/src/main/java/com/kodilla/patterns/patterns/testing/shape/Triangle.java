package com.kodilla.patterns.patterns.testing.shape;

public class Triangle implements Shape {
    private final double side;
    private final double height;

    public Triangle(double side, double height) {
        this.side = side;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return (0.5 * side * height);
    }
}
