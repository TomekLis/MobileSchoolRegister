package com.example.tomasz.mobileschoolregister.api;

import com.example.tomasz.mobileschoolregister.model.Lesson;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Tomasz on 20-Jan-18.
 */

public interface ILessonClient {
    @POST("/MobileSchoolRegisterAppApi/api/lessons")
    Call<Lesson> post(@Body Lesson lesson);
}
