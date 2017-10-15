package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task{
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    private static boolean isTaskExecuted = false;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        isTaskExecuted = true;
        System.out.println("Shopping task executed == " + isTaskExecuted);
    }

    @Override
    public String getTaskName() {
        return "Task: " + taskName + ", What to buy: " + whatToBuy + ", Quantity: " + quantity;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
