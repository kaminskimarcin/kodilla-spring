package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        Millenials millenials = new Millenials("Millenials");

        //When
        String output = millenials.socialPublisher.share();

        //Then
        Assert.assertEquals("Twitter", output);
    }

    @Test
    public void testIndividualSharingsStrategy() {
        //Given
        YGeneration yGeneration = new YGeneration("YGeneration");

        //When
        String defaultOutput = yGeneration.socialPublisher.share();
        yGeneration.setSocialPublisher(new TwitterPublisher());
        String changedOutput = yGeneration.socialPublisher.share();

        //Then
        Assert.assertEquals("Snapchat", defaultOutput);
        Assert.assertEquals("Twitter", changedOutput);
    }
}
