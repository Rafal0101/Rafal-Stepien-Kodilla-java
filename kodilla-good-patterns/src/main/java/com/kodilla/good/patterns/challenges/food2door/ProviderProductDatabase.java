package com.kodilla.good.patterns.challenges.food2door;

public class ProviderProductDatabase {
    private Provider provider;
    private Product product;
    private Boolean isAvailable;

    public ProviderProductDatabase(Provider provider, Product product, Boolean isAvailable) {
        this.provider = provider;
        this.product = product;
        this.isAvailable = isAvailable;
    }

    public Provider getProvider() {
        return provider;
    }

    public Product getProduct() {
        return product;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }
}
