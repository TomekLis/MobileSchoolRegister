package com.example.tomasz.mobileschoolregister.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class StudentActivity implements Parcelable{
    private int id;
    private int lessonId;
    private String studentId;
    private Lesson lesson;
    private Student student;

    public StudentActivity(int lessonId, String studentId, Lesson lesson, Student student) {
        this.lessonId = lessonId;
        this.studentId = studentId;
        this.lesson = lesson;
        this.student = student;
    }

    protected StudentActivity(Parcel in) {
        id = in.readInt();
        lessonId = in.readInt();
        studentId = in.readString();
        lesson = in.readParcelable(Lesson.class.getClassLoader());
        student = in.readParcelable(Student.class.getClassLoader());
    }

    public static final Creator<StudentActivity> CREATOR = new Creator<StudentActivity>() {
        @Override
        public StudentActivity createFromParcel(Parcel in) {
            return new StudentActivity(in);
        }

        @Override
        public StudentActivity[] newArray(int size) {
            return new StudentActivity[size];
        }
    };

    public StudentActivity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(lessonId);
        parcel.writeString(studentId);
        parcel.writeParcelable(lesson, i);
        parcel.writeParcelable(student, i);
    }
}
