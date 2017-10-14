package com.kodilla.patterns.patterns.spring.portfolio;
/*
Exercise 10.3
Utwórz w katalogu src/main/java pakiet com.kodilla.spring.portfolio, a w nim klasę Board posiadającą trzy pola:
toDoList, inProgressList oraz doneList. Pola te powinny być typu TaskList. Utwórz również klasę TaskList w tym samym
pakiecie - powinna ona zawierać właściwość List<String> tasks. Jej zawartość powinna być inicjowana w konstruktorze
przy pomocy polecenia tasks = new ArrayList<>();
Napisz klasę konfigurującą Beany o nazwie BoardConfig, która utworzy trzy różne Beany reprezentujące listy zadań
i wstrzyknie je do Beana klasy Board.
W katalogu src/test/java utwórz pakiet com.kodilla.spring.portfolio, a w niem zestaw testów BoardTestSuite.
Utwórz też test testTaskAdd(), który doda do każdej z list po jednym zadaniu (wcześniej uzyskując dostęp do Beana
klasy Board). Test powinien sprawdzać czy dodane zadania da się odczytać.
 */

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
