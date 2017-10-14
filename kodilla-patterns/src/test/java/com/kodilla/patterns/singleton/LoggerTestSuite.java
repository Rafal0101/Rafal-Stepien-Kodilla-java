package com.kodilla.patterns.singleton;

/*
Exercise 11.1
Utwórz w katalogu src/test/java w pakiecie com.kodilla.patterns.singleton nowy zestaw testów o nazwie LoggerTestSuite,
a w nim testy sprawdzające działanie metod log(String log) oraz getLastLog() klasy Logger
Zmodyfikuj kod klasy Logger tak, aby była zgodna ze wzorcem Singleton
Zmodyfikuj napisane przed chwilą testy tak, aby uwzględniały zmiany w klasie Logger
 */

import org.junit.Assert;

import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {
        //Given
        Logger.getInstance().log("Some information.");
        //When
        String log = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals(log, "Some information.");
    }
}
