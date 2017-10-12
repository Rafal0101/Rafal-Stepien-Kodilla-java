package com.kodilla.patterns.patterns.spring.library;

import org.springframework.stereotype.Repository;

@Repository
public final class LibraryDbController {
    public void saveData() {
        System.out.println("Save data");
    }

    public void loadData() {
        System.out.println("Load data");
    }
}
