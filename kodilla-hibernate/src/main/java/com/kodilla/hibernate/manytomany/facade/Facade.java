package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Facade {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> findCompaniesByPattern(final String pattern) {
        List<Company> companiesResult = companyDao.retrieveCompaniesFindByPattern("%" + pattern + "%");
        return companiesResult;
    }

    public List<Employee> findEmployeesByPattern(final String pattern) {
        List<Employee> employeesResult = employeeDao.retrieveEmployeesFindByPattern("%" + pattern + "%");
        return employeesResult;
    }

    public void deleteCompany(Company company) {
        companyDao.delete(company);
    }

    public void saveCompany(Company company) {
        companyDao.save(company);
    }

}
