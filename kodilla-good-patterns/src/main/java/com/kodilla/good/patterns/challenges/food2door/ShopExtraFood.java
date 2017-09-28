package com.kodilla.good.patterns.challenges.food2door;

public class ShopExtraFood implements Shop {
    @Override
    public void process(ProviderProductDatabase providerProductDatabase) {
        System.out.println("SHOP EXTRA FOOD IS CHEAPEST!!!");
        if (providerProductDatabase.getAvailable()) {
            System.out.println("Only we have " + providerProductDatabase.getProduct().getName() + " of " +
                    providerProductDatabase.getProvider().getName() + " in special price of 10 USD!\n");
        } else {
            System.out.println("but sorry we haven't " + providerProductDatabase.getProduct().getName());
        }
    }
}
