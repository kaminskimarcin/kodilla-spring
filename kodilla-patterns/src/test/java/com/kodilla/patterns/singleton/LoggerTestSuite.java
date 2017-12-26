package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    @BeforeClass
    public static void log() {
        Logger.getInstance().Log("Log");
        Logger.getInstance().Log("SecondLog");
    }

    @Test
    public void shouldReturnLastLog() {
        //Given
        //When
        String output = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("SecondLog", output);
    }
}
