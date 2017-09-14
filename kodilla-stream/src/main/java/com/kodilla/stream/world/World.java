package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {
    private final Set<Continent> continentsOfWorld = new HashSet<>();

    public void addContinent (Continent continent) {
        continentsOfWorld.add(continent);
    }
    public void removeContinent (Continent continent) {
        continentsOfWorld.remove(continent);
    }

    public BigDecimal getPeopleQuantity() {
   //     BigDecimal peopleQuantity = continentsOfWorld.stream()
    //            .flatMap(continent -> continent.)
    //    return peopleQuantity;
        return null;
    }
}
