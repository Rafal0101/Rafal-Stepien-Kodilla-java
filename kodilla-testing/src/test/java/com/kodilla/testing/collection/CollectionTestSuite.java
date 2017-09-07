package com.kodilla.testing.collection;

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
/*
    private ArrayList<Integer> generateNumbers() {
        ArrayList<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            randomList.add(random.nextInt(100));
        }
        return randomList;
    }


    private boolean oddNumberExist(ArrayList<Integer> items) {
        for (int i = 0; i < items.size(); i++) {
            if ((items.get(i) % 2 != 0)) {
                return false;
            }
        }
        return true;
    }
*/
}
