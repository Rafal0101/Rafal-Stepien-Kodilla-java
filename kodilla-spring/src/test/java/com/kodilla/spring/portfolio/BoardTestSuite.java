package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class BoardTestSuite {
    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        List<String> toDoList = board.getToDoList().getTasks();
        List<String> inProgressList = board.getInProgressList().getTasks();
        List<String> doneList = board.getDoneList().getTasks();

        toDoList.add("Task to do.");
        inProgressList.add("Task in progress.");
        doneList.add("Task terminated.");

        //Then
        Assert.assertEquals(board.getToDoList().getTasks().get(0), "Task to do.");
        Assert.assertEquals(board.getInProgressList().getTasks().get(0), "Task in progress.");
        Assert.assertEquals(board.getDoneList().getTasks().get(0), "Task terminated.");
    }
}
