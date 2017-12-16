package com.kodilla.patterns2.decorator.taxiportal.pizza;

import java.math.BigDecimal;

public abstract class AbstractPizzaDecorator implements Pizza {
    private final Pizza pizza;

    protected AbstractPizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public BigDecimal getPrice() {
        return pizza.getPrice();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}
