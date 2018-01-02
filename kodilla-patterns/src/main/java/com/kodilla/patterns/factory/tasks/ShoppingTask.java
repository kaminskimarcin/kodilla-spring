package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private String taskName;
    private String whatToBuy;
    private double quantity;
    private boolean isTaskExecuted = false;

    public ShoppingTask() {
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setWhatToBuy(String whatToBuy) {
        this.whatToBuy = whatToBuy;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setTaskExecuted(boolean taskExecuted) {
        isTaskExecuted = taskExecuted;
    }

    @Override
    public String executeTask() {
        isTaskExecuted = true;
        return "Executing shopping task";
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
