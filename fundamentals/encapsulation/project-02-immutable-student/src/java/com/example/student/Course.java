package com.example.student;

public class Course {
    private String name;
    private int credits;

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() { return name; }
    public int getCredits() { return credits; }

    public void setName(String name) { this.name = name; }
    public void setCredits(int credits) { this.credits = credits; }

    @Override
    public String toString() {
        return name + " (" + credits + " credits)";
    }
}