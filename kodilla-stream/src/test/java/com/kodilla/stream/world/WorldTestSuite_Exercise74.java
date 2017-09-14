package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
/*
* Zadanie ma na celu przećwiczenie operacji flatMap() oraz reduce() wraz z użyciem typu BigDecimal.

Aby zrealizować to zadanie, będzie nam potrzebne zbudowanie struktury danych (kolekcji) reprezentującej świat. Jej elementem składowym będzie lista kontynentów. Każdy kontynent będzie posiadał listę krajów, a każdy kraj metodę zwracającą ilość zamieszkujących go ludzi.

Oczywiście nie musisz wprowadzać wszystkich danych. Ponadto dane mogą być zmyślone. Wystarczy kilka kontynentów i po kilka krajów w ramach kontynentu.

Aby zrealizować zadanie:

W katalogu src/main/java utwórz pakiet com.kodilla.stream.world
W utworzonym pakiecie utwórz klasy Country, Continent oraz World. Klasa Coutry ma udostępniać metodę getPeopleQuantity() zwracającą liczbę typu BigDecimal. Klasa Continent powinna zawierać kolekcją krajów leżących na tym kontynencie. Klasa World powinna zawierać kolekcję kontynentów
W klasie World napisz metodę getPeopleQuantity() zwracającą liczbę typu BigDecimal, która używając flatMap() oraz reduce() obliczy sumę ludności wszystkich krajów na wszystkich kontynentach.
W katalogu src/test/java stwórz pakiet com.kodilla.stream.world, a w nim zestaw testów WorldTestSuite
Napisz test testGetPeopleQuantity(), który przetestuje czy metoda getPeopleQuantity() klasy World działa prawidłowo
*/

public class WorldTestSuite_Exercise74 {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = new World();

        //When
        Country japan = new Country("Japan", new BigDecimal("222222222222222222222222222222"));
        Country china = new Country("China", new BigDecimal("111111111111111111111111111111"));
        Country spain = new Country("Spain", new BigDecimal("444444444444444444444444444444"));

        Continent asia = new Continent();
        asia.addCountry(japan);
        asia.addCountry(china);

        Continent europa = new Continent();
        europa.addCountry(spain);

        world.addContinent(asia);
        world.addContinent(europa);

        //Then
        Assert.assertEquals(new BigDecimal("777777777777777777777777777777"), world.getPeopleQuantity());
    }
}
