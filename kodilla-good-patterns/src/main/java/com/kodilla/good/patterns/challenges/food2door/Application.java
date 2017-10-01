package com.kodilla.good.patterns.challenges.food2door;

/*
Zadanie: Wyzwanie - Food2Door

Firma “Food2Door” zajmuje się dystrybucją lokalnych i świeżych produktów z okolicznych wiosek.
Produkty można zamawiać przez internet, a następnie kurier dostarcza je do naszego domu.
W związku z jej dynamicznym rozwojem i pojawiającymi się nowymi producentami produktów,
system musi zostać rozszerzony o podsystem podłączenia producentów. Proces zamawiania produktów
od różnych producentów zawsze jest taki sam, jednakże nie istnieje żadna uwspólniona logika dla tego przypadku.

Załóżmy, że osoba o imieniu Adam odpowiadająca za opracowywanie biznesowej strony aplikacji przedstawia nam zagadnienie
 do rozwiązania w następujący sposób:

“Hej, słuchaj mamy taki problem - mamy już trzech producentów jedzenia: ExtraFoodShop, HealthyShop, GlutenFreeShop.
Na horyzoncie pojawiają się nowe firmy, które chcą dołączyć do naszego łańcucha dostaw, niestety kodowanie procesu
zamawiania dla każdego z dystrybutorów jest bardzo żmudne i do tego kod się wciąż powtarza. Wszyscy z tych producentów
różnią się nieco implementacją, jednakże schemat zamawiania przebiega następująco:

Pobieramy informacje o dostawcy, oraz ilości i rodzaju produktu,
Następnie każdy z producentów posiada metodę process(), która pozwala na zrealizowanie tego zamówienia w danym sklepie
Dalsza część również wygląda wszędzie tak samo, zwracane są informacje czy udało się zrealizować zamówienie
Masz może jakiś pomysł jak to dobrze rozwiązać?”

To zadanie jest naprawdę 'otwarte' na Twoją inwencję twórczą - spróbuj napisać rozwiązanie, które pozwoli na sprawne
'dołączanie' do istniejącego systemu wielu nowych producentów. Załóż, że całość systemu poza tym, co zostało zawarte
w powyższych punktach jest nieistotna - napisz kod odzwierciedlający tylko te wytyczne, wymyślając jednocześnie drobne
różnice w implementacji metody process() dla każdego producenta :)
*/

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
