package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private String taskName;
    private String color;
    private String whatToPaint;
    private boolean isTaskExecuted;

    public PaintingTask() {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWhatToPaint(String whatToPaint) {
        this.whatToPaint = whatToPaint;
    }

    public void setTaskExecuted(boolean taskExecuted) {
        isTaskExecuted = taskExecuted;
    }

    @Override
    public String executeTask() {
        isTaskExecuted = true;
        return "Execute Painting Task";
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
