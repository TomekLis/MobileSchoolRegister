package com.example.tomasz.mobileschoolregister.service;

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

public class TeacherService {

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("http://192.168.55.108/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());
    Retrofit retrofit = builder.build();

    private ITeacherClient teacherClient = retrofit.create(ITeacherClient.class);

    public Teacher retreiveTeacherBasicData(Token token) throws Exception{
        Call<Teacher> call = teacherClient.getTeacherBasicData(token.getAccessToken(),token.getUserId());

        try {
            Response<Teacher> responseTeacher = call.execute();

            if (responseTeacher.isSuccessful()){
                return  responseTeacher.body();
            }
        } catch (Exception e){
            return  null;
        }
        return null;
    }
}
