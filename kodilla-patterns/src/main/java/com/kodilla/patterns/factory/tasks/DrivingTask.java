package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task{
    private String taskName;
    private String where;
    private String using;
    private boolean isTaskExecuted = false;

    public DrivingTask() {
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public void setUsing(String using) {
        this.using = using;
    }

    public void setTaskExecuted(boolean taskExecuted) {
        isTaskExecuted = taskExecuted;
    }

    @Override
    public String executeTask() {
        isTaskExecuted = true;
        return "Executing driving task";
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
