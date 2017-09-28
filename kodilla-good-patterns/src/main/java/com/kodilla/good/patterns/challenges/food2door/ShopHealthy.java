package com.kodilla.good.patterns.challenges.food2door;

public class ShopHealthy implements Shop {
    @Override
    public void process(ProviderProductDatabase providerProductDatabase) {
        System.out.println("SHOP HEALTHY REALLY, CARES OF YOUR HEALTH!!!");
        if (providerProductDatabase.getAvailable()) {
            System.out.println("We have " + providerProductDatabase.getProduct().getName() + " of "
                    + providerProductDatabase.getProvider().getName() + " for our VIP in price of 70 USD!\n");
        } else {
            System.out.println("but sorry we haven't " + providerProductDatabase.getProduct().getName());
        }
    }
}
