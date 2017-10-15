package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String DRIVING_TASK = "DRIVING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String SHOPPING_TASK = "SHOPPING_TASK";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case DRIVING_TASK:
                return new DrivingTask("We are driving", "Warsaw", "Car");
            case PAINTING_TASK:
                return new PaintingTask("We are painting", "Red", "Landscape");
            case SHOPPING_TASK:
                return new ShoppingTask("We are shopping", "Shoes", 2);
            default:
                return null;
        }
    }
}
