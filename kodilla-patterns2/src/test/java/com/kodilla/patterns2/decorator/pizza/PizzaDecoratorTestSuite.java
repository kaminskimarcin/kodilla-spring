package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaDecoratorTestSuite {
    @Test
    public void testBasicPizzaOrder() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        BigDecimal cost = theOrder.getCost();
        String description = theOrder.getDescription();
        //THen
        assertEquals(new BigDecimal(15), cost);
        assertEquals("You ordered basic pizza with: cheese and sauce", description);
    }

    @Test
    public void testPizzaWithHamAndBaconOrder() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamDecorator(theOrder);
        theOrder = new BaconDecorator(theOrder);
        //When
        BigDecimal cost = theOrder.getCost();
        String description = theOrder.getDescription();
        //Then
        assertEquals(new BigDecimal(19), cost);
        assertEquals("You ordered basic pizza with: cheese and sauce +ham +Bacong", description);
    }
}
