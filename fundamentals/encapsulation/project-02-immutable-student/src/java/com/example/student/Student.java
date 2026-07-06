package com.example.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An immutable Student class.
 * - All fields are final and private.
 * - No setters.
 * - Defensive copying for mutable fields (List<Course>).
 * - The class is final to prevent subclassing (which could break immutability).
 */
public final class Student {
    private final String id;
    private final String name;
    private final int age;
    private final List<Course> courses;  // mutable type – must protect!

    public Student(String id, String name, int age, List<Course> courses) {
        // Validate inputs
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (courses == null) {
            throw new IllegalArgumentException("Courses list cannot be null");
        }

        this.id = id;
        this.name = name;
        this.age = age;

        // DEFENSIVE COPY: create a new ArrayList from the input
        // so that external changes to the original list don't affect this object.
        this.courses = new ArrayList<>(courses);
    }

    // Getters – return copies (or unmodifiable views) to protect internal state
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    // Return an unmodifiable view – the caller cannot add/remove courses
    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    // Convenience method to get course count without exposing the list
    public int getCourseCount() {
        return courses.size();
    }

    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', age=" + age +
                ", courses=" + courses + "}";
    }
}