package com.kodilla.patterns.patterns.spring.forum;
/*
Zadanie: Bean ForumUser

Celem zadania jest stworzenie w Kontenerze Beana klasy ForumUser i jego sprawdzenie w teście. Aby zrealizować zadanie:

W katalogu src/main/java utwórz pakiet com.kodilla.spring.forum
Napisz klasę ForumUser w pakiecie com.kodilla.spring.forum. Klasa powinna mieć pole String username inicjowane
w konstruktorze wartością "John Smith" (nie przekazuj tego jako parametr - wpisz to w konstruktorze "na sztywno").
Oznacz klasę jako @Component.
W katalogu src/test/java stwórz pakiet com.kodilla.spring.forum, a w nim zestaw testów ForumUserTestSuite.
Napisz test testGetUsername() pobierający z kontekstu aplikacji uchwyt do Beana klasy ForumUser. Test powinien
pobierać username i sprawdzać przy pomocy asercji czy zwróconą wartością jest "John Smith".
*/

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ForumUserTestSuite {
    @Test
    public void testGerUsername() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.forum");
        ForumUser forumUser = context.getBean(ForumUser.class);

        //When
        String result = forumUser.getUserName();

        //Then
        Assert.assertEquals(result, "John Smith");
    }
}
