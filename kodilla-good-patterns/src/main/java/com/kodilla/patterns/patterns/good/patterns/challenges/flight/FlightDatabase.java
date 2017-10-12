package com.kodilla.patterns.patterns.good.patterns.challenges.flight;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDatabase {
    public List<Flight> createSampleData() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Wroclaw", "Gdansk", LocalTime.of(7, 12)));
        flights.add(new Flight("Wroclaw", "Gdansk", LocalTime.of(11, 15)));
        flights.add(new Flight("Wroclaw", "Gdansk", LocalTime.of(17, 45)));
        flights.add(new Flight("Wroclaw", "Gdansk", LocalTime.of(22, 0)));
        flights.add(new Flight("Wroclaw", "Gdansk", "Warszawa", LocalTime.of(3, 50)));
        flights.add(new Flight("Wroclaw", "Gdansk", "Warszawa", LocalTime.of(13, 30)));
        flights.add(new Flight("Wroclaw", "Gdansk", "Krakow", LocalTime.of(19, 25)));
        flights.add(new Flight("Gdansk", "Wroclaw", LocalTime.of(9, 0)));
        flights.add(new Flight("Gdansk", "Wroclaw", "Warszawa", LocalTime.of(14, 5)));
        flights.add(new Flight("Gdansk", "Wroclaw", "Radom", LocalTime.of(15, 40)));
        return flights;
    }
}
