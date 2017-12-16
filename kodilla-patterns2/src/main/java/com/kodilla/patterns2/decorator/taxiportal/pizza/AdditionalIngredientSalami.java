package com.kodilla.patterns2.decorator.taxiportal.pizza;

import java.math.BigDecimal;

public class AdditionalIngredientSalami extends AbstractPizzaDecorator {
    public AdditionalIngredientSalami(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + salami";
    }
}
