package com.kodilla.patterns2.adapter.company.bookclassifier.libraryb;

import java.util.Map;

public interface BookStatistics {
    int averagePublicationYear(Map<BookSignature, BookData> books);
    int medianPublicationYear(Map<BookSignature, BookData> books);
}
