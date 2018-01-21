package com.example.tomasz.mobileschoolregister.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class StudentGroup implements Parcelable {
    private int id;
    private String name;
    private int grade;
    private ArrayList<Student> students;

    public StudentGroup(){}
    protected StudentGroup(Parcel in) {
        id = in.readInt();
        name = in.readString();
        grade = in.readInt();
        students = in.createTypedArrayList(Student.CREATOR);
    }

    public static final Creator<StudentGroup> CREATOR = new Creator<StudentGroup>() {
        @Override
        public StudentGroup createFromParcel(Parcel in) {
            return new StudentGroup(in);
        }

        @Override
        public StudentGroup[] newArray(int size) {
            return new StudentGroup[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(grade);
        parcel.writeTypedList(students);
    }
}
