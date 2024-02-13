package com.example.user.javacoretraining.collections;

import androidx.annotation.NonNull;

public class Course {

    private final String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
