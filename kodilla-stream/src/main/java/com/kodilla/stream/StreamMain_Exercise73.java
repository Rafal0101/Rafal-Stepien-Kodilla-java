package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.forumuser.Sex;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

/*
Tresc zadania:

Twoim zadaniem jest stworzenie kolekcji składającej się z obiektów opisujących użytkowników forum. Następnie, przy pomocy Stream powinieneś przekształcić tę kolekcję w mapę zawierającą tych użytkowników forum, którzy mają nie mniej niż 20 lat, są mężczyznami i mają co najmniej jeden opublikowany post.

Aby zrealizować zadanie wykonaj:
Stwórz w katalogu src/main/java pakiet com.kodilla.stream.forumuser, a w nim klasę ForumUser
Klasa ForumUser powinna mieć następujące pola (użyj odpowiednich nazw angielskich):
unikalny identyfikator użytkownika (typu int)
nazwa użytkownika (typu String)
płeć (typu char), z wartościami ‘M’/’F’
data urodzenia (typu LocalDate)
ilość opublikowanych postów (typu int)
W tym samym pakiecie napisz klasę Forum, która będzie zawierała listę użytkowników, czyli listę obiektów ForumUser.
Klasa Forum powinna udostępniać metodę getUserList(), która będzie zwracała kolekcję z użytkownika forum
W metodzie main(String[] args) klasy StreamMain napisz program, który:
zainicjuje strumień Stream przy pomocy metody stream() kolekcji
odfiltruje tylko tych użytkowników, którzy są mężczyznami
odfiltruje tylko tych użytkowników, którzy mają co najmniej 20 lat
odfiltruje tylko tych użytkowników, którzy mają co najmniej jeden opublikowany post
przy pomocy kolektora utworzy mapę par, w której rolę klucza będzie pełnił unikalny identyfikator użytkownika
wyświetli otrzymaną mapę wynikową
Napisany program prześlij do repozytorium GitHub.
*/
public class StreamMain_Exercise73 {
    public static void main(String[] args) {
        Forum dataForum = new Forum();
        final int limitAge = 20;

        Map<Integer, ForumUser> theResultMapOfForumUsers = dataForum.getList().stream()
                .filter(forumUser -> forumUser.getSex() == Sex.M)
                .filter(forumUser -> forumUser.getBirthDate().plusYears(limitAge).isBefore(LocalDate.now()))
                .filter(forumUser -> forumUser.getPostsQuantity() > 0)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        theResultMapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}
