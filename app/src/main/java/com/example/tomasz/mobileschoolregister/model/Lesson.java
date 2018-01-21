package com.example.tomasz.mobileschoolregister.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class Lesson implements Parcelable {
    private int id;
    private Date date;
    private int courseId;
    private Course course;

    public  Lesson(){}
    protected Lesson(Parcel in) {
        id = in.readInt();
        courseId = in.readInt();
        studentActivities = in.createTypedArrayList(StudentActivity.CREATOR);
    }

    public static final Creator<Lesson> CREATOR = new Creator<Lesson>() {
        @Override
        public Lesson createFromParcel(Parcel in) {
            return new Lesson(in);
        }

        @Override
        public Lesson[] newArray(int size) {
            return new Lesson[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(courseId);
        parcel.writeTypedList(studentActivities);
    }
}
