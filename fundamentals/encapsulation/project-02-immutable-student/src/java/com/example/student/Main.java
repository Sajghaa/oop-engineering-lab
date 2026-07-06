package com.example.student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a mutable list of courses
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Math", 3));
        courseList.add(new Course("Physics", 4));

        // Create an immutable Student
        Student alice = new Student("S001", "Alice", 20, courseList);
        System.out.println("Original student: " + alice);

        // 1. Try to modify the original list *after* creating the Student
        courseList.add(new Course("Chemistry", 3));
        System.out.println("After modifying original list:");
        System.out.println("Student's courses: " + alice.getCourses());
        // Notice: Chemistry does NOT appear – defensive copy worked!

        // 2. Try to modify the courses via the getter (should fail)
        try {
            alice.getCourses().add(new Course("Biology", 3));
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot add via getter – unmodifiable list! " + e);
        }

        // 3. Try to change fields – no setters, so we can't
        // alice.setName("Bob"); // compilation error – good!

        // 4. Create a new student (different identity) – the only way to "change"
        Student bob = new Student("S002", "Bob", 22, alice.getCourses());
        System.out.println("New student Bob: " + bob);

        // 5. Demonstrate that Bob's courses are independent
        // (they are a copy, so modifying Alice's courses wouldn't affect Bob)
        // Since Alice's list is unmodifiable, we can't modify it anyway.
    }
}