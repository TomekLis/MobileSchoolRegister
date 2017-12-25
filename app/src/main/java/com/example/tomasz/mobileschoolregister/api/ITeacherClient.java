package com.example.tomasz.mobileschoolregister.api;

import com.example.tomasz.mobileschoolregister.model.Teacher;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public interface ITeacherClient {

    @GET("/MobileSchoolRegisterAppApi/api/teachers/{id}")
    Call<Teacher> getTeacherBasicData(@Path("id") String teacherId);
}
