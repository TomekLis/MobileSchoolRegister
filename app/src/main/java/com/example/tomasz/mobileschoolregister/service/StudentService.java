package com.example.tomasz.mobileschoolregister.service;

import android.os.AsyncTask;

import com.example.tomasz.mobileschoolregister.api.ApiConnector;
import com.example.tomasz.mobileschoolregister.api.IStudentClient;
import com.example.tomasz.mobileschoolregister.helper.Token;
import com.example.tomasz.mobileschoolregister.interfaces.IFetchDataCallback;
import com.example.tomasz.mobileschoolregister.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Tomasz on 20-Jan-18.
 */

public class StudentService extends AsyncTask<String, Void, List<Student>> {

    private Token token;
    IFetchDataCallback fetchDataCallback;

    public StudentService(Token token, IFetchDataCallback fetchDataCallback){
        this.token = token;
        this.fetchDataCallback = fetchDataCallback;
    }

    private List<Student> retrieveStudentsByBasicData() {
        IStudentClient studentClient = ApiConnector.createAuthorizedClient(IStudentClient.class, token);
        Call<List<Student>> call = studentClient.getStudentsByCourseId(1);

        try {
            Response<List<Student>> responseStudents = call.execute();

            if (responseStudents.isSuccessful()){
                return  responseStudents.body();
            }
        } catch (Exception e){
            return  null;
        }
        return null;
    }

    @Override
    protected List<Student> doInBackground(String... strings) {
        return retrieveStudentsByBasicData();
    }

    @Override
    protected void onPostExecute(List<Student> students){
        super.onPostExecute(students);
        // pass the result to the callback function
        fetchDataCallback.fetchDataCallback(students);
    }
} 
