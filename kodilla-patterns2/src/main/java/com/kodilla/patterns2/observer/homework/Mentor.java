package com.kodilla.patterns2.observer.homework;

public class Mentor implements MentorObserver {
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(Student student) {
        System.out.println(mentorName + ": New solution added by " + student.getStudentName() + "\n" +
                " Number of exercises to check: " + student.getExercise().size() + "\n" +
                " Exercises to check: ");
        student.getExercise().forEach(System.out::println);
        updateCount++;
    }

    @Override
    public String getExerciseToCheck(Student student) {
        System.out.println("Checking exercise " + student.getExercise().peek());
        return student.getExercise().peek();
    }

    @Override
    public void submitExercise(Student student) {
        System.out.println("Exercise: [" + student.getExercise().peek() + "] Submitted");
        notifyStudent(student.getStudentName(), student.getExercise().peek());
        student.getExercise().poll();
    }

    @Override
    public void notifyStudent(String studentName, String exercise) {
        System.out.println(studentName + " : " + exercise + " was submitted by " + mentorName);
    }

    public int getUpdateCount() {
        return updateCount;
    }
}