package com.kodilla.patterns2.observer.forum.homework;

public class Mentor implements Observer{
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(StudentTaskQueue studentTaskQueue) {
        System.out.println(mentorName + " New message from Student: " + studentTaskQueue.getStudentName() +"\n" +
                "(total: " + studentTaskQueue.getTasks().size()  + " messages)");
        updateCount++;
    }

    public String getUserName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
