package com.example.tomasz.mobileschoolregister.service;

import android.os.AsyncTask;

import com.example.tomasz.mobileschoolregister.api.ApiConnector;
import com.example.tomasz.mobileschoolregister.api.IAuthenticationClient;
import com.example.tomasz.mobileschoolregister.api.ITeacherClient;
import com.example.tomasz.mobileschoolregister.helper.Token;
import com.example.tomasz.mobileschoolregister.model.Teacher;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tomasz on 24-Dec-17.
 */

public class TeacherService extends AsyncTask<String, Void, Teacher> {

    private Token token;
    public TeacherService(Token token){
        this.token = token;
    }

    private Teacher retrieveTeacherBasicData() {
        ITeacherClient teacherClient = ApiConnector.createAuthrizedClient(ITeacherClient.class, token);
        Call<Teacher> call = teacherClient.getTeacherBasicData();

        try {
            Response<Teacher> responseTeacher = call.execute();

            if (responseTeacher.isSuccessful()){
                return  null;
            }
        } catch (Exception e){
            return  null;
        }
        return null;
    }

    @Override
    protected Teacher doInBackground(String... strings) {
        return retrieveTeacherBasicData();
    }
}
