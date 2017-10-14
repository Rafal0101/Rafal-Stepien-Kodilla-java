package com.kodilla.patterns.prototype.library;

/*
Exercise 11.2
W katalogu src/test/java utwórz pakiet com.kodilla.patterns.prototype.library, a w nim zestaw testów LibraryTestSuite
zawierający test testGetBooks(). W teście stwórz obiekt biblioteki oraz kilka obiektów książek i dodaj je do księgozbioru.
Zmodyfikuj klasę Library tak, aby była zgodna ze wzorcem Prototype
Zmodyfikuj test testGetBooks() w taki sposób, aby prezentował działanie shallowCopy() oraz deepCopy()
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    private static Library library = null;
    private static Book book1 = null;
    private static Book book2 = null;
    private static Book book3 = null;
    private static Book book4 = null;
    private static Book book5 = null;


    @Before
    public void createTestData() {
        book1 = new Book("Sherlock Holmes1", "A. C. Doyle", LocalDate.of(1901, 10, 5));
        book2 = new Book("Sherlock Holmes2", "A. C. Doyl", LocalDate.of(1910, 11, 25));
        book3 = new Book("Sherlock Holmes3", "A. C. Doy", LocalDate.of(1902, 12, 15));
        book4 = new Book("Sherlock Holmes4", "A. C. Do", LocalDate.of(1909, 1, 6));
        book5 = new Book("Sherlock Holmes5", "A. C. D", LocalDate.of(1903, 3, 30));

        library = new Library("Library Number One.");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);
    }

    @Test
    public void testShallowClone() {
        //Given

        //When
        //shallow cloning
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Library number Two.");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        shallowClonedLibrary.getBooks().remove(book5);
        shallowClonedLibrary.getBooks().remove(book4);
        shallowClonedLibrary.getBooks().remove(book3);

        //Then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);

        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(2, shallowClonedLibrary.getBooks().size());
    }

    @Test
    public void testDeepClone() {
        //Given

        //When
        //deep cloning
        Library deepClonedLibrary= null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library number Three.");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //Then
        System.out.println(library);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(5, library.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
    }
}
