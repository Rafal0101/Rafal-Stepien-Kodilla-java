package com.kodilla.patterns.patterns.good.patterns.challenges.allegro;

public final class User {
    private final String name;

    public User(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
