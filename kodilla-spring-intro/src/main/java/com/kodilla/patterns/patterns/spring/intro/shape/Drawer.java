package com.kodilla.patterns.patterns.spring.intro.shape;

public class Drawer {
    final Shape shape;

    public Drawer(Shape shape) {
        this.shape = shape;
    }

    public String doDrawing() {
        return shape.draw();
    }

    /*
    public void doDrawing() {
        Shape shape;

        shape = new Circle();
        shape.draw();

        shape = new Triangle();
        shape.draw();
    }
    */
}