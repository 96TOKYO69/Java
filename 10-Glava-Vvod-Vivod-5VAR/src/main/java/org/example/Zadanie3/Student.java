package org.example.Zadanie3;

public class Student {
    private String lastName;
    private double averageScore;

    public Student(String lastName, double averageScore) {
        this.lastName = lastName;
        this.averageScore = averageScore;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAverageScore() {
        return averageScore;
    }

    @Override
    public String toString() {
        return lastName + " (" + averageScore + ")";
    }
}
