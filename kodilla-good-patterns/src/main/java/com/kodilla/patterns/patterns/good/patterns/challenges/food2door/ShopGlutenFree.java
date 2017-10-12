package com.kodilla.patterns.patterns.good.patterns.challenges.food2door;

public class ShopGlutenFree implements Shop {
    @Override
    public void process(ProviderProductDatabase providerProductDatabase) {
        System.out.println("SHOP GLUTEN FREE IS GOOD CHOICE!!!");
        if (providerProductDatabase.getAvailable()) {
            System.out.println("We have gluten free " + providerProductDatabase.getProduct().getName() + " of "
                    + providerProductDatabase.getProvider().getName() + " in price of 20 USD!\n");
        } else {
            System.out.println("but sorry we haven't " + providerProductDatabase.getProduct().getName());
        }
    }
}
