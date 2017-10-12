package com.kodilla.patterns.patterns.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class CollectionTestSuite {
    @Before
    public void before() {
        System.out.println("Before test");
    }

    @After
    public void after() {
        System.out.println("After test");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();
        ArrayList<Integer> testList = new ArrayList<>();
        List<Integer> evenNumbers = oddNumberExterminator.exterminate(testList);
        Assert.assertTrue(evenNumbers.size() == 0);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        List<Integer> evenNumbers = oddNumberExterminator.exterminate(testList);
        Assert.assertTrue(evenNumbers.size() == 1);
        Assert.assertTrue(evenNumbers.get(0) == 2);
    }
}
