package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        IntStream.range(1, numbers.length + 1)
                .forEach(System.out::println);

        double average;
        average = IntStream.range(1, numbers.length + 1)
                .average()
                .getAsDouble();

        return average;
    }
}
