package com.kodilla.patterns.patterns.spring.library;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class LibraryTestSuite {
    @Test
    public void loadFromDb() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.library");
        Library library = context.getBean(Library.class);

        //When
        library.loadFromDb();
    }

    @Test
    public void saveToDb() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.library");
        Library library = context.getBean(Library.class);

        //When
        library.saveToDb();
    }
    @Test
    public void testContext() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(LibraryConfig.class);

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
    @Test
    public void testContext2() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");

        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}
