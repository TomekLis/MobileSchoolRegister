package com.example.tomasz.mobileschoolregister.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tomasz on 23-Dec-17.
 */

enum Importance {
    @SerializedName("0")
    Exam,
    @SerializedName("1")
    ClassExam,
    @SerializedName("2")
    Test,
    @SerializedName("3")
    Quiz
}
