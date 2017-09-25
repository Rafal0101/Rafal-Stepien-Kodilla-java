package com.kodilla.exception.test;

/*
* Zadanie: Wiedza o wyjątkach
Zdanie sprawdzi całą Twoją wiedzę o wyjątkach! Zaczynamy!

Wszystkie klasy twórz wewnątrz pakietucom.kodilla.exception.test

Stwórz swój własny Exception o nazwie RouteNotFoundException.
Stwórz klasę Flight zawierającą konstruktor, pole: String departureAirport, String arrivalAirport i getter’y.
Stwórz klasę zawierającą logikę imitującą wyszukiwanie lotów: a) metoda findFilght(Flight flight) b) wewnątrz metody zaimplementuj mapę typu HashMap, której kluczem będzie String przechowujący nazwę lotniska, a wartością Boolean informujący o tym czy można na dane lotnisko polecieć. Przykład: Map<String, Boolean>. c) logika powinna wyszukiwać loty w mapie. Jeżeli dane lotnisko nie będzie istnieć w mapie, należy rzucić wyjątkiem RouteNotFoundException.
Program należy uruchomić wewnątrz metody main, a następnie obsłużyć możliwe pojawienie się wyjątku.
*/

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class RouteExceptionRunner {
    private static Map<String, Boolean> findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> availableAirports = new HashMap<>();

        availableAirports.put("New York", false);
        availableAirports.put("London", true);
        availableAirports.put("Warsaw", true);

        if (!(availableAirports.containsKey(flight.getDepartureAirport())
                || (availableAirports.containsKey(flight.getArrivalAirport())))) {
            throw new RouteNotFoundException("Flight doesn't exist");
        }
        return availableAirports;
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
