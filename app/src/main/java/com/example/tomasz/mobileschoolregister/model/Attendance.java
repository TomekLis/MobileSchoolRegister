package com.example.tomasz.mobileschoolregister.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class Attendance extends StudentActivity implements Parcelable{
    @SerializedName("WasPresent")
    private boolean wasPresent;

    public Attendance(int lessonId, String studentId, Lesson lesson, Student student, boolean wasPresent) {
        super(lessonId, studentId, lesson, student);
        this.wasPresent = wasPresent;
    }
    public Attendance(){

    }

    protected Attendance(Parcel in) {
        super(in);
//        super(in.readInt(), in.readString(), (Lesson) in.readParcelable(Lesson.class.getClassLoader()),(Student) in.readParcelable(Student.class.getClassLoader()));
        wasPresent = in.readByte() != 0;
    }

    public static final Creator<Attendance> CREATOR = new Creator<Attendance>() {
        @Override
        public Attendance createFromParcel(Parcel in) {
            return new Attendance(in);
        }

        @Override
        public Attendance[] newArray(int size) {
            return new Attendance[size];
        }
    };

    public boolean getWasPresent() {
        return wasPresent;
    }

    public void setWasPresent(boolean wasPresent) {
        this.wasPresent = wasPresent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeInt(getLessonId());
        parcel.writeString(getStudentId());
        parcel.writeParcelable(getLesson(), i);
        parcel.writeParcelable(getStudent(), i);
        parcel.writeByte((byte) (wasPresent ? 1 : 0));
    }
}
