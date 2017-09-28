package com.kodilla.good.patterns.challenges.food2door;

public class ProviderProductDatabaseRetriever {
    public ProviderProductDatabase retrieve () {
        Provider provider = new Provider(1, "Unilever", "World");
        Product product = new Product(9, "Chinese soup");
        return new ProviderProductDatabase(provider, product, true);
    }
}
