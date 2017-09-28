package com.kodilla.good.patterns.challenges.food2door;

public class Application {
    public static void main(String[] args) {
        ProviderProductDatabaseRetriever providerProductRequestRetriever = new ProviderProductDatabaseRetriever();
        ProviderProductDatabase providerProductRequest = providerProductRequestRetriever.retrieve();

        Shop extraFood = new ShopExtraFood();
        extraFood.process(providerProductRequest);

        Shop glutenFree = new ShopGlutenFree();
        glutenFree.process(providerProductRequest);

        Shop healthy = new ShopHealthy();
        healthy.process(providerProductRequest);

        Shop comingSoon = new ShopComingSoon();
        comingSoon.process(providerProductRequest);

    }
}
