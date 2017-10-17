package com.kodilla.patterns.strategy.social;
/*
Exercise 11.3
Zadanie: Media społecznościowe użytkowników
Celem zadania jest stworzenie użytkowników wraz z ich ulubionym kanałem komunikacji społecznościowej
(Facebook, Twitter, Snapchat). Wykorzystaj do tego celu wzorzec Strategy - jako wybrana przez użytkownika strategia
komunikowania się ze światem zewnętrznym.

Aby zrealizować zadanie:

W katalogu src/main/java utwórz pakiet com.kodilla.patterns.strategy.social
Utwórz klasę User zawierającą nazwę użytkownika
Utwórz dziedziczące z niej klasy Millenials, YGeneration oraz ZGeneration
Stwórz interfejs SocialPublisher zawierający metodę share()
Stwórz implementujące go klasy FacebookPublisher, TwitterPublisher oraz SnapchatPublisher - niech wyświetlają nazwę
medium społecznego, którego używają
Zastosuje wzorzec Strategy do klas User oraz klas dziedziczących z tej klasy - w konstruktorze ustaw dla danej kategorii
użytkownika odpowiednie medium społecznościowe, a w klasie User dodaj metodę sharePost()
W katalogu src/test/java stwórz pakiet com.kodilla.patterns.strategy.social
Utwórz zestaw testów UserTestSuite, a w nim dwa testy: testDefaultSharingStrategies()
oraz testIndividualSharingStrategy()sprawdzające czy domyślnie utworzone obiekty generujące wpisy w mediach
społecznościowych są poprawne, a także czy możliwa jest indywidualna zmiana upodobań użytkownika.

*/

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User anna = new Millenials("Millenials Anna ");
        User john = new YGeneration("YGeneration John ");
        User kate = new ZGeneration("ZGeneration Kate ");

        //When
        String annaPublish = anna.socialPublisher.share();
        String johnPublish = john.socialPublisher.share();
        String katePublish = kate.socialPublisher.share();

        //Then
        Assert.assertEquals("Facebook publisher!", annaPublish);
        Assert.assertEquals("Snapchat publisher!", johnPublish);
        Assert.assertEquals("Twitter publisher!", katePublish);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User kate = new YGeneration("");

        //When
        String katePublish = kate.socialPublisher.share();
        kate.setSocialPublisher(new FacebookPublisher());
        katePublish = kate.socialPublisher.share();

        //Then
        Assert.assertEquals("Facebook publisher!", katePublish);
    }
}
