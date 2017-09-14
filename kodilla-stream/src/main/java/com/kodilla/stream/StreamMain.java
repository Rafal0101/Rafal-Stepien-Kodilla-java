package com.kodilla.stream;

import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;


import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        BookDirectory bookDirectory = new BookDirectory();

        String theResultStringOfBooks = bookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2010)
                .map(Book::toString)
                .collect(Collectors.joining(",\n", "<<", ">>"));

        System.out.println(theResultStringOfBooks);

        Map<String, Book> theResultMapOfBooks = bookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# Map elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);



        bookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        List<Book> theResultListOfBooks = bookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# List elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);


        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(s -> System.out.println(s));

        Processor processor = new Processor();

        Executor codeToExecute = () -> System.out.println("New Strings.");
        processor.execute(codeToExecute);

        processor.execute(() -> System.out.println("Another Strings."));

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
    }
}
