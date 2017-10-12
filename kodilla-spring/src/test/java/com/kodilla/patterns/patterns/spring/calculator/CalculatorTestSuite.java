package com.kodilla.patterns.patterns.spring.calculator;

/*
Zadanie: Kalkulator z wyświetlaczem
Celem zadania jest napisanie klasy reprezentującej kalkulator. Kalkulator będzie wykonywał 4 podstawowe działania.
Do prezentowania wyników będzie używał osobnej klasy reprezentującej wyświetlacz. Aby zrealizować zadanie:

W katalogu src/main/java utwórz pakiet com.kodilla.spring.calculator, a w nim klasę Display, która powinna być komponentem Springa.
Klasa Display powinna mieć metodę displayValue(double val), która otrzymaną wartość wyświetla na ekranie konsoli
W tym samym pakiecie utwórz klasę Calculator, która będzie komponentem Springa i będzie posiadała pole Display display.
Użyj wstrzykiwania przez właściwość klasy do powiązania obiektów klas Calculator oraz Display ze sobą.
Zaimplementuj cztery podstawowe działania matematyczne (zrób metody add(double a, double b), sub(double a, double b),
mul(double a, double b) oraz div(double a, double b)) - obsługujące odpowiednio dodawanie, odejmowanie, mnożenie i dzielenie.
Każda metoda powinna przed zwróceniem wyniku wywołać metodę displayValue(double val) obiektu display.
W katalogu src/test/java stwórz pakiet com.kodilla.spring.calculator, a w nim zestaw testów CalculatorTestSuite.
Napisz test testCalculations(), który przetestuje poprawność działania czterech metod wykonujących obliczenia.
 */

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double sumResult = calculator.add(12, 6);
        double subResult = calculator.sub(18, 6);
        double mulResult = calculator.mul(2, 12);
        double divResult = calculator.div(15, 6);

        //Then
        Assert.assertEquals(sumResult, 18, 0.01);
        Assert.assertEquals(subResult, 12, 0.01);
        Assert.assertEquals(mulResult, 24, 0.01);
        Assert.assertEquals(divResult, 2.5, 0.01);

    }
}
