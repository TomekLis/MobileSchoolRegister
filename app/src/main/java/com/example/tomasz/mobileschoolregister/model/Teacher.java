package com.example.tomasz.mobileschoolregister.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class Teacher extends User {

    private ArrayList<Course> upcomingCourses;

    public Teacher(String id, String userName, String fullName, String firstName, String lastName, String email, String phoneNumber) {
        super(id, userName, fullName, firstName, lastName, email, phoneNumber);
    }


    public ArrayList<Course> getUpcomingCourses() {
        return upcomingCourses;
    }

    public void setUpcomingCourses(ArrayList<Course> upcomingCourses) {
        this.upcomingCourses = upcomingCourses;
    }
}
