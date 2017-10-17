package com.kodilla.patterns.builder.bigmac;


import com.kodilla.patterns.builder.pizza.Pizza;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final String roll;
    private final int burgers;
    private final List<String> sauces;
    private final List<String> ingredients;

    // Begin of inner class
    public static class BigmacBuilder {
        private String roll;
        private int burgers;
        private List<String> sauces = new ArrayList<>();
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder roll(Roll roll) {
            this.roll = roll.toString();
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauces(Sauce sauce) {
            this.sauces.add(sauce.toString());
            return this;
        }

        public BigmacBuilder ingredients(Ingredients ingredient) {
            this.ingredients.add(ingredient.toString());
            return this;
        }
        public Bigmac prepare() {
            return new Bigmac(roll, burgers, sauces, ingredients);
        }

    }
    //End of inner class

    public Bigmac(final String roll, final int burgers, final List<String> sauce, final List<String> ingredients) {
        this.roll = roll;
        this.burgers = burgers;
        this.sauces = sauce;
        this.ingredients = ingredients;
    }

    public String getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public List<String> getSauce() {
        return sauces;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "roll='" + roll + '\'' +
                ", burgers=" + burgers +
                ", sauce=" + sauces +
                ", ingredients=" + ingredients +
                '}';
    }
}
