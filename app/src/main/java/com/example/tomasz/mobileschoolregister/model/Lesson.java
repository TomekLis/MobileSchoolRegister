package com.example.tomasz.mobileschoolregister.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class Lesson {
    private int id;
    private Date date;
    private int courseId;
    private Course course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<StudentActivity> getStudentActivities() {
        return studentActivities;
    }

    public void setStudentActivities(List<StudentActivity> studentActivities) {
        this.studentActivities = studentActivities;
    }

    private List<StudentActivity> studentActivities;
}
