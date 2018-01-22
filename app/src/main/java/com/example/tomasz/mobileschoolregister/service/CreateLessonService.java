package com.example.tomasz.mobileschoolregister.service;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.widget.Toast;

import com.example.tomasz.mobileschoolregister.AttendanceListCheckAcivity;
import com.example.tomasz.mobileschoolregister.api.ApiConnector;
import com.example.tomasz.mobileschoolregister.api.ILessonClient;
import com.example.tomasz.mobileschoolregister.helper.TokenHolder;
import com.example.tomasz.mobileschoolregister.interfaces.ILessonService;
import com.example.tomasz.mobileschoolregister.model.Lesson;
import com.example.tomasz.mobileschoolregister.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tomasz on 20-Jan-18.
 */

public class CreateLessonService implements ILessonService {

    private Lesson lesson;
    private Activity activity;
    public CreateLessonService(Lesson lesson, Activity activity) {
        this.lesson = lesson;
        this.activity = activity;
    }

    @Override
    public Lesson performAction() {
        ILessonClient lessonClient = ApiConnector.createAuthorizedClient(ILessonClient.class, TokenHolder.getInstance().getSecurityToken());
        Call<Lesson> call = lessonClient.post(lesson);

        try {
            Response<Lesson> responseLesson = call.execute();

            if (responseLesson.isSuccessful()){


                activity.runOnUiThread(new Runnable() {
                    public void run() {
                        Toast toast = Toast.makeText(activity, "Lesson has been successfully added", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
                activity.finish();
            }
        } catch (Exception e){
            e.getMessage();
            return  null;
        }
        return null;
    }
}
