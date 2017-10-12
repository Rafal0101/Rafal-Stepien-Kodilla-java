package com.kodilla.patterns.patterns.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .forEach(t -> System.out.println(numbers[t]));

        double average;
        average = IntStream.range(0, numbers.length)
                .map(t -> numbers[t])
                .average()
                .getAsDouble();

        return average;
    }
}
