package com.kodilla.good.patterns.challenges.allegro;
/*
Wewnątrz pakietu com.kodilla.good.patterns.challenges stwórz klasę ProductOrderService.
Serwis powinien zajmować się wykonywaniem zamówień różnego rodzaju produktów - gier, kapcie, szczoteczek do zębów…
innymi słowy, Allegro :)
*/

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrive();

        ProductOrderService productOrderService = new ProductOrderService(
                new InformationServiceViaSms(), new OrderServiceProduct(), new OrderRepositoryDatabase());
        productOrderService.process(orderRequest);
    }
}
