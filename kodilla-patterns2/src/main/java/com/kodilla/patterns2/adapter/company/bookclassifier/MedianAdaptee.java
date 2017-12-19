package com.kodilla.patterns2.adapter.company.bookclassifier;

import com.kodilla.patterns2.adapter.company.bookclassifier.libraryb.BookData;
import com.kodilla.patterns2.adapter.company.bookclassifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.company.bookclassifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.company.bookclassifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    @Override
    public int averagePublicationYear(Map<BookSignature, BookData> books) {
        Statistics statistics = new Statistics();
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, BookData> books) {
        Statistics statistics = new Statistics();
        return statistics.medianPublicationYear(books);
    }
}
