package com.kodilla.patterns.patterns.good.patterns.challenges.allegro;

public class ProductOrderService {
    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderDatabase;

    public ProductOrderService(final InformationService informationService, final OrderService orderService, final OrderRepository orderDatabase) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderDatabase = orderDatabase;
    }

    public OrderDto process(final OrderRequest orderRequest){
        boolean isOrdered = orderService.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getOrderTime());
        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            orderDatabase.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getOrderTime());
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), false);
        }
    }
}
