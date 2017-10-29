package com.kodilla.hibernate.companiesemployee.dao;

/*
Exercise 13.4
Zadanie: Wyszukujemy pracowników o podanych nazwiskach oraz firmy o nazwach zaczynających się na…

Celem zadania jest przećwiczenie named queries na przykładzie zbudowanej wcześniej encji Employee.
Aby zrealizować zadanie:

Do encji Employee dodaj nazwane zapytanie wyszukujące pracowników o podanym nazwisku (użyj parametru)
Do encji Company dodaj nazwane natywne zapytanie, wyszukujące firmy, których pierwsze trzy znaki nazwy są równe
podanemu parametrowi - poszukaj w dokumentacji MySQL jaka funkcja zwraca fragment ciągu znaków z kolumny tekstowej :)
Zmodyfikuj kontrolery repozytorium encji Employee oraz Company tak, aby udostępniały metody zwracające dane wyszukiwane
przy pomocy named queries
Dopisz nowe testy w zestawie testów CompanyDaoTestSuite, które sprawdzają działanie metod używających nazwanych zapytań.
 */

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompaniesEmployeeDaoTestSuite {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testEmployeeFindByLastName() {
        //Given
        Company company = new Company("Microsoft");
        int id = 0;

        /*
        W trakcie wykonywania tego zadania mialem takie zdarzenie, ze rekord utworzyl sie w bazie danych
        a wywalila sie funkcja wyszukujaca. Efekt byl taki, ze w bazie danych pozostal rekord.
        Czy nie powinno sie wiec zastosowac try - catch, tak jak zrobilem to w tym tescie?
        */

        try {
            companyDao.save(company);
            id = company.getId();

            //When
            List<Company> result = companyDao.retrieveCompaniesFindByPatternStartsWith("Mic%");

            //Then
            Assert.assertEquals(1, result.size());
        } finally {
            //CleanUp
            companyDao.delete(id);
        }
    }

    @Test
    public void testCompanyFindNameByPatternInName() {
        //Given
        Employee employee1 = new Employee("John", "Laskowitz");
        Employee employee2 = new Employee("Andrew", "Rambo");
        Employee employee3 = new Employee("Greg", "Laskowitz");

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        int id1 = employee1.getId();
        int id2 = employee1.getId();
        int id3 = employee1.getId();

        //When
        List<Employee> result = employeeDao.retrieveEmployeeByLastName("Laskowitz");

        //Then
        Assert.assertEquals(2, result.size());

        //CleanUp
        try {
            employeeDao.delete(id1);
            employeeDao.delete(id2);
            employeeDao.delete(id3);
        } catch (Exception e) {
        }
    }
}
