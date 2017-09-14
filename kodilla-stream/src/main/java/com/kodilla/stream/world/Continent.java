package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class Continent {
    private final Set<Country> countriesOfContinent = new HashSet<>();

    public void addCountry(Country country) {
        countriesOfContinent.add(country);
    }

    public Set<BigDecimal> getContinentPopulation() {
        return countriesOfContinent.stream()
                .map(country -> country.getPeopleQuantity())
                .collect(Collectors.toSet());
    }

}
