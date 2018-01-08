package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product productOne = new Product("Product One");
        Product productTwo = new Product("Product Two");
        Product productThree = new Product("Product Three");

        Item itemOne = new Item(new BigDecimal(20), 20);
        Item itemTwo = new Item(new BigDecimal(40), 2);
        Item itemThree = new Item(new BigDecimal(50), 50);

        itemOne.setProduct(productOne);
        itemTwo.setProduct(productTwo);
        itemThree.setProduct(productThree);

        Invoice invoiceOne = new Invoice("23512341");

        Invoice invoiceTwo = new Invoice("21334124");

        invoiceOne.getItems().add(itemOne);
        invoiceOne.getItems().add(itemTwo);

        invoiceTwo.getItems().add(itemThree);

        //When
        invoiceDao.save(invoiceOne);
        invoiceDao.save(invoiceTwo);
        int id = invoiceOne.getId();
         //Then

        Assert.assertNotEquals(0, id);

        //CleanUp
        invoiceDao.deleteAll();
    }
}
