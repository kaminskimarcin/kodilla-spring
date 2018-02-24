package com.kodilla.hibernate.manytomany.facade;

public class DatabaseSearcherException extends Exception {

    public static String ERR_NO_EMPLOYEE_FOUND = "No employee match the searched parameters";
    public static String ERR_NO_COMPANY_FOUND = "No company match the searched parameters";
    public static String ERR_SEARCH_FINISHED = "Searching process was finished unsuccessful";
    public static String INFO_SEARCH_FINISHED = "Searching process was completed";

    public DatabaseSearcherException(String message) {
        super(message);
    }
}