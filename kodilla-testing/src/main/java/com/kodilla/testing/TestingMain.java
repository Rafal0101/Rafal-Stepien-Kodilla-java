package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUserName();

        if (result.equals("theForumUser")) {
            System.out.println("test OK!");
        } else {
            System.out.println("Error.");
        }

        Calculator calculator = new Calculator();
        int addResult = calculator.sum(4,11);
        int subtractResult = calculator.subtract(100, 1);
        if (addResult == 15 && subtractResult == 99) {
            System.out.println("Calculator test OK.");
        } else {
            System.out.println("Calculator test error.");
        }
    }
}
