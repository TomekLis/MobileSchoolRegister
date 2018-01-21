package com.example.tomasz.mobileschoolregister.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class Course implements Parcelable {
    private int id;
    private String name;
    private String teacherId;
    private int studentsGroupId;
    private Teacher teacher;
    private StudentGroup studentGroup;
    private List<DaySchedule> daySchedules;

    private String room;

    public Course(){}
    protected Course(Parcel in) {
        id = in.readInt();
        name = in.readString();
        teacherId = in.readString();
        studentsGroupId = in.readInt();
        teacher = in.readParcelable(Teacher.class.getClassLoader());
        studentGroup = in.readParcelable(StudentGroup.class.getClassLoader());
        daySchedules = in.createTypedArrayList(DaySchedule.CREATOR);
        room = in.readString();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
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

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentsGroupId() {
        return studentsGroupId;
    }

    public void setStudentsGroupId(int studentsGroupId) {
        this.studentsGroupId = studentsGroupId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public List<DaySchedule> getDaySchedules() {
        return daySchedules;
    }

    public void setDaySchedules(List<DaySchedule> daySchedules) {
        this.daySchedules = daySchedules;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(teacherId);
        parcel.writeInt(studentsGroupId);
        parcel.writeParcelable(teacher, i);
        parcel.writeParcelable(studentGroup, i);
        parcel.writeTypedList(daySchedules);
        parcel.writeString(room);
    }
}
