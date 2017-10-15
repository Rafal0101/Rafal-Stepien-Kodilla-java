package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private static boolean isTaskExecuted = false;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        isTaskExecuted = true;
        System.out.println("Driving task executed == " + isTaskExecuted);
    }

    @Override
    public String getTaskName() {
        return "Task: " + taskName + ", Where: " + where + ", Using: " + using;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
