package com.kodilla.patterns.patterns.testing.library;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class BookDirectoryTestSuite {
    // Exercise 6.6 my tests
    private static LibraryDatabase libraryDatabaseMock;
    private static BookLibrary bookLibrary;

    @Before
    public void initializeObjects() {
        //Given
        libraryDatabaseMock = mock(LibraryDatabase.class);
        bookLibrary = new BookLibrary(libraryDatabaseMock);
    }

    @Test
    public void testListBookInHandsOf0Books() {
        // next 2 lines are example answer from LibraryDatabase interface
        List<Book> resultListOfBooks = new ArrayList<>();
        LibraryUser libraryUser = new LibraryUser("John", "Rambo", "123456789");

        //When
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks);
        List<Book> theListOfBook = bookLibrary.listBooksInHandsOf(libraryUser);

        //Than
        assertEquals(0, theListOfBook.size());
    }

    @Test
    public void testListBookInHandsOf1Books() {
       // next 3 lines are example answer from LibraryDatabase interface
        List<Book> resultListOfBooks = new ArrayList<>();
        resultListOfBooks.add(new Book("Secrets of Alamo", "John Smith", 2008));
        LibraryUser libraryUser = new LibraryUser("John", "Rambo", "123456789");

        //When
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks);
        List<Book> theListOfBook = bookLibrary.listBooksInHandsOf(libraryUser);

        //Than
        assertEquals(1, theListOfBook.size());
    }

    @Test
    public void testListBookInHandsOf5Books() {
        // next 7 lines are example answer from LibraryDatabase interface
        List<Book> resultListOfBooks = new ArrayList<>();
        resultListOfBooks.add(new Book("Secrets of Alamo", "John Smith", 2008));
        resultListOfBooks.add(new Book("Secrets of Alam", "John Smit", 2009));
        resultListOfBooks.add(new Book("Secrets of Ala", "John Smi", 2010));
        resultListOfBooks.add(new Book("Secrets of Al", "John Sm", 2011));
        resultListOfBooks.add(new Book("Secrets of A", "John S", 2012));
        LibraryUser libraryUser = new LibraryUser("John", "Rambo", "123456789");

        //When
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfBooks);
        List<Book> theListOfBook = bookLibrary.listBooksInHandsOf(libraryUser);

        //Than
        assertEquals(5, theListOfBook.size());
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);

        // When
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);

        // When
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FourtyBooks"))
                .thenReturn(resultListOf40Books);

        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FourtyBooks");

        // Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        List<Book> resultListOf10Books = generateListOfNBooks(10);

        // When
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
}
