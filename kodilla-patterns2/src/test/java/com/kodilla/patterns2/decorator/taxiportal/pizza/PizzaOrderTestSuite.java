package com.kodilla.patterns2.decorator.taxiportal.pizza;

/*
Exercise 20.2
Zadanie: Dekorujemy pizzę
Twoim zadaniem jest zastosowanie wzorca Dekorator do stworzenia pizzy. Podstawowa pizza (ciasto i sos pomidorowy z serem)
będzie kosztowała 15 złotych. Możliwe jest udekorowanie pizzy dodatkowymi składnikami i dodatkowym serem.
Stwórz w katalogu src/main/java w pakiecie com.kodilla.patterns2.decorator.pizza interfejs do zamawiania pizzy oraz
zestaw klas - delegat oraz dekoratory. Użyj swojej fantazji i apetytu podczas wybierania dostępnych dekoracji pizzy.

Następnie w katalogu src/test/java utwórz pakiet com.kodilla.patterns2.decorator.pizza, a w nim zestaw testów
PizzaOrderTestSuite. Stwórz kilka testów pokazujących kaskadowe łączenie dekoratorów. Testy mają prezentować cenę
zamówionej pizzy oraz wyświetlać jej opis.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class PizzaOrderTestSuite {
    Pizza pizza = new BasicPizza();

    @Before
    public void createFullOptionPizza() {
        pizza = new AdditionalIngredientHam(pizza);
        pizza = new AdditionalIngredientHam(pizza);
        pizza = new AdditionalIngredientSalami(pizza);
        pizza = new AdditionalIngredientTomatoSauce(pizza);
        pizza = new AdditionalIngredientGarlicSauce(pizza);
    }

    @Test
    public void testFullOptionPizzaGetPrice() {
        //When
        BigDecimal price = pizza.getPrice();

        //Then
        assertEquals(new BigDecimal(40), price);
    }

    @Test
    public void testFullOptionPizzaDescription() {
        //When
        String description = pizza.getDescription();

        //Then
        assertEquals("Standard + ham + ham + salami + tomato sauce + garlic sauce", description);
    }
}
