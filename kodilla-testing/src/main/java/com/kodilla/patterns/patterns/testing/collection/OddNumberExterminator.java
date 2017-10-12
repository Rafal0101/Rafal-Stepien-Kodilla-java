package com.kodilla.patterns.patterns.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumberExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        for (Integer number : numbers
                ) {
            if ((number % 2) == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }
}
