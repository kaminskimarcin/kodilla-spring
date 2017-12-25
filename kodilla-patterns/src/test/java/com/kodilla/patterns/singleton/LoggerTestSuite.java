package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    @BeforeClass
    public static void log() {
        Logger.getInstance().Log("Test");
    }

    @Test
    public void shouldReturnLastLog() {
        //Given
        //When
        String output = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("Test", output);
    }
}
