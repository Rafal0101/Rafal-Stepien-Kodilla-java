package com.kodilla.patterns.patterns.good.patterns.challenges.flight;

/*
Zadanie: Wyzwanie - loty

Mamy do czynienia z bardzo małą firmą lotniczą, która oferuje prywatne loty. Do tej pory, wszystko było uzgadniane przez
telefon bezpośrednio z klientem, jednak zarząd firmy stwierdził, że jest to bardzo niewydajne rozwiązanie, ponieważ wiele
razy muszą powtarzać to samo, a klienci mają problemy z dodzwonieniem się do firmy ze względu na ograniczoną ilość konsultantów.

Uznano, że dobrze byłoby stworzyć system, który posiadałby zapisaną listę wszystkich lotów, np. GDAŃSK -> WROCŁAW.

System mimo samego przetrzymywania lotów powinien zawierać serwis, który pozwoliłby nam operację związane z wyszukiwaniem lotów jak:

Znalezienie wszystkich lotów z podanego miasta
Znalezienie wszystkich lotów do danego miasta
Znalezienie lotów poprzez inne miasto np. lot z Gdańska przez Kraków do Wrocławia
Firma zna się na technologiach i wymaga użycia iteracji za pomocą Stream oraz spodziewa się wykorzystania kontraktu Equals i Hashcode.

Czy dasz radę rozwiązać problem tej firmy lotniczej?
*/

import java.util.List;

public class Application {
    public static void main(String[] args) {
        FlightDatabase flightDatabase = new FlightDatabase();
        List<Flight> flights = flightDatabase.createSampleData();

        List<Flight> resultList;

        resultList = FlightSearcher.findFlightsFrom("Wroclaw", flights);
        for (Flight flight : resultList
                ) {
            System.out.println(flight);
        }

        resultList = FlightSearcher.findFlightsTo("Wroclaw", flights);
        for (Flight flight : resultList
                ) {
            System.out.println(flight);
        }

        resultList = FlightSearcher.findFlightsBy("Krakow", flights);
        for (Flight flight : resultList
                ) {
            System.out.println(flight);
        }
    }
}
