package com.kodilla.hibernate.manytomany.facade;

public class FacadeProcessingException extends Exception {
    public static String ERR_EMPLOYEE_NOT_FOUND = "Employee wasn't found.";
    public static String ERR_COMPANY_NOT_FOUND = "Company wasn't found.";

    public FacadeProcessingException(String message) {
        super(message);
    }
}
