package com.example.tomasz.mobileschoolregister.service;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.tomasz.mobileschoolregister.api.ApiConnector;
import com.example.tomasz.mobileschoolregister.api.IAttendanceClient;
import com.example.tomasz.mobileschoolregister.helper.TokenHolder;
import com.example.tomasz.mobileschoolregister.interfaces.IFetchDataCallback;
import com.example.tomasz.mobileschoolregister.model.Attendance;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Tomasz on 21-Jan-18.
 */

public class DeleteAttendanceService extends AsyncTask<String, Void, Void> {
    IFetchDataCallback fetchDataCallback;
    private Attendance attendance;
    private Activity activity;


    public DeleteAttendanceService(IFetchDataCallback fetchDataCallback, Attendance attendance, Activity activity){
        this.fetchDataCallback = fetchDataCallback;
        this.attendance = attendance;
        this.activity = activity;
    }
    private Void deleteAttendanceData(){
        IAttendanceClient attendanceClient = ApiConnector.createAuthorizedClient(IAttendanceClient.class, TokenHolder.getInstance().getSecurityToken());
        Call<Void> call = attendanceClient.delete(attendance.getId());
        try {
            Response<Void> responseAttendance = call.execute();
            if (responseAttendance.isSuccessful()){
                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        Toast toast = Toast.makeText(activity, "Attendance has been successfully deleted", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                activity.finish();
                return null;
            }
        } catch (Exception e){
            return  null;
        }
        return null;
    }

    @Override
    protected Void doInBackground(String... strings) {
        return deleteAttendanceData();
    }
}
