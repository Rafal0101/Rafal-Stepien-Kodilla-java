package com.kodilla.patterns.patterns.good.patterns.challenges.food2door;

public class ShopComingSoon implements Shop {
    @Override
    public void process(ProviderProductDatabase providerProductDatabase) {
        System.out.println("Our new shop will introduce new dimension of shopping!");
        System.out.println("Coming soon...");
    }
}
