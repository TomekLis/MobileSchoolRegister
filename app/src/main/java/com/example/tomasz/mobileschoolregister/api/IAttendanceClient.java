package com.example.tomasz.mobileschoolregister.api;

import com.example.tomasz.mobileschoolregister.model.Attendance;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Tomasz on 21-Jan-18.
 */

public interface IAttendanceClient {
    @PUT("/MobileSchoolRegisterAppApi/api/attendances/{id}")
    Call<Attendance> put(@Body Attendance attendance, @Path("id") int id);

    @DELETE("/MobileSchoolRegisterAppApi/api/attendances/{id}")
    Call<Void> delete(@Path("id") int id);
}
