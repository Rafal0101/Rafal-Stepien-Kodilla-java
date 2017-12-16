package com.kodilla.patterns2.decorator.taxiportal.pizza;

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
