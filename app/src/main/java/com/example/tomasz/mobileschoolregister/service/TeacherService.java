package com.example.tomasz.mobileschoolregister.service;

import android.os.AsyncTask;

import com.example.tomasz.mobileschoolregister.api.ApiConnector;
import com.example.tomasz.mobileschoolregister.api.ITeacherClient;
import com.example.tomasz.mobileschoolregister.helper.Token;
import com.example.tomasz.mobileschoolregister.helper.TokenHolder;
import com.example.tomasz.mobileschoolregister.interfaces.IFetchDataCallback;
import com.example.tomasz.mobileschoolregister.model.Teacher;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Tomasz on 24-Dec-17.
 */

public class TeacherService extends AsyncTask<String, Void, Teacher> {

    IFetchDataCallback fetchDataCallback;

    public TeacherService(Token token, IFetchDataCallback fetchDataCallback){
        this.fetchDataCallback = fetchDataCallback;
    }

    private Teacher retrieveTeacherBasicData() {
        ITeacherClient teacherClient = ApiConnector.createAuthorizedClient(ITeacherClient.class, TokenHolder.getInstance().getSecurityToken());
        Call<Teacher> call = teacherClient.getTeacherBasicData(TokenHolder.getInstance().getSecurityToken().getUserId());

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

    @Override
    protected Teacher doInBackground(String... strings) {
        return retrieveTeacherBasicData();
    }

    @Override
    protected void onPostExecute(Teacher teacher){
        super.onPostExecute(teacher);
        // pass the result to the callback function
        fetchDataCallback.fetchDataCallback(teacher);
    }
}
