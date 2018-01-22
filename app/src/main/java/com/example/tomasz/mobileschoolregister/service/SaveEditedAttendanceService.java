package com.example.tomasz.mobileschoolregister.service;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.tomasz.mobileschoolregister.api.ApiConnector;
import com.example.tomasz.mobileschoolregister.api.IAttendanceClient;
import com.example.tomasz.mobileschoolregister.helper.TokenHolder;
import com.example.tomasz.mobileschoolregister.interfaces.IFetchDataCallback;
import com.example.tomasz.mobileschoolregister.model.Attendance;
import com.example.tomasz.mobileschoolregister.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Tomasz on 21-Jan-18.
 */

public class SaveEditedAttendanceService extends AsyncTask<String, Void, Attendance> {
    IFetchDataCallback fetchDataCallback;
    private Attendance attendance;
    private Activity activity;


    public SaveEditedAttendanceService(IFetchDataCallback fetchDataCallback, Attendance attendance, Activity activity){
        this.fetchDataCallback = fetchDataCallback;
        this.attendance = attendance;
        this.activity = activity;

    }
    private Attendance saveAttendanceData(){
        IAttendanceClient attendanceClient = ApiConnector.createAuthorizedClient(IAttendanceClient.class, TokenHolder.getInstance().getSecurityToken());
        Call<Attendance> call = attendanceClient.put(attendance, attendance.getId());
        try {
            Response<Attendance> responseAttendance = call.execute();
            if (responseAttendance.isSuccessful()){
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        Toast toast = Toast.makeText(activity, "Attendance has been successfully saved", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                activity.finish();
                return  responseAttendance.body();
            }
        } catch (Exception e){
            return  null;
        }
        return null;
    }

    @Override
    protected Attendance doInBackground(String... strings) {
        return saveAttendanceData();
    }
    @Override
    protected void onPostExecute(Attendance attendance){
        super.onPostExecute(attendance);
        // pass the result to the callback function
        fetchDataCallback.fetchDataCallback(attendance);
    }
}
