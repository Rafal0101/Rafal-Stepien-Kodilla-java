package com.kodilla.patterns2.decorator.taxiportal.pizza;

import java.math.BigDecimal;

public class AdditionalIngredientTomatoSauce extends AbstractPizzaDecorator {
    public AdditionalIngredientTomatoSauce(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(2));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + tomato sauce";
    }

}
