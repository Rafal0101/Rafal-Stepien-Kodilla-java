package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {
    private final Set<Continent> continentsOfWorld = new HashSet<>();

    public void addContinent(Continent continent) {
        continentsOfWorld.add(continent);
    }

    public BigDecimal getPeopleQuantity() {
        BigDecimal peopleQuantity = continentsOfWorld.stream()
                .flatMap(continent -> continent.getContinentPopulation().stream())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));

        return peopleQuantity;
    }
}
