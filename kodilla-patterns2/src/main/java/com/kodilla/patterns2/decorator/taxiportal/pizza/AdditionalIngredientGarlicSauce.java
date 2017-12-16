package com.kodilla.patterns2.decorator.taxiportal.pizza;

import java.math.BigDecimal;

public class AdditionalIngredientGarlicSauce extends AbstractPizzaDecorator{
    public AdditionalIngredientGarlicSauce(Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice().add(new BigDecimal(3));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + garlic sauce";
    }

}
