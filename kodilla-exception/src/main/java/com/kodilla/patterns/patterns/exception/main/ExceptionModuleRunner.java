package com.kodilla.patterns.patterns.exception.main;

import com.kodilla.patterns.patterns.exception.io.FileReader;
import com.kodilla.patterns.patterns.exception.io.FileReaderException;

public class ExceptionModuleRunner {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        try {
            fileReader.readFile();
        } catch (FileReaderException e) {
            System.out.println("Problem " + e);
        }
    }
}
