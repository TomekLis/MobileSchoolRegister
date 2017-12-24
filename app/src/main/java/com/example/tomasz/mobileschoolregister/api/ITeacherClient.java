package com.example.tomasz.mobileschoolregister.api;

import com.example.tomasz.mobileschoolregister.model.Teacher;

import retrofit2.Call;

/**
 * Created by Tomasz on 23-Dec-17.
 */

public interface ITeacherClient {

    Call<Teacher> getTeacherBasicData(String accessToken, String userId);
}
