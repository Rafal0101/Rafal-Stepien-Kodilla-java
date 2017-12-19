package com.kodilla.hibernate.manytomany.facade;

/*
Exercise 20.1

Zadanie: Budujemy fasadę do odczytu i zapisu list zadań

Przypomnij sobie zadanie z modułu 13.4 - wyszukiwanie pracowników oraz firm o podanych nazwach.
Celem zadania jest stworzenie Fasady pozwalającej na wyszukiwanie dowolnego pracownika w bazie danych oraz dowolnej
firmy (przy pomocy fragmentu nazwy).
W celu realizacji zadania:
Stwórz w projekcie kodilla-course, w module kodilla-hibernate, w katalogu src/main/java pakiet
com.kodilla.hibernate.manytomany.facade (taki sam pakiet stwórz w katalogu src/test/java).
Napisz Fasadę (będącą beanem) umożliwiającą:
wyszukanie firmy po dowolnym fragmencie nazwy (wskazówka - użyj nazwanego zapytania z wykorzystaniem frazy field
LIKE :ARG, gdzie za field należy wstawić nazwę pola z tabeli, natomiast do :ARG należy wstawić fragment nazwy otoczony
z obu stron znakami "%" (co zastępuje dowolny ciąg znaków)
wyszukanie pracownika po dowolnym fragmencie nazwy (wskazówka - użyj nazwanego zapytania z wykorzystaniem frazy field
LIKE :ARG, gdzie za field należy wstawić nazwę pola z tabeli, natomiast do :ARG należy wstawić fragment nazwiska otoczony
z obu stron znakami "%" (co zastępuje dowolny ciąg znaków)
Napisz testy sprawdzające wyszukiwanie pracowników oraz firm po fragmencie nazwy. Użyj automatycznego wiązania i
wstrzykiwania beanów do kodu testu.
*/

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeTestSuite {
    @Autowired
    private Facade facade;

    @Test
    public void searchingCompaniesAndEmployeesByPatternTest() throws FacadeProcessingException {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Kovalkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMasters.getEmployees().add(stephanieClarckson);
        dataMasters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(dataMasters);
        lindaKovalsky.getCompanies().add(greyMatter);

        facade.saveCompany(softwareMachine);
        facade.saveCompany(dataMasters);
        facade.saveCompany(greyMatter);

        //When
        List<Company> companiesResult = facade.findCompaniesByPattern("Mabb");
        List<Employee> employeesResult = facade.findEmployeesByPattern("Kovbb");

        //Then
        assertEquals(3, companiesResult.size());
        assertEquals(2, employeesResult.size());


        //CleanUp
        try {
            facade.deleteCompany(softwareMachine);
            facade.deleteCompany(dataMasters);
            facade.deleteCompany(greyMatter);
        } catch (Exception e) {
            //do nothing
        }

    }

}