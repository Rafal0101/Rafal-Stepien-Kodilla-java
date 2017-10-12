package com.kodilla.patterns.patterns.good.patterns.challenges.flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightSearcher {
    public static List<Flight> findFlightsFrom(String flightFrom, List<Flight> flights) {
        return flights.stream()
                .filter(n -> n.getDeparturePort().equals(flightFrom))
                .collect(Collectors.toList());
    }

    public static List<Flight> findFlightsTo(String flightTo, List<Flight> flights) {
        return flights.stream()
                .filter(n -> n.getArrivalPort().equals(flightTo))
                .collect(Collectors.toList());
    }

    public static List<Flight> findFlightsBy(String flightBy, List<Flight> flights) {
        return flights.stream()
                .filter(n -> n.getMedialPort() != null)
                .filter(n -> n.getMedialPort().equals(flightBy))
                .collect(Collectors.toList());
    }

}
