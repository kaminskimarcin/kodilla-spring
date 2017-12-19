package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        double a = 5;
        double b = 2;

        //When
        double addScore = calculator.add(a, b);
        double subScore = calculator.sub(a, b);
        double mulScore = calculator.mul(a, b);
        double divScore = calculator.div(a, b);

        //Then
        Assert.assertEquals(7, addScore, 0);
        Assert.assertEquals(3, subScore, 0);
        Assert.assertEquals(10, mulScore, 0);
        Assert.assertEquals(2.5, divScore, 0);


    }
}
