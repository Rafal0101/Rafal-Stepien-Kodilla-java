package com.kodilla.patterns.factory.tasks;

/*
Exercise 11.4

Zadanie: Fabryka zadań :)

Celem zadania jest utworzenie klasy zgodnie ze wzorcem Factory, która będzie odpowiedzialna za tworzenie różnego
typu zadań implementujących interfejs Task.

W celu zrealizowania zadania:

W katalogu src/main/java utwórz pakiet com.kodilla.patterns.factory.tasks
Utwórz w tym pakiecie interfejs Task, który będzie udostępniał następujące metody:
executeTask() - wykonującą zadanie,
getTaskName() - zwracającą nazwę zadania do wykonania,
isTaskExecuted() - zwracającą true lub false w zależności od tego czy zadanie jest już wykonane.
Kiedy już się z tym uporasz, utwórz klasy reprezentujące różne typy zadań:
ShoppingTask o konstruktorze ShoppingTask(String taskName, String whatToBuy, double quantity)
PaintingTask o konstruktorze PaintingTask(String taskName, String color, String whatToPaint)
DrivingTask o konstruktorze DrivingTask(String taskName, String where, String using)
Następnie wymyśl, w jaki sposób przechowywać informację o tym czy zadanie jest już wykonane i napisz fabrykę TaskFactory,
która będzie tworzyła zadania zgodnie ze wzorcem Factory.
Kiedy kod będzie już gotowy, w katalogu src/test/java utwórz pakiet com.kodilla.patterns.factory.tasks i stwórz w nim
zestaw testów TaskFactoryTestSuite
Napisz testy sprawdzające czy fabryka w poprawny sposób tworzy różne typy zadań.
 */

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task drivingTask = factory.makeTask(TaskFactory.DRIVING_TASK);
        drivingTask.executeTask();

        //Then
        Assert.assertEquals(drivingTask.getTaskName(), "Task: We are driving, Where: Warsaw, Using: Car");
        Assert.assertEquals(drivingTask.isTaskExecuted(), true);
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task paintingTask = factory.makeTask(TaskFactory.PAINTING_TASK);
        paintingTask.executeTask();

        //Then
        Assert.assertEquals(paintingTask.getTaskName(), "Task: We are painting, Color: Red, What to paint: Landscape");
        Assert.assertEquals(paintingTask.isTaskExecuted(), true);
    }

    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shoppingTask = factory.makeTask(TaskFactory.SHOPPING_TASK);
        shoppingTask.executeTask();
        //Then
        Assert.assertEquals(shoppingTask.getTaskName(), "Task: We are shopping, What to buy: Shoes, Quantity: 2.0");
        Assert.assertEquals(shoppingTask.isTaskExecuted(), true);
    }
}
