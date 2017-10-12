package com.kodilla.patterns.patterns.good.patterns.challenges.allegro;

import java.time.LocalDate;

public class OrderRequestRetriever {
    public OrderRequest retrive() {
        User user = new User("Kelly");
        Product product = new Product("Bike", 850.40);
        LocalDate date = LocalDate.now();

        return new OrderRequest(user, product, date);
    }
}
