package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.facade.Order;
import com.kodilla.patterns2.facade.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class OrderFacade {
    @Autowired
    private ShopService shopService;

    public static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);

    public void processOrder(final OrderDto orderDto, final Long userId) throws OrderProcessingException {
        boolean wasError = false;
        long orderId = shopService.openOrder(userId);
        LOGGER.info("Registering new order, ID: " + orderId);
        if (orderId < 0) {
            LOGGER.error(OrderProcessingException.ERR_NOT_AUTHORIZED);
            wasError = true;
            throw new OrderProcessingException(OrderProcessingException.ERR_NOT_AUTHORIZED);
        }
        try {
            for (ItemDto itemDto : orderDto.getItems()
                 ) {
                LOGGER.info("Adding item: " + itemDto.getProductId() + ", " +
                itemDto.getQuantity() + "pcs");
                shopService.addItem(orderId, itemDto.getProductId(), itemDto.getQuantity());
            }
            BigDecimal value = shopService.calculateValue(orderId);
            LOGGER.info("Order value is: " + value);

            if (!shopService.doPayment(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_PAYMENT_REJECTED);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);
            }
            LOGGER.info("Payment was done.");
            if (!shopService.verifyOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_VERIFICATION);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_VERIFICATION);
            }
            LOGGER.info("Order is verified & ready to submit.");
            if (!shopService.submitOrder(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_SUBMITTING);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_SUBMITTING);
            }
            LOGGER.info("Order " + orderId + " is submitted.");
        } finally {
            if (wasError) {
                LOGGER.info("Cancelling order " + orderId);
                shopService.cancelOrder(orderId);
            }
        }
    }
}
