package com.example.tomasz.mobileschoolregister.api;

import com.example.tomasz.mobileschoolregister.model.Teacher;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public interface ITeacherClient {

    @GET("/MobileSchoolRegisterAppApi/api/teachers/0937750b-c270-4c33-b8be-1adc38d465be")
    Call<Teacher> getTeacherBasicData();
}
