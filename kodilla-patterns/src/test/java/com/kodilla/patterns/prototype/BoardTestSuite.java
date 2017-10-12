package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {
    @Test
    public void testToString() {
        //Given
        TaskList listToDo = new TaskList("To Do Tasks");
        IntStream.iterate(1, taskNumberToDo -> taskNumberToDo + 1)
                .limit(10)
                .forEach(taskNumberToDo -> listToDo.getTasks().add(new Task("To do Task number: " + taskNumberToDo)));

        TaskList listInProgress = new TaskList("In progress Tasks");
        IntStream.iterate(1, taskNumberInProgress -> taskNumberInProgress + 1)
                .limit(10)
                .forEach(taskNumberInProgress -> listInProgress.getTasks().add(new Task("In progress Task number: " + taskNumberInProgress)));

        TaskList listDone = new TaskList("Done Tasks");
        IntStream.iterate(1, taskNumberDone -> taskNumberDone + 1)
                .limit(10)
                .forEach(taskNumberDone -> listDone.getTasks().add(new Task("Done Task number: " + taskNumberDone)));

        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object board
        Board deepClonedBoard = null;
        try {
            deepClonedBoard = board.deepCopy();
            deepClonedBoard.setName("Project number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        board.getLists().remove(listToDo);

        //Then
        System.out.println(board);
        System.out.println(clonedBoard);
        System.out.println(deepClonedBoard);
        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(2, clonedBoard.getLists().size());
        Assert.assertEquals(3, deepClonedBoard.getLists().size());
        Assert.assertEquals(clonedBoard.getLists(), board.getLists());
        Assert.assertNotEquals(deepClonedBoard.getLists(), board.getLists());
    }
}
