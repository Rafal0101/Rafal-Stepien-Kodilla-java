package com.kodilla.patterns.patterns.good.patterns.challenges.allegro;

import java.time.LocalDate;

public class OrderServiceProduct implements OrderService {
    @Override
    public boolean createOrder(User user, Product product, LocalDate date) {
        System.out.println("Order of " + product + " was created for user: " + user + " on " + date);
        return true;
    }
}
