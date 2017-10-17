package com.kodilla.patterns.builder.bigmac;

/*
Exercise 11.5
Zadanie: Komponujemy własnego BigMaca
Celem zadania jest przećwiczenie użycia wzorca Builder. Stworzymy klasę reprezentującą popularną kanapkę BigMac.
Ma ona zestaw domyślnych składników, można ją również “rozszerzać” o niestandardowe składniki, np. bekon :)

Aby zrealizować zadanie:

W katalogu src/main/java utwórz pakiet com.kodilla.patterns.builder.bigmac
W tym pakiecie utwórz klasę Bigmac zawierającą następujące pola: roll (pol. bułka - może być z sezamem lub bez),
burgers -oznaczającą ilość kotletów wołowych w środku kanapki, sauce - oznaczającą rodzaj użytego sosu
(standard, 1000 wysp, barbecue), ingredients - oznaczającą listę składników dodatkowych (możliwe wartości to: sałata,
cebula, bekon, ogórek, papryczki chilli, pieczarki, krewetki, ser)
Stwórz wewnętrzną klasę BigmacBuilder zgodną ze wzorcem Builder
W katalogu src/test/java utwórz pakiet com.kodilla.patterns.builder.bigmac
Stwórz zestaw testów o nazwie BigmacTestSuite oraz test sprawdzający czy wzorzec Builder działa prawidłowo.
*/


import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testNewBigmac() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll(Roll.ROLL_WITHOUT_SESAME)
                .burgers(3)
                .sauces(Sauce.THOUSEND_ISLANDS)
                .sauces(Sauce.BARBECUE)
                .ingredients(Ingredients.BACON)
                .ingredients(Ingredients.MUSHROOMS)
                .ingredients(Ingredients.ONION)
                .ingredients(Ingredients.PEPPERS)
                .ingredients(Ingredients.BACON)
                .sauces(Sauce.STANDARD)
                .prepare();

        //When
        int baconIngredient = 0;
        for (String ingredient : bigmac.getIngredients()
             ) {
            if (ingredient == Ingredients.BACON.toString()) {
                baconIngredient ++;
            }
        }

        //Then
        Assert.assertEquals(5, bigmac.getIngredients().size());
        Assert.assertEquals(2, baconIngredient);
        Assert.assertEquals(3, bigmac.getSauce().size());
        Assert.assertEquals(Roll.ROLL_WITHOUT_SESAME.toString(), bigmac.getRoll());
        Assert.assertEquals(3, bigmac.getBurgers());
    }
}
