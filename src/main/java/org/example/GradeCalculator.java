package org.example;

public class GradeCalculator {
    public String getGrade(int score) {
        String grade ;
        if (score < 0) {
            throw new IllegalArgumentException("Invalid Score");
        } else if (score < 60) {
            grade = "E";
        } else if (score < 70) {
            grade = "D";
        } else if (score < 80) {
            grade = "C";
        } else if (score < 90) {
            grade = "B";
        } else {
            grade = "A";
        }

        return grade;
    }
}
