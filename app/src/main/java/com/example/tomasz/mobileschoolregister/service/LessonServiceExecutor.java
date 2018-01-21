package com.example.tomasz.mobileschoolregister.service;

import android.os.AsyncTask;

import com.example.tomasz.mobileschoolregister.helper.Token;
import com.example.tomasz.mobileschoolregister.interfaces.IFetchDataCallback;
import com.example.tomasz.mobileschoolregister.interfaces.ILessonService;
import com.example.tomasz.mobileschoolregister.model.Lesson;

/**
 * Created by Tomasz on 20-Jan-18.
 */

public class LessonServiceExecutor extends AsyncTask<String, Void, Lesson> {

    private ILessonService lessonService;

    public LessonServiceExecutor(ILessonService lessonService) {
        this.lessonService = lessonService;
    }

    @Override
    protected Lesson doInBackground(String... strings) {
        return lessonService.performAction();
    }
}
