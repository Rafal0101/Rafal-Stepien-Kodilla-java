package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class Continent {
    private final Set<Country> countriesOfContinent = new HashSet<>();

    public void addCountry(Country country) {
        countriesOfContinent.add(country);
    }

    public BigDecimal getContinentPopulation() {
//        BigDecimal continentPopulation = countriesOfContinent.stream()
 //               .map(country -> country.getPeopleQuantity())

        return null;
    }

}
