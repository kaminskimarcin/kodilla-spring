package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPINGTASK = "SHOPPING TASK";
    public static final String PAINTINGTASK = "PAINTING TASK";
    public static final String DRIVINGTASK = "DRIVING TASK";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPINGTASK:
                return new ShoppingTask("Buy", "T-shirt", 10.0);
            case PAINTINGTASK:
                return new PaintingTask("Paint", "red", "Dog");
            case DRIVINGTASK:
                return new DrivingTask("Stop", "Under the shop", "Brake");
            default:
                return null;
        }
    }
}
