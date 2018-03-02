package com.kodilla.patterns2.observer.homework;

public interface MentorObserver {

    void update(Student student);
    String getExerciseToCheck(Student student);
    void submitExercise(Student student);
    void notifyStudent(String studentName, String exercise);
}