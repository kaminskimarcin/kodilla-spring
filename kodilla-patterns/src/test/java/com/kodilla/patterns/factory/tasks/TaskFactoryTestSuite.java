package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        PaintingTask paintingTask = (PaintingTask) factory.makeTask(TaskFactory.PAINTINGTASK);
        paintingTask.executeTask();
        paintingTask.setTaskName("Paint");
        //Then
        Assert.assertEquals(true, paintingTask.isTaskExecuted());
        Assert.assertEquals("Paint", paintingTask.getTaskName());
    }

    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        ShoppingTask shoppingTask = (ShoppingTask) factory.makeTask(TaskFactory.SHOPPINGTASK);
        shoppingTask.executeTask();
        shoppingTask.setTaskName("Buy");
        //Then
        Assert.assertEquals(true, shoppingTask.isTaskExecuted());
        Assert.assertEquals("Buy", shoppingTask.getTaskName());
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        DrivingTask drivingTask = (DrivingTask) factory.makeTask(TaskFactory.DRIVINGTASK);
        drivingTask.executeTask();
        drivingTask.setTaskName("Stop");
        //Then
        Assert.assertEquals(true, drivingTask.isTaskExecuted());
        Assert.assertEquals("Stop", drivingTask.getTaskName());
    }
}
