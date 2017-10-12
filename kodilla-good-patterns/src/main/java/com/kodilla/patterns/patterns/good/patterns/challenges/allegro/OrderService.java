package com.kodilla.patterns.patterns.good.patterns.challenges.allegro;

import java.time.LocalDate;

public interface OrderService {
    boolean createOrder(User user, Product product, LocalDate date);
}
