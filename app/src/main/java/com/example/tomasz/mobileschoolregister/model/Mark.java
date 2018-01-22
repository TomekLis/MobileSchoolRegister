package com.example.tomasz.mobileschoolregister.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public class Mark extends StudentActivity implements Parcelable{
    @SerializedName("MarkValue")
    private MarkValue markValue;
    @SerializedName("Importance")
    private Importance importance;

    public Mark(int lessonId, String studentId, Lesson lesson, Student student) {
        super(lessonId, studentId, lesson, student);
    }

    protected Mark(Parcel in) {
    }

    public static final Creator<Mark> CREATOR = new Creator<Mark>() {
        @Override
        public Mark createFromParcel(Parcel in) {
            return new Mark(in);
        }

        @Override
        public Mark[] newArray(int size) {
            return new Mark[size];
        }
    };

    public MarkValue getMarkValue() {
        return markValue;
    }

    public void setMarkValue(MarkValue markValue) {
        this.markValue = markValue;
    }

    public Importance getImportance() {
        return importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
