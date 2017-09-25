package com.kodilla.exception.test;
/*
* Zadanie: Obsługa wyjątku
Stwórz wewnątrz modułu kodilla-exception pakiet o nazwie test, a następnie utwórz klasę SecondChallenge:

package com.kodilla.exception.test;

public class SecondChallenge {
   public String probablyIWillThrowException(double x, double y) throws Exception {
       if(x >= 2 || x < 1 || y == 1.5) {
           throw new Exception();
       }
       return "Done!";
   }
}
Następnie w tym samym pakiecie utwórz klasę ExceptionHandling, w której obsłużysz błąd zgodnie z dobrymi praktykami wykorzystując blok try-catch-finally. Stworzony kod prześlij do repozytorium Github.
* */

import java.time.LocalDate;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1, 1.5));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            System.out.println("Operation executed on " + LocalDate.now());
        }
    }
}
