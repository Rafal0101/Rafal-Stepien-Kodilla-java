package com.kodilla.exception.test;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class RouteExceptionRunner {
    private static void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> availableAirports = new HashMap<>();

        availableAirports.put("New York", false);
        availableAirports.put("London", true);
        availableAirports.put("Warsaw", true);

        if (!(availableAirports.containsKey(flight.getDepartureAirport())
                || (availableAirports.containsKey(flight.getArrivalAirport())))) {
            throw new RouteNotFoundException("Flight doesn't exist");
        }
    }

    public static void main(String[] args) {
        Flight flight = new Flight("Roma", "Sydney");
        try {
            findFlight(flight);
            System.out.println("OK, This flight is available.");
        } catch (RouteNotFoundException e) {
            System.out.println("This flight is unavailable." + e);
        } finally {
            System.out.println("Time of operation " + LocalTime.now());
        }
    }
}
