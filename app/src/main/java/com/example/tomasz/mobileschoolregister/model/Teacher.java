package com.example.tomasz.mobileschoolregister.model;

import java.util.List;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class Teacher extends User {

    private List<Course> courses;

    public Teacher(String id, String userName, String firstName, String lastName) {
        super(id, userName, firstName, lastName);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
