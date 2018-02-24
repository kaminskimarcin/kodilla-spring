package com.kodilla.hibernate.manytomany.facade;

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
public class DatabaseSearcherFacadeTestSuite {

    @Autowired
    private DatabaseSearcherFacade databaseSearcherFacade;
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;


    @Test
    public void processEmployeeSearchTest() throws DatabaseSearcherException {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        //When
        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephaniaClarcksonID = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int lindaKovalskyId = lindaKovalsky.getId();

        String characters = "smi";
        List<Employee> foundEmployeeList = databaseSearcherFacade.processEmployeeSearch(characters);

        //Then
        Assert.assertEquals(1, foundEmployeeList.size());

        //CleanUp
        try {
            employeeDao.delete(johnSmithId);
            companyDao.delete(stephaniaClarcksonID);
            companyDao.delete(lindaKovalskyId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void processCompanySearchTest() throws DatabaseSearcherException {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        String characters = "soft";
        List<Company> foundCompanyList = databaseSearcherFacade.processCompanySearch(characters);

        //Then
        Assert.assertEquals(1, foundCompanyList.size());

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
}