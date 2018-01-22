package com.example.tomasz.mobileschoolregister.service;

import android.os.AsyncTask;

import com.example.tomasz.mobileschoolregister.api.ApiConnector;
import com.example.tomasz.mobileschoolregister.api.ITeacherClient;
import com.example.tomasz.mobileschoolregister.helper.TokenHolder;
import com.example.tomasz.mobileschoolregister.interfaces.IFetchDataCallback;
import com.example.tomasz.mobileschoolregister.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Tomasz on 21-Jan-18.
 */

public class StudentActivityService extends AsyncTask<String, Void, List<Student>>{
    private IFetchDataCallback fetchDataCallback;
    private String teacherId;

    public StudentActivityService(IFetchDataCallback fetchDataCallback, String teacherId) {
        this.fetchDataCallback = fetchDataCallback;
        this.teacherId =  teacherId;
    }

    private List<Student> retrieveStudentDataWithActivity(){
        ITeacherClient teacherClient = ApiConnector.createAuthorizedClient(ITeacherClient.class, TokenHolder.getInstance().getSecurityToken());
        Call<List<Student>> call = teacherClient.getStudentsByTeacherId(teacherId);
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
        return retrieveStudentDataWithActivity();
    }
    @Override
    protected void onPostExecute(List<Student> students){
        super.onPostExecute(students);
        // pass the result to the callback function
        fetchDataCallback.fetchDataCallback(students);
    }
}
