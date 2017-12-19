package com.kodilla.patterns2.observer.forum.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentTaskQueue implements Observable {
    private final List<Observer> observers;
    private final List<String> tasks;
    private final String studentName;

    public StudentTaskQueue(String studentName) {
        this.observers = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.studentName = studentName;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers
                ) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getStudentName() {
        return studentName;
    }
}
