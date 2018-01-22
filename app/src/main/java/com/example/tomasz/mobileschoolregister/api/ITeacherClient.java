package com.example.tomasz.mobileschoolregister.api;

import com.example.tomasz.mobileschoolregister.model.Student;
import com.example.tomasz.mobileschoolregister.model.Teacher;

import java.util.ArrayList;
import java.util.List;

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
    @GET("/MobileSchoolRegisterAppApi/teachers/GetStudentsByTeacherId/{id}")
    Call<List<Student>> getStudentsByTeacherId(@Path("id") String teacherId);

}
