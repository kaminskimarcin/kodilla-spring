package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;

public class Student implements ExerciseObservable{

    private ArrayDeque<String> exercises;
    private MentorObserver mentor;
    private String studentName;

    public Student(MentorObserver mentor, String studentName) {
        exercises = new ArrayDeque<>();
        this.mentor = mentor;
        this.studentName = studentName;
    }

    public void addExercise(String exercise) {
        exercises.offer(exercise);
        notifyMentor();
    }


    @Override
    public void notifyMentor() {
        mentor.update(this);
    }



    public ArrayDeque<String> getExercise() {
        return exercises;
    }

    public MentorObserver getMentor() {
        return mentor;
    }

    public String getStudentName() {
        return studentName;
    }
}