package com.example.tomasz.mobileschoolregister.api;

import com.example.tomasz.mobileschoolregister.model.Student;
import com.example.tomasz.mobileschoolregister.model.Teacher;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Tomasz on 20-Jan-18.
 */

public interface IStudentClient {
    @GET("/MobileSchoolRegisterAppApi/courses/GetStudentsByCourseId/{id}")
    Call<List<Student>> getStudentsByCourseId(@Path("id") int courseId);

}
