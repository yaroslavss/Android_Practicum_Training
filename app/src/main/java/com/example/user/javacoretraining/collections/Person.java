package com.example.user.javacoretraining.collections;

public class Person {

    private final String lastName;
    private final String secondName;
    private final String firstName;
    private final int birthYear;

    public Person(String lastName, String firstName, String secondName, int birthday) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthYear = birthday;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + secondName;
    }
}
