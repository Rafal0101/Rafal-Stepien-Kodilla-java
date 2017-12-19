package com.kodilla.patterns2.adapter.company.bookclassifier;

/*
Exercise 20.5
Mając w ten sposób przygotowany "stan zastany" wykonaj zadanie i stwórz adapter. Aby to zrobić, zrealizuj po kolei:

W katalogu src/main/java w pakiecie com.kodilla.patterns2.adapter.bookclassifier utwórz klasę MedianAdaptee,
która implementuje interfejs BookStatistics oraz używa obiektu klasy Statistics do wykonania obliczeń
w tym samym pakiecie utwórz klasę MedianAdapter, która rozszerza klasę MedianAdaptee oraz implementuje interfejs
Classifier, a w swoim wnętrzu dokonuje niezbędnych transformacji danych i wywołań
W katalogu src/test/java utwórz pakiet com.kodilla.patterns2.adapter.bookclassifier
W pakiecie z pkt 3 powyżej utwórz zestaw testów MedianAdapterTestSuite, a w nim przypadek testowy
publicationYearMedianTest, w którym stwórz przykładowy zbiór Set<Book> i wywołaj metodę publicationYearMedian()
klasy MedianAdapter. Napisz asercję sprawdzającą czy wynik testu jest zgodny z oczekiwaniami.
 */

import com.kodilla.patterns2.adapter.company.bookclassifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("Author1", "Title1", 2000, "ABC"));
        books.add(new Book("Author2", "Title2", 2002, "ABD"));
        books.add(new Book("Author3", "Title3", 2004, "ABE"));
        books.add(new Book("Author4", "Title4", 2006, "ABF"));
        books.add(new Book("Author5", "Title5", 2008, "ABG"));
        books.add(new Book("Author6", "Title6", 2010, "ABH"));
        books.add(new Book("Author7", "Title7", 2012, "ABI"));

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int medianYears = medianAdapter.publicationYearMedian(books);

        //Then
        Assert.assertEquals(2006, medianYears, 0);
    }
}
