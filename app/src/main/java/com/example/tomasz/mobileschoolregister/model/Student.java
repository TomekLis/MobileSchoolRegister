package com.example.tomasz.mobileschoolregister.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class Student extends User implements Parcelable{

    private int age;
    private int studentsGroupId;
    private StudentGroup studentGroup;

    private List<Mark> marks;

    private List<Attendance> attendances;
    public Student(String id, String userName, String fullName, String firstName, String lastName, String email, String phoneNumber, int age, int studentsGroupId, StudentGroup studentGroup, List<Mark> marks, List<Attendance> attendances) {
        super(id, userName, fullName, firstName, lastName, email, phoneNumber);
        this.age = age;
        this.studentsGroupId = studentsGroupId;
        this.studentGroup = studentGroup;
        this.marks = marks;
        this.attendances = attendances;
    }

    protected Student(Parcel in) {
        super();
        age = in.readInt();
        studentsGroupId = in.readInt();
        studentGroup = in.readParcelable(StudentGroup.class.getClassLoader());
        marks = in.createTypedArrayList(Mark.CREATOR);
        attendances = in.createTypedArrayList(Attendance.CREATOR);
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentsGroupId() {
        return studentsGroupId;
    }

    public void setStudentsGroupId(int studentsGroupId) {
        this.studentsGroupId = studentsGroupId;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(age);
        parcel.writeInt(studentsGroupId);
        parcel.writeParcelable(studentGroup, i);
        parcel.writeTypedList(marks);
        parcel.writeTypedList(attendances);
    }
}
