package com.kodilla.patterns2.adapter.company.bookclassifier;

import com.kodilla.patterns2.adapter.company.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.company.bookclassifier.librarya.Clasifier;
import com.kodilla.patterns2.adapter.company.bookclassifier.libraryb.BookData;
import com.kodilla.patterns2.adapter.company.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Clasifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, BookData> books = new HashMap<>();

        for (Book book : bookSet
                ) {
            books.put(new BookSignature(book.getSignature()), new BookData(book.getAuthor(), book.getTitle(), book.getPublicationYear()));
        }
        return medianPublicationYear(books);
    }
}
