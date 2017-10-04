package com.kodilla.spring.calculator;

import org.springframework.stereotype.Repository;

@Repository //or might be more generally: @Component
public class Display {
    public void displayValue(double val) {
        System.out.println("Operation value: " + val);
    }
}
