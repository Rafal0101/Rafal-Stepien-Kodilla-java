package com.kodilla.exception.test;

import java.time.LocalDate;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1, 1.5));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("Operation executed on " + LocalDate.now());
        }
    }
}
