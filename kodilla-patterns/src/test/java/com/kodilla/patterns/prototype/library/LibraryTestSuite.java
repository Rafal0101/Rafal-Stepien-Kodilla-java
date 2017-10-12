package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Book book1 = new Book("Sherlock Holmes1", "A. C. Doyle", LocalDate.of(1901, 10, 5));
        Book book2 = new Book("Sherlock Holmes2", "A. C. Doyl", LocalDate.of(1910, 11, 25));
        Book book3 = new Book("Sherlock Holmes3", "A. C. Doy", LocalDate.of(1902, 12, 15));
        Book book4 = new Book("Sherlock Holmes4", "A. C. Do", LocalDate.of(1909, 1, 6));
        Book book5 = new Book("Sherlock Holmes5", "A. C. D", LocalDate.of(1903, 3, 30));

        Library library = new Library("Library Number One.");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        //shallow cloning
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Library number Two.");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //deep cloning
        Library deepClonedLibrary= null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library number Three.");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        shallowClonedLibrary.getBooks().remove(book5);
        shallowClonedLibrary.getBooks().remove(book4);
        shallowClonedLibrary.getBooks().remove(book3);

        //Then
        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(2, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
    }
}
