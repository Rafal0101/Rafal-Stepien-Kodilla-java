package com.kodilla.patterns2.observer.forum.homework;

/*
Exercise 20.4
Zadanie: Kolejki z zadaniami do sprawdzenia
Celem zadania jest zbudowanie mechanizmu kolejek z zadaniami kursantów do sprawdzenia.

Ma to funkcjonować podobnie jak zadania w Kodilli, które przesyłasz do mentora. Przesłane zadania trafiają do kolejki.
Każdy kursant ma swoją kolejkę. Poszczególni mentorzy będą zasubskrybowani na powiadomienia o nowych zadaniach
w kolejkach tych kursantów, z którymi współpracują, czyli - innymi słowy - będą obserwatorami tych kolejek.

W tym celu:

Utwórz pakiet com.kodilla.patterns2.observer.homework zarówno w katalogu src/main/java, jak i w katalogu src/test/java.
Następnie trzeba stworzyć klasę reprezentującą kolejkę zadań kursanta implementującą interfejs utworzony według zasad
właściwych dla Observable, W kolejnym kroku utwórz klasę reprezentującą mentora, implementującą interfejs stworzony
według zasad właściwych dla Observer. Stwórz test, a w nim utwórz kilka kolejek zadań kursantów oraz dwóch mentorów.
Zasubskrybuj mentorów na powiadomienia o nowych zadaniach w kolejce. Test powinien sprawdzać czy całość działa poprawnie.
*/

import org.junit.Test;
import static org.junit.Assert.*;

public class HomeworkTestSuite {
    @Test
    public void testHomeworkUpdate() {
        //Given
        Mentor john = new Mentor("John");
        Mentor cris = new Mentor("Cris");

        StudentTaskQueue studentAnna = new StudentTaskQueue("Anna");
        StudentTaskQueue studentMargaret = new StudentTaskQueue("Margaret");
        StudentTaskQueue studentLaura = new StudentTaskQueue("Laura");

        studentAnna.registerObserver(john);
        studentMargaret.registerObserver(john);
        studentLaura.registerObserver(cris);

        //When
        studentAnna.addTask("patterns 1");
        studentAnna.addTask("patterns 2");
        studentAnna.addTask("rest 1");
        studentMargaret.addTask("patterns 2");
        studentMargaret.addTask("rest 1");
        studentMargaret.addTask("rest 2");
        studentLaura.addTask("rest 3");

        //Then
        assertEquals(6, john.getUpdateCount());
        assertEquals(1, cris.getUpdateCount());
    }
}
