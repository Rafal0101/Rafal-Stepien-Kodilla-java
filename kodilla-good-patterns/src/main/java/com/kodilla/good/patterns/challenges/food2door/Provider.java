package com.kodilla.good.patterns.challenges.food2door;

public final class Provider {
    private final Integer id;
    private final String name;
    private final String address;

    public Provider(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
