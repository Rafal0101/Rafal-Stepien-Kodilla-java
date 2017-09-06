package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

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
        ArrayList<Integer> emptyList = new ArrayList<>();
        ArrayList<Integer> evenNumbers = oddNumberExterminator.exterminate(emptyList);
        Assert.assertTrue(oddNumberExist(evenNumbers));
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();
        ArrayList<Integer> evenNumbers = oddNumberExterminator.exterminate(generateNumbers());
        Assert.assertTrue(oddNumberExist(evenNumbers));
    }

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
}
