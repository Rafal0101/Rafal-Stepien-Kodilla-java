package com.kodilla.patterns.factory.tasks;

public final class PaintingTask implements Task{
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    private static boolean isTaskExecuted = false;

    public PaintingTask(final String taskName, final String color, final String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        isTaskExecuted = true;
        System.out.println("Painting task executed == " + isTaskExecuted);
    }

    @Override
    public String getTaskName() {
        return "Task: " + taskName + ", Color: " + color + ", What to paint: " + whatToPaint;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
