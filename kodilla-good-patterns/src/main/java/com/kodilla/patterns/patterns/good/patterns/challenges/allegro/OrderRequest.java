package com.kodilla.patterns.patterns.good.patterns.challenges.allegro;

import java.time.LocalDate;

public class OrderRequest {
    private User user;
    private Product product;
    private LocalDate orderTime;

    public OrderRequest(User user, Product product, LocalDate orderTime) {
        this.user = user;
        this.product = product;
        this.orderTime = orderTime;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDate getOrderTime() {
        return orderTime;
    }
}
