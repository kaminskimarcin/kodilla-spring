package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseSearcherFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseSearcherFacade.class);

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private CompanyDao companyDao;

    public List<Employee> processEmployeeSearch(final String characters) throws DatabaseSearcherException {
        boolean wasError = false;
        List<Employee> foundEmployeesList;
        String wordToFind = "%" + characters + "%";
        try {
            LOGGER.info("Searching employee by phrase: " + characters);
            foundEmployeesList = employeeDao.findEmployeeByChars(wordToFind);
            if (foundEmployeesList.size() == 0) {
                wasError = true;
                LOGGER.error(DatabaseSearcherException.ERR_NO_EMPLOYEE_FOUND);
                throw new DatabaseSearcherException(DatabaseSearcherException.ERR_NO_EMPLOYEE_FOUND);
            }else {
                foundEmployeesList.forEach(employee -> LOGGER.info("Employee : " + employee));
                return foundEmployeesList;
            }
        } finally {
            if (wasError) {
                LOGGER.error(DatabaseSearcherException.ERR_SEARCH_FINISHED);
            }else {
                LOGGER.info(DatabaseSearcherException.INFO_SEARCH_FINISHED);
            }
        }
    }



    public List<Company> processCompanySearch(final String characters) throws DatabaseSearcherException {
        boolean wasError = false;
        List<Company> foundCompaniesList;
        String wordToFind = "%" + characters + "%";
        try {
            LOGGER.info("Searching company by phrase: " + characters);
            foundCompaniesList = companyDao.findCompanyByChars(wordToFind);
            if (foundCompaniesList.size() == 0) {
                wasError = true;
                LOGGER.error(DatabaseSearcherException.ERR_NO_COMPANY_FOUND);
                throw new DatabaseSearcherException(DatabaseSearcherException.ERR_NO_COMPANY_FOUND);
            }else {
                foundCompaniesList.forEach(company -> LOGGER.info("Company name: " + company));
                return foundCompaniesList;
            }
        } finally {
            if (wasError) {
                LOGGER.error(DatabaseSearcherException.ERR_SEARCH_FINISHED);
            }else {
                LOGGER.info(DatabaseSearcherException.INFO_SEARCH_FINISHED);
            }
        }
    }
}