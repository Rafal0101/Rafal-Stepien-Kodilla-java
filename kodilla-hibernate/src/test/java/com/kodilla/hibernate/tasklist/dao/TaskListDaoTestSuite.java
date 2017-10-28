package com.kodilla.hibernate.tasklist.dao;

/*
Exercise 13.2
Zadanie: Tworzymy encję list zadań
Celem zadania jest utworzenie list zadań, do których w przyszłości przypiszemy nasze zadania typu Task.
Aby zrealizować zadanie:

W katalogu src/main/java utwórz pakiet com.kodilla.hibernate.tasklist
W pakiecie utwórz klasę TaskList, która będzie zawierała pola:
id
listName
description
Z utworzonej klasy zrób encję (tabela powinna się nazywać TASKLISTS, kolumny: ID, LISTNAME, DESCRIPTION)
Stwórz pakiet com.kodilla.hibernate.tasklist.dao
W tym pakiecie utwórz kontroler repozytorium TaskListDao z metodą List<TaskList> findByListName(String listName)
W katalogu src/test/java utwórz pakiet com.kodilla.hibernate.tasklist.dao, a w nim zestaw testów TaskListDaoTestSuite
W tym pakiecie utwórz test testFindByListName() sprawdzający czy metoda findByListName(String listName) działa poprawnie
Pamiętaj, że test powinien być idempotentny, czyli powinien po sobie "posprzątać" w bazie danych
 */

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    private static final String LIST_NAME = "Simple List Name";
    private static final String DESCRIPTION = "Simple Description";

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);

        //When
        taskListDao.save(taskList);

        //Then
        int id = taskList.getId();

        List<TaskList> resultList = taskListDao.findByListName(LIST_NAME);
        Assert.assertEquals(LIST_NAME, resultList.get(0).getListName());
        Assert.assertEquals(1, resultList.size());

        //CleanUp
        taskListDao.delete(id);
    }

    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LIST_NAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        //taskListDao.delete(id);
    }
}
