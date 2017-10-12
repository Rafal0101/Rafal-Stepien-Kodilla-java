package com.kodilla.patterns.patterns.good.patterns.challenges.allegro;

public class InformationServiceViaSms implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("User: " + user + " confirmation of order possibility via SMS.");
    }
}
