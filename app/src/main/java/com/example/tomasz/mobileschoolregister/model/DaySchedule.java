package com.example.tomasz.mobileschoolregister.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class DaySchedule implements Parcelable {
    private int id;
    private Day day;
    private Date startTime;
    private Date endTime;
    private int courseId;
    private Course course;

    protected DaySchedule(Parcel in) {
        id = in.readInt();
        courseId = in.readInt();
    }

    public static final Creator<DaySchedule> CREATOR = new Creator<DaySchedule>() {
        @Override
        public DaySchedule createFromParcel(Parcel in) {
            return new DaySchedule(in);
        }

        @Override
        public DaySchedule[] newArray(int size) {
            return new DaySchedule[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(courseId);
    }
}