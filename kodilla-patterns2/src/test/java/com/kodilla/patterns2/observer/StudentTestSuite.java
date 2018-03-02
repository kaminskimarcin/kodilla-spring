package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTestSuite {

    @Test
    public void testInformMentor() {
        //Given
        Mentor michal = new Mentor("Michał");
        Mentor marcin = new Mentor("Marcin");

        Student grzegorz = new Student(michal, "Grzegorz");
        Student sandra = new Student(marcin, "Sandra");
        Student pawel = new Student(michal, "Paweł");

        //When
        grzegorz.addExercise("Observator exercise finished!");
        sandra.addExercise("For loop exercise finished!");
        pawel.addExercise("All exercises for design patterns finished");

        //Then
        assertEquals(2, michal.getUpdateCount());
        assertEquals(1, marcin.getUpdateCount());
    }

    @Test
    public void testGetExercise() {
        //Given
        Mentor michal = new Mentor("Michał");
        Mentor marcin = new Mentor("Marcin");

        Student grzegorz = new Student(michal, "Grzegorz");
        Student sandra = new Student(marcin, "Sandra");
        Student pawel = new Student(michal, "Paweł");

        //When
        grzegorz.addExercise("Observator exercise finished!");
        grzegorz.addExercise("Test for observator added!");
        sandra.addExercise("For loop exercise finished!");
        pawel.addExercise("All exercises for design patterns finished");

        String exerciseCheckByMichal = michal.getExerciseToCheck(grzegorz);
        String exerciseCheckByMarcin =  marcin.getExerciseToCheck(pawel);

        //Then
        assertEquals("Observator exercise finished!", exerciseCheckByMichal);
        assertEquals("All exercises for design patterns finished", exerciseCheckByMarcin);
    }

    @Test
    public void testSubmitExercise() {
        //Given
        Mentor michal = new Mentor("Michał");
        Mentor marcin = new Mentor("Marcin");

        Student grzegorz = new Student(michal, "Grzegorz");
        Student sandra = new Student(marcin, "Sandra");
        Student pawel = new Student(michal, "Paweł");

        //When
        grzegorz.addExercise("Observator exercise finished!");
        grzegorz.addExercise("Test for observator added!");
        sandra.addExercise("For loop exercise finished!");
        pawel.addExercise("All exercises for design patterns finished");

        michal.submitExercise(grzegorz);
        marcin.submitExercise(pawel);

        //Then
        assertEquals(1, grzegorz.getExercise().size());
        assertEquals(0, pawel.getExercise().size());
    }
}