package com.kodilla.patterns2.decorator.taxiportal.pizza;

import java.math.BigDecimal;

public class AdditionalIngredientHam extends AbstractPizzaDecorator {
    public AdditionalIngredientHam(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ham";
    }

}
