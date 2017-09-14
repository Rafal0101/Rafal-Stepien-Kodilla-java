package com.kodilla.stream.immutable;
/*
* Zadanie: Niemutowalny użytkownik forum

Zadanie polega na stworzeniu niemutowalnej klasy reprezentującej użytkownika forum. Aby zrealizować zadanie wykonaj:

Utwórz w pakiecie com.kodilla.stream.immutable klasę ForumUser, zawierającą pola String username, String realName oraz konstruktor i gettery
Spraw, aby utworzona klasa była niemutowalna poprzez odpowiednie użycie słowa kluczowego final
Upewnij się, że wszystkie pola klasy są oznaczone jako private
*/

public final class ForumUser {
    private final String userName;
    private final String realName;

    public ForumUser(final String userName, final String realName) {
        this.userName = userName;
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public String getRealName() {
        return realName;
    }
}
