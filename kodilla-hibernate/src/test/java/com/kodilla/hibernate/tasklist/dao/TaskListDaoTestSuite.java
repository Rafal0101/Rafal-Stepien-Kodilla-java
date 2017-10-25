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

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;

    private static final String LIST_NAME = "Simple List Name";
    private static final String DESCRIPTION = "Simple Description";

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
}
