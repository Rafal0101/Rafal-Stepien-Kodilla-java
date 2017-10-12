package com.kodilla.patterns.patterns.spring.portfolio;

public final class Board {
    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneDoList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneDoList;
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}
