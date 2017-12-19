package com.kodilla.patterns2.adapter.company.bookclassifier.libraryb;

public class BookData {
    private final String author;
    private final String title;
    private final int yearOfPublication;

    public BookData(final String author, final String title, final int yearOfPublication) {
        this.author = author;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
