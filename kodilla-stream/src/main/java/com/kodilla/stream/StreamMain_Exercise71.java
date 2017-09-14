package com.kodilla.stream;
import com.kodilla.stream.beautifier.PoemBeautifier;
/*
* Zadanie: Upiększacz tekstów

Przygotowanie:

utwórz pakiet com.kodilla.stream.beautifier w katalogu src/main/java.
W tym pakiecie stwórz interfejs PoemDecorator, zawierający metodę decorate odpowiedzialną za ozdobienie tekstu przekazanego jako parametr.
Stwórz klasę PoemBeautifier, która będzie posiadała metodę beautify, której jako parametry będzie można przekazać tekst do upiększenia oraz wyrażenie lambda upiększające tekst.
Wykonanie zadania:

W metodzie main(String[] args) klasy StreamMain, utwórz obiekt klasy PoemBeautifier i wywołaj kilka razy metodę beautify z różnymi tekstami i różnymi upiększaczami tekstu (wyrażenia lambda).
Przykładowymi upiększaczami tekstu mogą być na przykład kody dopisujące znaki “ABC” na początku i na końcu otrzymanego tekstu lub kody zmieniające cały otrzymany tekst na duże litery (skorzystaj z metody toUpperCase() klasy String).
Wymyśl również dwa własne upiększacze.
Kod zadania prześlij do Github.
* */

public class StreamMain_Exercise71 {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("my ugly text.", (text) -> text.toUpperCase());
        poemBeautifier.beautify("my ugly text", (text) -> text.concat(" now looks better!"));
        poemBeautifier.beautify("my ugly text", (text) -> text.replaceAll("ugly", "BEAUTIFUL").concat(" is really great!"));

    }
}
