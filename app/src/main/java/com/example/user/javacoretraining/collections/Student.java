package com.example.user.javacoretraining.collections;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Student extends Person {

    private int year;
    private int group;
    private HashMap<Course, Integer> grades = new HashMap<>();

    public Student(String lastName, String firstName, String secondName, int birthYear, int year, int group) {
        super(lastName, firstName, secondName, birthYear);
        this.year = year;
        this.group = group;
    }

    public int getYear() {
        return year;
    }

    public int getGroup() {
        return group;
    }

    public HashMap<Course, Integer> getGrades() {
        return grades;
    }

    @NonNull
    @Override
    public String toString() {
        return "Student{" +
                "ФИО=" + getFullName() +
                //", birthYear=" + getBirthYear() +
                ", year=" + year +
                //", group=" + group +
                //", grades=" + printGrades() +
                '}';
    }

    private String printGrades() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Course, Integer> entry : grades.entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
        }
        return sb.toString();
    }

    public double getAverageGrade() {
        int sum = 0, n = 0;
        double avg = 0;

        for (Map.Entry<Course, Integer> entry : grades.entrySet()) {
            sum += entry.getValue();
            n++;
        }
        avg = (double) sum / n;

        return avg;
    }

    public void addGrade(Course course, int grade) {
        grades.put(course, grade);
    }
}
